package pixi.demos

import pixi.core.{Sprite, Container, Renderer}
import pixi.core.Renderer.Options

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom._

/** PIXI container demo
  * @author Marcelo Serra Castilhos
  */
@JSExport("Container")
object ContainerDemo {
  val renderer = Renderer.autoDetect(800, 600, Options(backgroundColor = 0x1099bb))
  document.body.appendChild(renderer.view)

  // create the root of the scene graph
  var stage = new Container()

  var container = new Container()

  stage.addChild(container)

  for {j <- 0 until 5
       i <- 0 until 5} {
    val bunny = Sprite.fromImage("_assets/basics/bunny.png")
    bunny.x = 40 * i
    bunny.y = 40 * j
    container.addChild(bunny)
  }

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

  def animate(delta: Double = 0) {

    requestAnimationFrame(animate _)

    // render the root container
    renderer.render(stage)
  }

}
