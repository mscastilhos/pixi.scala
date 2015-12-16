package pixi.demos

import org.scalajs.dom
import pixi.core.{Texture, Sprite, Container, Renderer}

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.{ScalaJSDefined, JSExport}


@JSExport("Interactivity")
object Interactivity {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  // create a background...
  val background = Sprite.fromImage("_assets/button_test_BG.jpg")
  background.width = renderer.width
  background.height = renderer.height

  // add background to stage...
  stage.addChild(background)

  // create some textures from an image path
  val textureButton = Texture.fromImage("_assets/button.png")
  val textureButtonDown = Texture.fromImage("_assets/buttonDown.png")
  val textureButtonOver = Texture.fromImage("_assets/buttonOver.png")

  val buttonPositions = js.Array(
    175, 75,
    655, 75,
    410, 325,
    150, 465,
    685, 445
  )

  @ScalaJSDefined
  trait InterState extends js.Object {
    var isDown: UndefOr[Boolean]
    var isOver: UndefOr[Boolean]
  }

  val buttons = for (i <- 0 until 5) yield {
    val button = new Sprite(textureButton)
    button.buttonMode = true

    button.anchor.set(0.5)

    button.position.x = buttonPositions(i * 2)
    button.position.y = buttonPositions(i * 2 + 1)

    // make the button interactive...
    button.interactive = true

    // view those extra fields in the button
    val asData = button.asInstanceOf[InterState]

    button.on("mousedown", "touchstart") {
      // set the mousedown and touchstart callback..
      asData.isDown = true
      button.texture = textureButtonDown
      button.alpha = 1
    }.on("mouseup", "touchend", "mouseupoutside", "touchendoutside") {
      // set the mouseup and touchend callback...
      asData.isDown = false
      if (asData.isOver getOrElse false) {
        button.texture = textureButtonOver
      } else {
        button.texture = textureButton
      }
    }.on("mouseover") {
      // set the mouseover callback...
      asData.isOver = true
      if (!asData.isDown.getOrElse(false)) {
        button.texture = textureButtonOver
      }
    }.on("mouseout") {
      // set the mouseout callback...
      asData.isOver = true

      if (!asData.isDown.getOrElse(false)) {
        button.texture = textureButton
      }
    }

    // you can also listen to click and tap events :
    //.on('click', noop)

    // button.tap = noop;
    //button.click = noop;
    // add it to the stage
    stage.addChild(button)

    // add button to array
    button
  }

  // set some silly values...
  buttons(0).scale.set(1.2)

  buttons(2).rotation = Math.PI / 10

  buttons(3).scale.set(0.8)

  buttons(4).scale.set(0.8, 1.2)
  buttons(4).rotation = Math.PI


  animate()

  def animate(d: Double = 0) {
    // render the stage
    renderer.render(stage)

    dom.requestAnimationFrame(animate _)
  }
}
