package pixi.demos

import org.scalajs.dom._
import pixi.core.Renderer.Options
import pixi.core.{Container, Renderer, Sprite, Texture}

import scala.scalajs.js.annotation.JSExport

/** Pixi.scala Basics
  * @author Marcelo Serra Castilhos
  */
@JSExport("TransparentBackground")
object TransparentBackground {
  val renderer = Renderer.autoDetect(800, 600, Options( transparent = true ))
  document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  // create a new Sprite from an image path.
  val bunny = Sprite.fromImage("_assets/bunny.png")

  // center the sprite's anchor point
  bunny.anchor.set(0.5)

  // move the sprite to the center of the screen
  bunny.position.x = 200
  bunny.position.y = 150

  stage.addChild(bunny)

  requestAnimationFrame(animate _)

  def animate(d: Double = 0) {
    requestAnimationFrame(animate _)

    // just for fun, let's rotate mr rabbit a little
    bunny.rotation += 0.1

    // render the stage
    renderer.render(stage)
  }

}
