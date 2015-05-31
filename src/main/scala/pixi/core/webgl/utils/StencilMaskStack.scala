package pixi.core.webgl.utils

import pixi.core.webgl.WebGLRenderer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** Generic Mask Stack data structure
  * @constructor
  * @param renderer The renderer this manager works for.
  */
@JSName("PIXI.StencilMaskStack")
class StencilMaskStack(renderer: WebGLRenderer) extends js.Object {
  /** The actual stack */
  var stencilStack: js.Array[js.Any] = js.native

  /** TODO @alvin */
  var reverse: Boolean = js.native

  /** Internal count */
  var count: Double = js.native

}
