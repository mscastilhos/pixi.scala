package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** An ASCII filter.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.AsciiFilter")
class AsciiFilter() extends Filter() {
  /** The pixel size used by the filter. */
  var size: Double = js.native
}
