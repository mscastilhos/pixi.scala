package demos

import org.scalajs.dom
import pixi.core._
import pixi.filters.DisplacementFilter
import pixi.interaction.EventData

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, ScalaJSDefined}

@JSExport("DisplacementMap")
object DisplacementMap {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container()

  stage.interactive = true

  val container = new Container()
  stage.addChild(container)

  // Data for the maggots
  @ScalaJSDefined
  trait MaggotData extends js.Object {
    var direction: Double
    var speed: Double
    var turnSpeed: Double
    var original: Point
  }

  val padding = 100
  val bounds = new Rectangle(-padding, -padding, renderer.width + padding * 2, renderer.height + padding * 2)
  val maggots = for (_ <- 1 to 20) yield {


    val maggot = Sprite.fromImage("_assets/maggot.png").asInstanceOf[Sprite with MaggotData]
    maggot.anchor.set(0.5)
    container.addChild(maggot)

    maggot.direction = Math.random() * Math.PI * 2
    maggot.speed = 1
    maggot.turnSpeed = Math.random() - 0.8

    maggot.position.x = Math.random() * bounds.width
    maggot.position.y = Math.random() * bounds.height

    maggot.scale.set(1 + Math.random() * 0.3)
    val x = maggot.scale.clone()
    maggot.original = maggot.scale.clone()
    // Place the maggot in the list of sprites
    maggot
  }

  val displacementSprite = Sprite.fromImage("_assets/displace.png")
  val displacementFilter = new DisplacementFilter(displacementSprite)

  stage.addChild(displacementSprite)

  container.filters = js.Array(displacementFilter)

  displacementFilter.scale.x = 110
  displacementFilter.scale.y = 110

  val ring = Sprite.fromImage("_assets/ring.png")

  ring.anchor.set(0.5)

  ring.visible = false

  stage.addChild(ring)

  val bg = Sprite.fromImage("_assets/bkg-grass.jpg")
  bg.width = renderer.width
  bg.height = renderer.height

  bg.alpha = 0.4

  container.addChild(bg)

  stage
    .on("mousemove", onPointerMove _)
    .on("touchmove", onPointerMove _)

  def onPointerMove(stage: Container, eventData: EventData): Unit = {
    println("MOVED")
    ring.visible = true

    displacementSprite.x = eventData.data.global.x - 100
    displacementSprite.y = eventData.data.global.y - displacementSprite.height / 2

    ring.position.x = eventData.data.global.x - 25
    ring.position.y = eventData.data.global.y
  }

  var count = 0.0

  animate()

  def animate(d: Double = 0): Unit = {
    count += 0.05

    for (maggot <- maggots) {

      maggot.direction += maggot.turnSpeed * 0.01
      maggot.position.x += Math.sin(maggot.direction) * maggot.speed
      maggot.position.y += Math.cos(maggot.direction) * maggot.speed

      maggot.rotation = -maggot.direction - Math.PI / 2

      maggot.scale.x = maggot.original.x + Math.sin(count) * 0.2

      // wrap the maggots around as the crawl
      if (maggot.position.x < bounds.x) {
        maggot.position.x += bounds.width
      } else if (maggot.position.x > bounds.x + bounds.width) {
        maggot.position.x -= bounds.width
      }

      if (maggot.position.y < bounds.y) {
        maggot.position.y += bounds.height
      } else if (maggot.position.y > bounds.y + bounds.height) {
        maggot.position.y -= bounds.height
      }
    }

    renderer.render(stage)
    dom.requestAnimationFrame(animate _)
  }
}
