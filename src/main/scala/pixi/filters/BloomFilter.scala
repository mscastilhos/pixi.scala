package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The BloomFilter applies a Gaussian blur to an object.
  * The strength of the blur can be set for x- and y-axis separately.
  * @constructor
  */
@JSName("PIXI.filters.BloomFilter")
class BloomFilter() extends Filter {
  /** Sets the strength of both the blurX and blurY properties simultaneously */
  var blur: Double = js.native

  /** Sets the strength of the blurX property */
  var blurX: Double = js.native

  /** Sets the strength of the blurY property */
  var blurY: Double = js.native
}
