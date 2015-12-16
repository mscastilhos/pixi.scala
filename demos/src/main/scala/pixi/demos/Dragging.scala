package pixi.demos

import org.scalajs.dom
import pixi.core.{Sprite, Texture, Container, Renderer}
import pixi.interaction.{InteractionData, EventData}

import scala.scalajs.js
import scala.scalajs.js.annotation.{ScalaJSDefined, JSExport}
import scala.util.Random

@JSExport("Dragging")
object Dragging {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  // create a texture from an image path
  val texture = Texture.fromImage("_assets/bunny.png")

  for (_ <- 1 to 10) {
    createBunny(Random.nextInt(800 + 1), Random.nextInt(600 + 1))
  }

  dom.requestAnimationFrame(animate _)

  @ScalaJSDefined
  trait DragData extends js.Object {
    // Saved event data
    var data: InteractionData
    // Is dragging?
    var dragging: Boolean
  }

  def createBunny(x: Int, y: Int): Unit = {
    // create our little bunny friend..
    val bunny = new Sprite(texture).asInstanceOf[Sprite with DragData]

    // enable the bunny to be interactive... this will allow it to respond to mouse and touch events
    bunny.interactive = true

    // this button mode will mean the hand cursor appears when you roll over the bunny with your mouse
    bunny.buttonMode = true

    // center the bunny's anchor point
    bunny.anchor.set(0.5)

    // make it a bit bigger, so it's easier to grab
    bunny.scale.set(3)

    // setup events

    // events for drag start
    bunny.on("mousedown", onDragStart _)
    bunny.on("touchstart", onDragStart _)
    // events for drag end
    bunny.on("mouseup", onDragEnd _)
    bunny.on("mouseupoutside", onDragEnd _)
    bunny.on("touchend", onDragEnd _)
    bunny.on("touchendoutside", onDragEnd _)
    // events for drag move
    bunny.on("mousemove", onDragMove _)
    bunny.on("touchmove", onDragMove _)
    // Not dragging
    bunny.dragging = false

    // move the sprite to its designated position
    bunny.position.x = x
    bunny.position.y = y

    // add it to the stage
    stage.addChild(bunny)
  }


  def animate(d: Double = 0) {

    dom.requestAnimationFrame(animate _)

    // render the stage
    renderer.render(stage)
  }

  def onDragStart(bunny: Sprite with DragData, event: EventData): Unit = {
    // store a reference to the data
    // the reason for this is because of multitouch
    // we want to track the movement of this particular touch

    bunny.data = event.data
    bunny.alpha = 0.5
    bunny.dragging = true
  }


  def onDragEnd(bunny: Sprite with DragData, event: EventData): Unit = {
    bunny.alpha = 1

    bunny.dragging = false

    // set the interaction data to null
    bunny.data = null
  }

  def onDragMove(bunny: Sprite with DragData, event: EventData): Unit = {
    if (bunny.dragging) {
      val data = bunny.data
      val newPosition = data.getLocalPosition(bunny.parent)
      bunny.position.x = newPosition.x
      bunny.position.y = newPosition.y
    }
  }

}
