package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The Circle object can be used to specify a hit area for displayObjects
  * @constructor
  * @param _x The X coordinate of the center of this circle
  * @param _y The Y coordinate of the center of this circle
  * @param _radius The radius of the circle
  */
@JSName("PIXI.Circle")
class Circle(_x: Double, _y: Double, _radius: Double) extends Shape {
  /** The X coordinate of the center of this circle */
  var x: Double = js.native
  /** The Y coordinate of the center of this circle */
  var y: Double = js.native
  /** The radius of the circle */
  var radius: Double = js.native

  /** The type of the object, mainly used to avoid `instanceof` checks */
  var `type`: Int = js.native

  /** Creates a clone of this Circle instance
    *
    * @return a copy of the Circle
    */
  override def clone(): Circle = js.native

  /** Checks whether the x and y coordinates given are contained within this circle
    *
    * @param x The X coordinate of the point to test
    * @param y The Y coordinate of the point to test
    * @return Whether the x/y coordinates are within this Circle
    */
  def contains(x: Double, y: Double): Boolean = js.native

  /** Returns the framing rectangle of the circle as a Rectangle object
    *
    * @return the framing rectangle
    */
  def getBounds(): Rectangle = js.native
}
