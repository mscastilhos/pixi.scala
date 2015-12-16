package pixi.demos

import org.scalajs.dom
import pixi.core.Text.Style
import pixi.core.{Text, Sprite, Container, Renderer}
import pixi.filters.ColorMatrixFilter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport("FilterDemo")
object FilterDemo {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  stage.interactive = true

  val bg = Sprite.fromImage("_assets/BGrotate.jpg")
  bg.anchor.set(0.5)

  bg.position.x = renderer.width / 2
  bg.position.y = renderer.height / 2

  val filter = new ColorMatrixFilter()

  val container = new Container
  container.position.x = renderer.width / 2
  container.position.y = renderer.height / 2

  val bgFront = Sprite.fromImage("_assets/SceneRotate.jpg")
  bgFront.anchor.set(0.5)

  container.addChild(bgFront)

  val light2 = Sprite.fromImage("_assets/LightRotate2.png")
  light2.anchor.set(0.5)
  container.addChild(light2)

  val light1 = Sprite.fromImage("_assets/LightRotate1.png")
  light1.anchor.set(0.5)
  container.addChild(light1)

  val panda = Sprite.fromImage("_assets/panda.png")
  panda.anchor.set(0.5)

  container.addChild(panda)

  stage.addChild(container)

  stage.filters = js.Array(filter)

  var count = 0.0
  var switchy = false

  stage.on("click", "tap") {
    switchy = !switchy

    if (!switchy) {
      stage.filters = js.Array(filter)
    } else {
      stage.filters = null
    }
  }

  val help = new Text("Click to turn filters on / off.", new Style {
    font = "bold 12pt Arial"
    fill = "white"
  })

  help.position.y = renderer.height - 25
  help.position.x = 10

  stage.addChild(help)

  dom.requestAnimationFrame(animate _)

  def animate(d: Double): Unit = {
    bg.rotation += 0.01
    bgFront.rotation -= 0.01

    light1.rotation += 0.02
    light2.rotation += 0.01

    panda.scale.x = 1 + Math.sin(count) * 0.04
    panda.scale.y = 1 + Math.cos(count) * 0.04

    count += 0.1

    val matrix = filter.matrix

    matrix(1) = Math.sin(count) * 3
    matrix(2) = Math.cos(count)
    matrix(3) = Math.cos(count) * 1.5
    matrix(4) = Math.sin(count / 3) * 2
    matrix(5) = Math.sin(count / 2)
    matrix(6) = Math.sin(count / 4)

    renderer.render(stage)
    dom.requestAnimationFrame(animate _)
  }
}
