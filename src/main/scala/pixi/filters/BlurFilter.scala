package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The BlurFilter applies a Gaussian blur to an object.
  * The strength of the blur can be set for x- and y-axis separately.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.BlurFilter")
class BlurFilter() extends Filter() {
  /** Sets the strength of both the blurX and blurY properties simultaneously */
  var blur: Double = js.native

  /** Sets the number of passes for blur. More passes means higher quaility bluring. */
  var passes: Double = js.native

  /** Sets the strength of the blurX property */
  var blurX: Double = js.native

  /** Sets the strength of the blurY property */
  var blurY: Double = js.native
}