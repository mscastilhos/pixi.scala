package pixi.demos

import org.scalajs.dom
import pixi.core.{Point, Sprite, Container, Renderer}

import scala.scalajs.js.annotation.JSExport

@JSExport("AlphaMask")
object AlphaMask {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  stage.interactive = true

  val bg = Sprite.fromImage("_assets/bkg.jpg")

  stage.addChild(bg)

  val cells = Sprite.fromImage("_assets/cells.png")

  cells.scale.set(1.5,1.5)

  val mask = Sprite.fromImage("_assets/flowerTop.png")
  mask.anchor.set(0.5)
  mask.position.x = 310
  mask.position.y = 190

  cells.mask = mask

  stage.addChild(mask)

  stage.addChild(cells)


  val target = new Point()

  reset()

  def reset (): Unit = {
    target.x = Math.floor(Math.random() * 550)
    target.y = Math.floor(Math.random() * 300)
  }

  dom.requestAnimationFrame(animate _)


  def animate(d: Double) {

    mask.position.x += (target.x - mask.x) * 0.1
    mask.position.y += (target.y - mask.y) * 0.1

    if(Math.abs(mask.x - target.x) < 1) {
      reset()
    }

    renderer.render(stage)
    dom.requestAnimationFrame(animate _)
  }
}
