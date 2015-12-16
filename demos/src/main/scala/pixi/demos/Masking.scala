package pixi.demos

import org.scalajs.dom
import pixi.core._
import pixi.core.Renderer.Options

import scala.scalajs.js.annotation.JSExport

@JSExport("Masking")
object Masking {
  val renderer = Renderer.autoDetect(800, 600, new Options {
    antialias = true
  })
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  stage.interactive = true

  val bg = Sprite.fromImage("_assets/BGrotate.jpg")

  bg.anchor.x = 0.5
  bg.anchor.y = 0.5

  bg.position.x = renderer.width / 2
  bg.position.y = renderer.height / 2

  stage.addChild(bg)

  val container = new Container
  container.position.x = renderer.width / 2
  container.position.y = renderer.height / 2

  // add a bunch of sprites

  val bgFront = Sprite.fromImage("_assets/SceneRotate.jpg")
  bgFront.anchor.x = 0.5
  bgFront.anchor.y = 0.5

  container.addChild(bgFront)

  val light2 = Sprite.fromImage("_assets/LightRotate2.png")
  light2.anchor.x = 0.5
  light2.anchor.y = 0.5
  container.addChild(light2)

  val light1 = Sprite.fromImage("_assets/LightRotate1.png")
  light1.anchor.x = 0.5
  light1.anchor.y = 0.5
  container.addChild(light1)

  val panda = Sprite.fromImage("_assets/panda.png")
  panda.anchor.x = 0.5
  panda.anchor.y = 0.5

  container.addChild(panda)

  stage.addChild(container)

  // let"s create a moving shape
  val thing = new Graphics
  stage.addChild(thing)
  thing.position.x = renderer.width / 2
  thing.position.y = renderer.height / 2
  thing.lineStyle(0)


  container.mask = thing

  var count = 0.0

  stage.on("click", "tap") {
    if (container.mask == null) {
      // null == >:(
      container.mask = thing
    } else {
      container.mask = null
    }
  }

  val help = new Text("Click to turn masking on / off.", new Text.Style {
    font = "bold 12pt Arial"
    fill = "white"
  })
  help.position.y = renderer.height - 26
  help.position.x = 10
  stage.addChild(help)

  animate()

  def animate(d: Double = 0) {
    bg.rotation += 0.01
    bgFront.rotation -= 0.01

    light1.rotation += 0.02
    light2.rotation += 0.01

    panda.scale.x = 1 + Math.sin(count) * 0.04
    panda.scale.y = 1 + Math.cos(count) * 0.04

    count += 0.1

    thing.clear()

    thing.beginFill(0x8bc5ff, 0.4)
    thing.moveTo(-120 + Math.sin(count) * 20, -100 + Math.cos(count) * 20)
    thing.lineTo(-320 + Math.cos(count) * 20, 100 + Math.sin(count) * 20)
    thing.lineTo(120 + Math.cos(count) * 20, -100 + Math.sin(count) * 20)
    thing.lineTo(120 + Math.sin(count) * 20, 100 + Math.cos(count) * 20)
    thing.lineTo(-120 + Math.cos(count) * 20, 100 + Math.sin(count) * 20)
    thing.lineTo(-120 + Math.sin(count) * 20, -300 + Math.cos(count) * 20)
    thing.lineTo(-320 + Math.sin(count) * 20, -100 + Math.cos(count) * 20)
    thing.rotation = count * 0.1


    renderer.render(stage)
    dom.requestAnimationFrame(animate _)
  }

}
