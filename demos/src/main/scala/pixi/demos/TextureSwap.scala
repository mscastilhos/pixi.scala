package pixi.demos

import org.scalajs.dom
import pixi.core.{Sprite, Texture, Container, Renderer}

import scala.scalajs.js.annotation.JSExport

@JSExport("TextureSwap")
object TextureSwap {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  var bol = false

  // create a texture from an image path
  val texture = Texture.fromImage("_assets/flowerTop.png")

  // create a second texture
  val secondTexture = Texture.fromImage("_assets/eggHead.png")

  // create a new Sprite using the texture
  val dude = new Sprite(texture)

  // center the sprites anchor point
  dude.anchor.set(0.5)

  // move the sprite to the center of the screen
  dude.position.x = renderer.width / 2
  dude.position.y = renderer.height / 2

  stage.addChild(dude)

  // make the sprite interactive
  dude.interactive = true

  dude.on("click") {
    bol = !bol

    if (bol) {
      dude.texture = secondTexture
    } else {
      dude.texture = texture
    }
  }

  animate()

  def animate(d: Double = 0): Unit = {
    dom.requestAnimationFrame(animate _)

    // just for fun, let"s rotate mr rabbit a little
    dude.rotation += 0.1

    // render the stage
    renderer.render(stage)
  }
}
