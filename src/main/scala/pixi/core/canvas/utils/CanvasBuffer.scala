package pixi.core.canvas.utils

import org.scalajs.dom.raw.{CanvasRenderingContext2D, HTMLCanvasElement}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** Creates a Canvas element of the given size.
  * @constructor
  * @param _width the width for the newly created canvas
  * @param _height the height for the newly created canvas
  */
@JSName("PIXI.CanvasBuffer")
class CanvasBuffer(_width: Double, _height: Double) extends js.Object {
  /** The Canvas object that belongs to this CanvasBuffer. */
  var canvas: HTMLCanvasElement = js.native

  /** A CanvasRenderingContext2D object representing a two-dimensional rendering context. */
  var context: CanvasRenderingContext2D = js.native

  /** The width of the canvas buffer in pixels. */
  var width: Double = js.native

  /** The height of the canvas buffer in pixels. */
  var height: Double = js.native

  /** Resizes the canvas to the specified width and height.
    *
    * @param width the new width of the canvas
    * @param height the new height of the canvas
    */
  def resize(width: Double, height: Double): Unit = js.native

  /** Destroys this canvas. */
  def destroy(): Unit = js.native
}
