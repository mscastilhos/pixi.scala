package pixi.core

import pixi.Env

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** the Rectangle object is an area defined by its position, as indicated by its top-left corner point (x, y) and by its width and its height.
  * @constructor
  * @param _x The X coordinate of the upper-left corner of the rectangle
  * @param _y The Y coordinate of the upper-left corner of the rectangle
  * @param _width The overall width of this rectangle
  * @param _height The overall height of this rectangle
  */
@JSName("PIXI.Rectangle")
class Rectangle(_x: Double, _y: Double, _width: Double, _height: Double) extends Shape {
  /** The X coordinate of the upper-left corner of the rectangle */
  var x: Double = js.native

  /** The Y coordinate of the upper-left corner of the rectangle */
  var y: Double = js.native

  /** The overall width of this rectangle */
  var width: Double = js.native

  /** The overall height of this rectangle */
  var height: Double = js.native

  /** The type of the object, mainly used to avoid `instanceof` checks */
  var `type`: Int = js.native

  /** Creates a clone of this Rectangle
    *
    * @return a copy of the rectangle
    */
  override def clone(): Rectangle = js.native

  /** Checks whether the x and y coordinates given are contained within this Rectangle
    *
    * @param x The X coordinate of the point to test
    * @param y The Y coordinate of the point to test
    * @return Whether the x/y coordinates are within this Rectangle
    */
  def contains(x: Double, y: Double): Boolean = js.native
}

object Rectangle {
  /** A constant empty rectangle. */
  val EMPTY: Rectangle = Env.PIXI.Rectangle.EMPTY.asInstanceOf[Rectangle]
}
