package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A TiltShift Filter. Manages the pass of both a TiltShiftXFilter and TiltShiftYFilter.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.TiltShiftFilter")
class TiltShiftFilter() extends Filter {
  /** The strength of the blur. */
  var blur: Double = js.native

  /** The strength of the gradient blur. */
  var gradientBlur: Double = js.native

  /** The Y value to start the effect at. */
  var start: Double = js.native

  /** The Y value to end the effect at. */
  var end: Double = js.native
}
