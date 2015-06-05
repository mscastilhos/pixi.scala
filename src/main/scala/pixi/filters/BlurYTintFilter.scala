package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The BlurYTintFilter applies a vertical Gaussian blur to an object.
  * @constructor
  */
@JSName("PIXI.filters.BlurYTintFilter")
class BlurYTintFilter() extends Filter {
  /** Sets the strength of both the blur. */
  var blur: Double = js.native
}
