package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The Rounded Rectangle object is an area that has nice rounded corners, as indicated by its top-left corner point (x, y) and by its width and its height and its radius.
  * @constructor
  * @param _x The X coordinate of the upper-left corner of the rounded rectangle
  * @param _y The Y coordinate of the upper-left corner of the rounded rectangle
  * @param _width The overall width of this rounded rectangle
  * @param _height The overall height of this rounded rectangle
  * @param _radius Controls the radius of the rounded corners
  */
@JSName("PIXI.RoundedRectangle")
class RoundedRectangle(_x: Double, _y: Double, _width: Double, _height: Double, _radius: Double) extends Shape {
  /** The X coordinate of the upper-left corner of the rounded rectangle */
  var x: Double = js.native

  /** The Y coordinate of the upper-left corner of the rounded rectangle */
  var y: Double = js.native

  /** The overall width of this rounded rectangle */
  var width: Double = js.native

  /** The overall height of this rounded rectangle */
  var height: Double = js.native

  /** Controls the radius of the rounded corners */
  var radius: Double = js.native

  /** The type of the object, mainly used to avoid `instanceof` checks */
  var `type`: Int = js.native

  /** Creates a clone of this Rounded Rectangle
    *
    * @return a copy of the rounded rectangle
    */
  override def clone(): RoundedRectangle = js.native

  /** Checks whether the x and y coordinates given are contained within this Rounded Rectangle
    *
    * @param x The X coordinate of the point to test
    * @param y The Y coordinate of the point to test
    * @return Whether the x/y coordinates are within this Rounded Rectangle
    */
  def contains(x: Double, y: Double): Boolean = js.native
}
