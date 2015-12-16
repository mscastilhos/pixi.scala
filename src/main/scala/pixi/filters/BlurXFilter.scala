package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The BlurXFilter applies a horizontal Gaussian blur to an object.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.BlurXFilter")
class BlurXFilter() extends Filter {
  /** Sets the number of passes for blur. More passes means higher quaility bluring. */
  var passes: Double = js.native

  /** Sets the strength of both the blur. */
  var blur: Double = js.native
}
