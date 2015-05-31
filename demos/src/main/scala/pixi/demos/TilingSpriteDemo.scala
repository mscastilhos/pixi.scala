package pixi.demos

import org.scalajs.dom._
import pixi.core.{Texture, Container, Renderer}
import pixi.extras.TilingSprite

import scala.scalajs.js.annotation.JSExport


@JSExport("TilingSpriteDemo")
object TilingSpriteDemo {
  val renderer = Renderer.autoDetect(800, 600)
  document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container()

  // create a texture from an image path
  val texture = Texture.fromImage("_assets/p2.jpeg")

  /* create a tiling sprite ...
   * requires a texture, a width and a height
   * in WebGL the image size should preferably be a power of two
   */
  val tilingSprite = new TilingSprite(texture, renderer.width, renderer.height)
  stage.addChild(tilingSprite)

  var count: Double = 0

  animate()

  def animate(d: Double = 0) {

    count += 0.005

    tilingSprite.tileScale.x = 2 + Math.sin(count)
    tilingSprite.tileScale.y = 2 + Math.cos(count)

    tilingSprite.tilePosition.x += 1
    tilingSprite.tilePosition.y += 1

    // render the root container
    renderer.render(stage)

    requestAnimationFrame(animate _)
  }

}
