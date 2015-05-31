package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The Ellipse object can be used to specify a hit area for displayObjects
  * @constructor
  * @param _x The X coordinate of the center of the ellipse
  * @param _y The Y coordinate of the center of the ellipse
  * @param _width The half width of this ellipse
  * @param _height The half height of this ellipse
  */
@JSName("PIXI.Ellipse")
class Ellipse(_x: Double, _y: Double, _width: Double, _height: Double) extends Shape {
  /** The X coordinate of the center of the ellipse */
  var x: Double = js.native

  /** The Y coordinate of the center of the ellipse */
  var y: Double = js.native

  /** The half width of this ellipse */
  var width: Double = js.native

  /** The half height of this ellipse */
  var height: Double = js.native

  /** The type of the object, mainly used to avoid `instanceof` checks */
  var `type`: Int = js.native

  /** Creates a clone of this Ellipse instance
    *
    * @return a copy of the ellipse
    */
  override def clone(): Ellipse = js.native

  /** Checks whether the x and y coordinates given are contained within this ellipse
    *
    * @param x The X coordinate of the point to test
    * @param y The Y coordinate of the point to test
    * @return Whether the x/y coords are within this ellipse
    */
  def contains(x: Double, y: Double): Boolean = js.native

  /** Returns the framing rectangle of the ellipse as a Rectangle object
    *
    * @return the framing rectangle
    */
  def getBounds(): Rectangle = js.native

}
