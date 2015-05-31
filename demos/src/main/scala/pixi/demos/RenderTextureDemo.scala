package pixi.demos

import org.scalajs.dom
import pixi.core._
import pixi.core.Renderer.Options

import scala.scalajs.js.annotation.JSExport

@JSExport("RenderTextureDemo")
object RenderTextureDemo {
  val renderer = Renderer.autoDetect(800, 600, Options(backgroundColor = 0x1099bb))
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  val container = new Container

  stage.addChild(container);

  for {j <- 0 until 5
       i <- 0 until 5} {
    val bunny = Sprite.fromImage("_assets/basics/bunny.png")
    bunny.x = 30 * i
    bunny.y = 30 * j
    bunny.rotation = Math.random() * (Math.PI * 2)
    container.addChild(bunny)
  }


  val rt = new RenderTexture(renderer, 300, 200, Consts.SCALE_MODES.LINEAR, 0.1)

  val sprite = new Sprite(rt)

  sprite.x = 450
  sprite.y = 60
  stage.addChild(sprite)
  /*
   * All the bunnies are added to the container with the addChild method
   * when you do this, all the bunnies become children of the container, and when a container moves,
   * so do all its children.
   * This gives you a lot of flexibility and makes it easier to position elements on the screen
   */
  container.x = 100
  container.y = 60

  // start animating
  animate()

  def animate(d: Double = 0) {

    rt.render(container)

    dom.requestAnimationFrame(animate _)

    // render the root container
    renderer.render(stage)
  }

}
