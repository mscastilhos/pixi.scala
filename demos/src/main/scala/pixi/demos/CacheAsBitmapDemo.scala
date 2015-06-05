package pixi.demos

import org.scalajs.dom
import pixi.core.{Sprite, Container, Renderer}

import scala.scalajs.js.annotation.JSExport
import scala.util.Random

@JSExport("CacheAsBitmap")
object CacheAsBitmapDemo {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  // holder to store aliens
  var aliens: IndexedSeq[Sprite] = _
  val alienFrames = Seq("eggHead.png", "flowerTop.png", "helmlok.png", "skully.png")

  var count = 0.0

  // create an empty container
  val alienContainer = new Container
  alienContainer.position.x = 400
  alienContainer.position.y = 300

  // make the stage interactive
  stage.interactive = true

  stage.addChild(alienContainer)


  // load resources
  val x = pixi.loader.add("spritesheet", "_assets/monsters.json").loadAnd {
    // add a bunch of aliens with textures from image paths
    aliens = for (i <- 0 until 100) yield {
      val frameName = alienFrames(i % 4)

      // create an alien using the frame name..
      val alien = Sprite.fromFrame(frameName)
      alien.tint = Random.nextInt(0xFFFFFF)

      /*
       * fun fact for the day :)
       * another way of doing the above would be
       * val texture = Texture.fromFrame(frameName)
       * val alien = new Sprite(texture)
       */
      alien.position.x = Math.random() * 800 - 400
      alien.position.y = Math.random() * 600 - 300
      alien.anchor.x = 0.5
      alien.anchor.y = 0.5
      alienContainer.addChild(alien)

      alien
    }


    // start animating
    dom.requestAnimationFrame(animate _)
  }

  stage.on("click","tap") {
    alienContainer.cacheAsBitmap = !alienContainer.cacheAsBitmap

    //        feel free to play with what"s below
    //        val sprite = new PIXI.Sprite(alienContainer.generateTexture());
    //        stage.addChild(sprite);
    //        sprite.position.x = Math.random() * 800;
    //        sprite.position.y = Math.random() * 600;
  }

  def animate (d: Double) {
    // let"s rotate the aliens a little bit
    for (alien <- aliens) {
      alien.rotation += 0.1
    }

    count += 0.01

    alienContainer.scale.x = Math.sin(count)
    alienContainer.scale.y = Math.sin(count)

    alienContainer.rotation += 0.01

    // render the stage
    renderer.render(stage)

    dom.requestAnimationFrame(animate _)
  }

}
