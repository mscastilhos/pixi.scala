package pixi.demos

import org.scalajs.dom
import pixi.core.{Sprite, Container, Renderer}
import pixi.filters.BlurFilter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport("Blur")
object Blur {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  val bg = Sprite.fromImage("_assets/depth_blur_BG.jpg")
  bg.width = renderer.width
  bg.height = renderer.height
  stage.addChild(bg)

  val littleDudes = Sprite.fromImage("_assets/depth_blur_dudes.jpg")
  littleDudes.position.x = (renderer.width / 2) - 315
  littleDudes.position.y = 200
  stage.addChild(littleDudes)

  val littleRobot = Sprite.fromImage("_assets/depth_blur_moby.jpg")
  littleRobot.position.x = (renderer.width / 2) - 200
  littleRobot.position.y = 100
  stage.addChild(littleRobot)

  val blurFilter1 = new BlurFilter()
  val blurFilter2 = new BlurFilter()

  littleDudes.filters = js.Array(blurFilter1)
  littleRobot.filters = js.Array(blurFilter2)

  var count = 0.0

  dom.requestAnimationFrame(animate _)

  def animate(d: Double) {

    count += 0.005

    val blurAmount = Math.cos(count)
    val blurAmount2 = Math.sin(count)


    blurFilter1.blur = 20 * blurAmount
    blurFilter2.blur = 20 * blurAmount2
    renderer.render(stage)
    dom.requestAnimationFrame(animate _)
  }
}
