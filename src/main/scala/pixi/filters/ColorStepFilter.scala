package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** This lowers the color depth of your image by the given amount, producing an image with a smaller palette.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.ColorStepFilter")
class ColorStepFilter() extends Filter {
  /** The number of steps to reduce the palette by. */
  var step: Double = js.native
}
