package pixi.core.canvas.utils

import org.scalajs.dom.raw.CanvasRenderingContext2D
import pixi.core.Graphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A set of functions used by the canvas renderer to draw the primitive graphics data.
  * @constructor
  */
@JSName("PIXI.CanvasGraphics")
class CanvasGraphics() extends js.Object {
  /**
   * Renders a Graphics object to a canvas.
   *
   * @param graphics the actual graphics object to render
   * @param context  the 2d drawing method of the canvas
   */
  def renderGraphics(graphics: Graphics, context: CanvasRenderingContext2D): Unit = js.native

}
