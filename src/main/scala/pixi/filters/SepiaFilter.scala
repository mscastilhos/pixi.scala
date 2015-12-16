package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** This applies a sepia effect to your Display Objects.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.SepiaFilter")
class SepiaFilter() extends Filter {
  /** The strength of the sepia. `1` will apply the full sepia effect, and `0` will make the object its normal color. */
  var sepia: Double = js.native
}
