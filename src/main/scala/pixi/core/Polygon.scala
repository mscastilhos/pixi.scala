package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * @constructor
 * @param _points This can be an array of Points that form the polygon, a flat array of numbers that will be
 *                interpreted as [x,y, x,y, ...], or the arguments passed can be all the points of the polygon e.g.
 *                `new PIXI.Polygon(new PIXI.Point(), new PIXI.Point(), ...)`, or the arguments passed can be flat x,y
 *                values e.g. `new Polygon(x,y, x,y, x,y, ...)` where `x` and `y` are Numbers.
 */
@JSName("PIXI.Polygon")
class Polygon(_points: js.Object*) extends Shape {
  /** An array of the points of this polygon */
  var points: js.Array[Double] = js.native

  /** The type of the object, mainly used to avoid `instanceof` checks */
  var `type`: Int = js.native

  /** Creates a clone of this polygon
    *
    * @return a copy of the polygon
    */
  override def clone(): Polygon = js.native

  /** Checks whether the x and y coordinates passed to this function are contained within this polygon
    *
    * @param x The X coordinate of the point to test
    * @param y The Y coordinate of the point to test
    * @return Whether the x/y coordinates are within this polygon
    */
  def contains(x: Double, y: Double): Boolean = js.native
}