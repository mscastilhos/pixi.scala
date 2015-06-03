package pixi.demos

import org.scalajs.dom.{document, requestAnimationFrame}
import pixi.core.{Text, Container, Renderer}
import pixi.core.Renderer.Options

import scala.scalajs.js.annotation.JSExport

/**
 * @author Marcelo Serra Castilhos
 */
@JSExport("TextDemo")
object TextDemo {
  val renderer = Renderer.autoDetect(800, 600, Options(backgroundColor = 0x1099bb))
  document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container()

  val basicText = new Text("Basic text in pixi")
  basicText.x = 30
  basicText.y = 90

  stage.addChild(basicText)

  val style = Text.Style(
    font = "36px Arial bold italic",
    fill = "#F7EDCA",
    stroke = "#4a1850",
    strokeThickness = 5,
    dropShadow = true,
    dropShadowColor = "#000000",
    dropShadowAngle = Math.PI / 6,
    dropShadowDistance = 6,
    wordWrap = true,
    wordWrapWidth = 440
  )

  val richText = new Text("Rich text with a lot of options and across multiple lines", style)
  richText.x = 30
  richText.y = 180

  stage.addChild(richText)

  // start animating
  animate()

  def animate(d: Double = 0) {

    requestAnimationFrame(animate _)

    // render the root container
    renderer.render(stage)
  }

}
