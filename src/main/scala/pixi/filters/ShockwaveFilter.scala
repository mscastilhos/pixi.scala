package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The ColorMatrixFilter class lets you apply a 4x4 matrix transformation on the RGBA
  * color and alpha values of every pixel on your displayObject to produce a result
  * with a new set of RGBA color and alpha values. It's pretty powerful!
  * @constructor
  */
@JSName("PIXI.filters.ShockwaveFilter")
class ShockwaveFilter() extends Filter {
  /** Sets the center of the shockwave in normalized screen coords. That is (0,0) is the top-left and (1,1) is the
    * bottom right.
    */
  var center: js.Object = js.native

  /** Sets the params of the shockwave. These modify the look and behavior of the shockwave as it ripples out. */
  var params: js.Object = js.native

  /** Sets the elapsed time of the shockwave. This controls the speed at which the shockwave ripples out. */
  var time: Double = js.native
}
