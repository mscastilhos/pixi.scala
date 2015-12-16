package pixi.filters

import pixi.core.Point
import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** This filter applies a twist effect making display objects appear twisted in the given direction.
  * @constructor
  */
@js.native
@JSName("PIXI.filters.TwistFilter")
class TwistFilter() extends Filter {
  /** This point describes the the offset of the twist. */
  var offset: Point = js.native

  /** This radius of the twist. */
  var radius: Double = js.native

  /** This angle of the twist. */
  var angle: Double = js.native
}
