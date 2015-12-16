package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A Noise effect filter.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.NoiseFilter")
class NoiseFilter() extends Filter {
  /** The amount of noise to apply. */
  var noise: Double = js.native
}
