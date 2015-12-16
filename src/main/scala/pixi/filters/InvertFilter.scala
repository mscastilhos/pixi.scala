package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** This inverts your Display Objects colors.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.InvertFilter")
class InvertFilter() extends Filter {
  /** The strength of the invert. `1` will fully invert the colors, and `0` will make the object its normal color. */
  var invert: Double = js.native
}
