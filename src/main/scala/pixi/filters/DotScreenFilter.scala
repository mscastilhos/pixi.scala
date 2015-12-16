package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** This filter applies a dotscreen effect making display objects appear to be made out of
  * black and white halftone dots like an old printer.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.DotScreenFilter")
class DotScreenFilter() extends Filter {
  /** The scale of the effect. */
  var scale: Double = js.native

  /** The radius of the effect. */
  var angle: Double = js.native
}
