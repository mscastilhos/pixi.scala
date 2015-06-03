package pixi.demos

import org.scalajs.dom
import pixi.core.{Rectangle, Sprite, Container, Renderer}

import scala.scalajs.js.annotation.JSExport
import pixi.scalajs.UserData.WithUserData

@JSExport("Tinting")
object Tinting {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  // Data associated with the Aliens
  case class AlienData(var direction: Double, var turningSpeed: Double, var speed: Double)

  // holder to store the aliens
  val aliens = for (i <- 0 until 20) yield {
    // create a new Sprite that uses the image name that we just generated as its source
    val dude = Sprite.fromImage("_assets/eggHead.png")

    // set the anchor point so the texture is centerd on the sprite
    dude.anchor.set(0.5)

    // set a random scale for the dude - no point them all being the same size!
    dude.scale.set(0.8 + Math.random() * 0.3)

    // finally lets set the dude to be at a random position..
    dude.position.x = Math.random() * renderer.width
    dude.position.y = Math.random() * renderer.height

    dude.tint = Math.random() * 0xFFFFFF

    // create some extra properties that will control movement :
    val data = AlienData(
      // create a random direction in radians. This is a number between 0 and PI*2 which is the equivalent of 0 - 360 degrees
      direction = Math.random() * Math.PI * 2,

      // this number will be used to modify the direction of the dude over time
      turningSpeed = Math.random() - 0.8,

      // create a random speed for the dude between 0 - 2
      speed = 2 + Math.random() * 2
    )

    stage.addChild(dude)

    // finally we yield the dude into the aliens array so it it can be easily accessed later
    dude.withUserData(data)
  }

  // create a bounding box for the little dudes
  val dudeBoundsPadding = 100
  val dudeBounds = new Rectangle(-dudeBoundsPadding,
    -dudeBoundsPadding,
    renderer.width + dudeBoundsPadding * 2,
    renderer.height + dudeBoundsPadding * 2)

  var tick = 0.0

  dom.requestAnimationFrame(animate _)

  def animate(d: Double) {

    // iterate through the dudes and update their position
    for (dude <- aliens) {
      dude.userData.direction += dude.userData.turningSpeed * 0.01
      dude.position.x += Math.sin(dude.userData.direction) * dude.userData.speed
      dude.position.y += Math.cos(dude.userData.direction) * dude.userData.speed
      dude.rotation = -dude.userData.direction - Math.PI / 2

      // wrap the dudes by testing their bounds...
      if (dude.position.x < dudeBounds.x) {
        dude.position.x += dudeBounds.width
      } else if (dude.position.x > dudeBounds.x + dudeBounds.width) {
        dude.position.x -= dudeBounds.width
      }

      if (dude.position.y < dudeBounds.y) {
        dude.position.y += dudeBounds.height
      } else if (dude.position.y > dudeBounds.y + dudeBounds.height) {
        dude.position.y -= dudeBounds.height
      }
    }

    // increment the ticker
    tick += 0.1

    // time to render the stage!
    renderer.render(stage)

    // request another animation frame...
    dom.requestAnimationFrame(animate _)
  }

}
