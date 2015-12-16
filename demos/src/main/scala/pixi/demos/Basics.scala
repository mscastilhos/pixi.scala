package pixi.demos

import org.scalajs.dom._
import pixi.core.Renderer.Options
import pixi.core.{Sprite, Texture, Container, Renderer}

import scala.scalajs.js.annotation.JSExport

/** Pixi.scala Basics
  * @author Marcelo Serra Castilhos
  */
@JSExport("Basics")
object Basics {
  val renderer = Renderer.autoDetect(800, 600, new Options {
    backgroundColor = 0x1099bb
  })
  document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container()

  // create a texture from an image path
  val texture = Texture.fromImage("_assets/basics/bunny.png")

  // create a new Sprite using the texture
  val bunny = new Sprite(texture)

  // center the sprite's anchor point
  bunny.anchor.x = 0.5
  bunny.anchor.y = 0.5

  // move the sprite to the center of the screen
  bunny.position.x = 200
  bunny.position.y = 150

  stage.addChild(bunny)

  // start animating
  animate()

  def animate(delta: Double = 0) {
    requestAnimationFrame(animate _)

    // just for fun, let's rotate mr rabbit a little
    bunny.rotation += 0.1

    // render the container
    renderer.render(stage)
  }
}
