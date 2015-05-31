package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The Point object represents a location in a two-dimensional coordinate system, where x represents
  * the horizontal axis and y represents the vertical axis.
  * @constructor
  * @param _x position of the point on the x axis
  * @param _y position of the point on the y axis
  */
@JSName("PIXI.Point")
class Point(_x: Double = 0, _y: Double = 0) extends js.Object {
  /** Position of the point on the x axis */
  var x: Double = js.native
  /** Position of the point on the y axis */
  var y: Double = js.native

  /** Creates a clone of this point
    *
    * @return a copy of the point
    */
  override def clone(): Point = js.native

  /** Copies x and y from the given point
    *
    * @param p
    */
  def copy(p: Point): Unit = js.native

  /** Returns true if the given point is equal to this point
    *
    * @param p
    * @return
    */
  def equals(p: Point): Boolean = js.native

  /** Sets the point to a new x and y position.
    * If y is omitted, both x and y will be set to x.
    *
    * @param x position of the point on the x axis
    * @param y position of the point on the y axis
    */
  def set(x: Double = 0, y: Double = 0): Unit = js.native
}
