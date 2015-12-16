package pixi.demos

import org.scalajs.dom._
import pixi.core.{Sprite, Container, Renderer}
import pixi.core.Renderer.Options

import scala.scalajs.js.annotation.JSExport

/** Click example
  * @author Marcelo Serra Castilhos
  */
@JSExport("Click")
object Click {
  val renderer = Renderer.autoDetect(800, 600, new Options {
    backgroundColor = 0x1099bb
  })
  document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container()

  val sprite = Sprite.fromImage("_assets/basics/bunny.png")

  sprite.position.set(230, 264)
  sprite.interactive = true
  sprite.on("mousedown", "touchstart") {
    sprite.scale.x += 0.3
    sprite.scale.y += 0.3
  }

  stage.addChild(sprite)


  // start animating
  animate()

  def animate(d: Double = 0) {

    requestAnimationFrame(animate _)

    // render the root container
    renderer.render(stage)
  }
}
