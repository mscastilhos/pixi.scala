package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A GraphicsData object.
  * @constructor
  * @param _lineWidth the width of the line to draw
  * @param _lineColor the color of the line to draw
  * @param _lineAlpha the alpha of the line to draw
  * @param _fillColor the color of the fill
  * @param _fillAlpha the alpha of the fill
  * @param _fill whether or not the shape is filled with a colour
  * @param _shape The shape object to draw.
  */
@JSName("PIXI.GraphicsData")
class GraphicsData(_lineWidth: Double,
                   _lineColor: Double,
                   _lineAlpha: Double,
                   _fillColor: Double,
                   _fillAlpha: Double,
                   _fill: Boolean,
                   _shape: Shape) extends js.Object {
  /** the width of the line to draw */
  val lineWidth: Double = js.native

  /** the color of the line to draw */
  val lineColor: Int = js.native

  /** the alpha of the line to draw */
  val lineAlpha: Double = js.native

  /** the color of the fill */
  val fillColor: Double = js.native

  /** the alpha of the fill */
  val fillAlpha: Double = js.native

  /** whether or not the shape is filled with a colour */
  val fill: Boolean = js.native

  /** The shape object to draw. */
  val shape: Shape = js.native

  /** The type of the shape, see the Const.Shapes file for all the existing types */
  val `type`: Int = js.native


  /** Creates a new GraphicsData object with the same values as this one.
    *
    * @return
    */
  override def clone(): GraphicsData = js.native
}
