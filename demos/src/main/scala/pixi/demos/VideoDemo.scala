package pixi.demos

import org.scalajs.dom
import pixi.core.{Sprite, Texture, Container, Renderer}
import pixi.core.Renderer.Options

import scala.scalajs.js.annotation.JSExport

@JSExport("Video")
object VideoDemo {
  val renderer = Renderer.autoDetect(800, 600, Options(transparent = true))
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container()

  // create a video texture from a path
  val texture = Texture.fromVideoUrl("_assets/testVideo.mp4")

  // create a new Sprite using the video texture (yes it's that easy)
  val videoSprite = new Sprite(texture)

  videoSprite.width = renderer.width
  videoSprite.height = renderer.height

  stage.addChild(videoSprite)

  animate()

  def animate(d: Double = 0) {

    // render the stage
    renderer.render(stage)

    dom.requestAnimationFrame(animate _)
  }

}
