package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The BlurDirFilter applies a Gaussian blur toward a direction to an object.
  * @constructor
  * @param _dirX the X direction of the blur
  * @param _dirY the Y direction of the blur
  */
@js.native
@JSName("PIXI.filters.BlurDirFilter")
class BlurDirFilter(_dirX: Double, _dirY: Double) extends Filter() {
  /** Sets the number of passes for blur. More passes means higher quaility bluring. */
  var passes: Double = js.native

  /** Sets the X direction of the blur */
  var dirX: Double = js.native

  /** Sets the Y direction of the blur */
  var dirY: Double = js.native

  /** Sets the strength of both the blur. */
  var blur: Double = js.native
}
