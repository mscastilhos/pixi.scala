package pixi.demos

import org.scalajs.dom
import pixi.core.ParticleContainer.Properties
import pixi.core._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, ScalaJSDefined}
import scala.util.Random

@JSExport("ParticleContainerDemo")
object ParticleContainerDemo {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  val sprites = new ParticleContainer(10000, new Properties {
    scale = true
    position = true
    rotation = true
    uvs = true
    alpha = true
  })

  stage.addChild(sprites)


  val totalSprites = if (renderer.rendererType == Renderer.Type.WebGL) 10000 else 100

  // Data associated with the maggots
  @ScalaJSDefined
  trait MaggotData extends js.Object {
    var direction: Double
    var turningSpeed: Double
    var speed: Double
    var offset: Double
  }

  // create an array of sprites
  val maggots = for (i <- 0 until totalSprites) yield {
    // create a new Sprite
    val dude = Sprite.fromImage("_assets/tinyMaggot.png")

    dude.tint = Random.nextInt(0xE8D4CD)

    // set the anchor point so the texture is centered on the sprite
    dude.anchor.set(0.5)

    // different maggots, different sizes
    dude.scale.set(0.8 + Math.random() * 0.3)

    // scatter them all
    dude.x = Math.random() * renderer.width
    dude.y = Math.random() * renderer.height

    dude.tint = Random.nextInt(0x808080)

    // maggot with associated data
    val dudeData = dude.asInstanceOf[Sprite with MaggotData]

    // create a random direction in radians
    dudeData.direction = Math.random() * Math.PI * 2

    // this number will be used to modify the direction of the sprite over time
    dudeData.turningSpeed = Math.random() - 0.8

    // create a random speed between 0 - 2, and these maggots are slooww
    dudeData.speed = (2 + Math.random() * 2) * 0.2

    dudeData.offset = Math.random() * 100

    sprites.addChild(dude)

    // finally we yield the dude with extra data so it can be easily accessed later
    dudeData
  }

  // create a bounding box box for the little maggots
  val dudeBoundsPadding = 100
  val dudeBounds = new Rectangle(-dudeBoundsPadding,
    -dudeBoundsPadding,
    renderer.width + dudeBoundsPadding * 2,
    renderer.height + dudeBoundsPadding * 2)

  var tick = 0.0

  dom.requestAnimationFrame(animate _)

  def animate(d: Double) {

    // iterate through the sprites and update their position
    for (dude <- maggots) {
      dude.scale.y = 0.95 + Math.sin(tick + dude.offset) * 0.05
      dude.direction += dude.turningSpeed * 0.01
      dude.position.x += Math.sin(dude.direction) * (dude.speed * dude.scale.y)
      dude.position.y += Math.cos(dude.direction) * (dude.speed * dude.scale.y)
      dude.rotation = -dude.direction + Math.PI

      // wrap the maggots
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

    // time to render the stage !
    renderer.render(stage)

    // request another animation frame...
    dom.requestAnimationFrame(animate _)
  }

}
