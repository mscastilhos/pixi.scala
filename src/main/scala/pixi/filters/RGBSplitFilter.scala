package pixi.filters

import pixi.core.Point
import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** An RGB Split Filter.
  * @constructor
  */
@JSName("PIXI.filters.RGBSplitFilter")
class RGBSplitFilter() extends Filter {
  /** Red channel offset. */
  var red: Point = js.native

  /** Green channel offset. */
  var green: Point = js.native

  /** Blue offset. */
  var blue: Point = js.native
}
