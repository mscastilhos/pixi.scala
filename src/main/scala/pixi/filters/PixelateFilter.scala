package pixi.filters

import pixi.core.Point
import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** This filter applies a pixelate effect making display objects appear 'blocky'.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.PixelateFilter")
class PixelateFilter() extends Filter {
  /** This a point that describes the size of the blocks.
    * x is the width of the block and y is the height.
    */
  var size: Point = js.native
}
