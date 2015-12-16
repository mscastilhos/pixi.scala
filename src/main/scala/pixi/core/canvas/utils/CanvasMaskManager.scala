package pixi.core.canvas.utils

import pixi.core.{Renderer, Graphics}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A set of functions used to handle masking. */
@js.native
@JSName("PIXI.CanvasMaskManager")
class CanvasMaskManager() extends js.Object {
  /** This method adds it to the current stack of masks.
    *
    * @param maskData the maskData that will be pushed
    * @param renderer The renderer context to use.
    */
  def pushMask(maskData: Graphics, renderer: Renderer): Unit = js.native

  /** Restores the current drawing context to the state it was before the mask was applied.
    *
    * @param renderer The renderer context to use.
    */
  def popMask(renderer: Renderer): Unit = js.native
}
