package pixi.demos

import org.scalajs.dom
import pixi.core.{Rectangle, Sprite, Container, Renderer}
import pixi.scalajs.UserData.WithUserData

import scala.scalajs.js.annotation.JSExport

@JSExport("BlendModes")
object BlendModes {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  // create a new background sprite
  val background = Sprite.fromImage("_assets/BGrotate.jpg")
  stage.addChild(background)

  // Data associated with the dudes
  case class DudeData(var direction: Double, var turningSpeed: Double, var speed: Double)

  // create an array to store a reference to the dudes
  val dudeArray = for (i <- 0 until 20) yield {
    // create a new Sprite that uses the image name that we just generated as its source
    val dude = Sprite.fromImage("_assets/flowerTop.png")

    dude.anchor.set(0.5)

    // set a random scale for the dude
    dude.scale.set(0.8 + Math.random() * 0.3)

    // finally let"s set the dude to be at a random position...
    dude.position.x = Math.floor(Math.random() * renderer.width)
    dude.position.y = Math.floor(Math.random() * renderer.height)

    // The important bit of this example, this is how you change the default blend mode of the sprite
    dude.blendMode = pixi.Consts.BLEND_MODES.ADD

    // create some extra properties that will control movement
    val data = DudeData(direction = Math.random() * Math.PI * 2,
      turningSpeed = Math.random() - 0.8,
      speed = 2 + Math.random() * 2)

    stage.addChild(dude)

    // finally return the dude with extra powers into the dudeArray so it it can be easily accessed later
    dude.withUserData(data)
  }

  // create a bounding box box for the little dudes
  val dudeBoundsPadding = 100

  val dudeBounds = new Rectangle(-dudeBoundsPadding,
    -dudeBoundsPadding,
    renderer.width + dudeBoundsPadding * 2,
    renderer.height + dudeBoundsPadding * 2)

  var tick = 0.0

  dom.requestAnimationFrame(animate _)


  def animate(d: Double = 0) {
    // iterate through the dudes and update the positions
    for (dude <- dudeArray) {
      dude.userData.direction += dude.userData.turningSpeed * 0.01
      dude.position.x += Math.sin(dude.userData.direction) * dude.userData.speed
      dude.position.y += Math.cos(dude.userData.direction) * dude.userData.speed
      dude.rotation = -dude.userData.direction - Math.PI / 2

      // wrap the dudes by testing their bounds...
      if (dude.position.x < dudeBounds.x) {
        dude.position.x += dudeBounds.width
      } else if (dude.position.x > dudeBounds.x + dudeBounds.width) {
        dude.position.x -= dudeBounds.width
      }

      if (dude.position.y < dudeBounds.y) {
        dude.position.y += dudeBounds.height
      } else if (dude.position.y > dudeBounds.y + dudeBounds.height) {
        dude.position.y -= dudeBounds.height
      }
    }

    // increment the ticker
    tick += 0.1

    // time to render the stage !
    renderer.render(stage)

    // request another animation frame...
    dom.requestAnimationFrame(animate _)
  }

}
