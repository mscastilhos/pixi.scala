package pixi.core.webgl.managers

import pixi.core.Graphics
import pixi.core.webgl.WebGLRenderer
import pixi.core.webgl.utils.StencilMaskStack

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * @constructor
 * @param renderer The renderer this manager works for.
 */
@js.native
@JSName("PIXI.WebGLMaskManager")
class WebGLMaskManager(renderer: WebGLRenderer) extends js.Object {
  /** Changes the mask stack that is used by this manager
    *
    * @param stencilMaskStack The mask stack
    */
  def setMaskStack(stencilMaskStack: StencilMaskStack): Unit = js.native

  /** Applies the Mask and adds it to the current filter stack. @alvin
    *
    * @param graphics
    * @param webGLData
    */
  def pushStencil(graphics: Graphics, webGLData: js.Object): Unit = js.native

  /** TODO this does not belong here!
    *
    * @param graphics
    * @param webGLData
    */
  def bindGraphics(graphics: Graphics, webGLData: js.Array[js.Any]): Unit = js.native

  /** TODO @alvin
    *
    * @param graphics
    * @param webGLData
    */
  def popStencil(graphics: Graphics, webGLData: js.Array[js.Any]): Unit = js.native

  /** Destroys the mask stack.
    *
    */
  def destroy(): Unit = js.native

  /** Applies the Mask and adds it to the current filter stack.
    *
    * @param maskData The mask data structure to use
    */
  def pushMask(maskData: js.Object): Unit = js.native

  /** Removes the last filter from the filter stack and doesn't return it.
    *
    * @param maskData
    */
  def popMask(maskData: js.Object): Unit = js.native
}
