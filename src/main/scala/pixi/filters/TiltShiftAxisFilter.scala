package pixi.filters

import pixi.core.Point
import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A TiltShiftAxisFilter.
  * @constructor
  */
@JSName("PIXI.filters.TiltShiftAxisFilter")
class TiltShiftAxisFilter() extends Filter {
  /** Updates the filter delta values.
    * This is overridden in the X and Y filters, does nothing for this class.
    */
  def updateDelta(): Unit = js.native

  /** The strength of the blur. */
  var blur: Double = js.native

  /** The strength of the gradient blur. */
  var gradientBlur: Double = js.native

  /** The X value to start the effect at. */
  var start: Point = js.native

  /** The X value to end the effect at. */
  var end: Point = js.native
}
