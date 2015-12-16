package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A GraphicsData object. */
@js.native
@JSName("PIXI.GraphicsData")
class GraphicsData protected[pixi]() extends js.Object {
  /**
   * @param lineWidth the width of the line to draw
   * @param lineColor the color of the line to draw
   * @param lineAlpha the alpha of the line to draw
   * @param fillColor the color of the fill
   * @param fillAlpha the alpha of the fill
   * @param fill whether or not the shape is filled with a colour
   * @param shape The shape object to draw.
   */
  def this(lineWidth: Double,
           lineColor: Double,
           lineAlpha: Double,
           fillColor: Double,
           fillAlpha: Double,
           fill: Boolean,
           shape: Shape) = this()

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
