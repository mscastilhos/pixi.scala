package pixi.core.webgl.managers

import pixi.core.Graphics
import pixi.core.webgl.WebGLRenderer
import pixi.core.webgl.utils.RenderTarget

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * @constructor
 * @param renderer The renderer this manager works for.
 */
@JSName("PIXI.MaskManager")
class MaskManager(renderer: WebGLRenderer) extends js.Object {
  /** Applies the Mask and adds it to the current filter stack.
    *
    * @param graphics
    * @param webGLData
    */
  def pushMask(graphics: Graphics, webGLData: js.Object): Unit = js.native

  /** Removes the last mask from the mask stack and doesn't return it.
    *
    * @param target
    * @param maskData
    */
  def popMask(target: RenderTarget, maskData: js.Object): Unit = js.native

  /** Applies the Mask and adds it to the current filter stack.
    *
    * @param target
    * @param maskData
    */
  def pushSpriteMask(target: RenderTarget, maskData: js.Object): Unit = js.native

  /** Removes the last filter from the filter stack and doesn't return it.
    *
    */
  def popSpriteMask(): Unit = js.native

  /** Applies the Mask and adds it to the current filter stack.
    *
    * @param target
    * @param maskData
    */
  def pushStencilMask(target: RenderTarget, maskData: js.Object): Unit = js.native

  /** Removes the last filter from the filter stack and doesn't return it.
    *
    * @param target
    * @param maskData
    */
  def popStencilMask(target: RenderTarget, maskData: js.Object): Unit = js.native
}
