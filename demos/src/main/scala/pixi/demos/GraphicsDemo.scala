package pixi.demos

import org.scalajs.dom
import pixi.core.{Graphics, Container, Renderer}
import pixi.core.Renderer.Options

import scala.scalajs.js.annotation.JSExport

/**
 * @author Marcelo Serra Castilhos
 */
@JSExport("Graphics")
object GraphicsDemo {
  var renderer = Renderer.autoDetect(800, 600, Options(antialias = true))
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  var stage = new Container

  stage.interactive = true

  var graphics = new Graphics

  // set a fill and line style
  graphics.beginFill(0xFF3300)
  graphics.lineStyle(4, 0xffd900, 1)

  // draw a shape
  graphics.moveTo(50, 50)
  graphics.lineTo(250, 50)
  graphics.lineTo(100, 100)
  graphics.lineTo(50, 50)
  graphics.endFill()

  // set a fill and a line style again and draw a rectangle
  graphics.lineStyle(2, 0x0000FF, 1)
  graphics.beginFill(0xFF700B, 1)
  graphics.drawRect(50, 250, 120, 120)

  // draw a rounded rectangle
  graphics.lineStyle(2, 0xFF00FF, 1)
  graphics.beginFill(0xFF00BB, 0.25)
  graphics.drawRoundedRect(150, 450, 300, 100, 15)
  graphics.endFill()

  // draw a circle, set the lineStyle to zero so the circle doesn't have an outline
  graphics.lineStyle(0)
  graphics.beginFill(0xFFFF0B, 0.5)
  graphics.drawCircle(470, 90, 60)
  graphics.endFill()


  stage.addChild(graphics)

  // run the render loop
  animate()

  def animate(d: Double = 0) {

    renderer.render(stage)
    dom.requestAnimationFrame(animate _)
  }
}
