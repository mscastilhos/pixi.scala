package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** This greyscales the palette of your Display Objects.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.GrayFilter")
class GrayFilter() extends Filter {
  /** The strength of the gray. 1 will make the object black and white, 0 will make the object its normal color. */
  var gray: Double = js.native
}
