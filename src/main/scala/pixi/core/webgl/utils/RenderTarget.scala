package pixi.core.webgl.utils

import org.scalajs.dom.raw.{WebGLRenderbuffer, WebGLFramebuffer, WebGLRenderingContext}
import pixi.core.{Rectangle, Texture, Matrix}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * @constructor
 * @param _gl the current WebGL drawing context
 * @param _width the horizontal range of the filter
 * @param _height the vertical range of the filter
 * @param _scaleMode See {{#crossLink "PIXI/scaleModes:property"}}PIXI.scaleModes{{/crossLink}} for possible values
 * @param _resolution the current resolution
 * @param _root Whether this object is the root element or not
 */
@js.native
@JSName("PIXI.RenderTarget")
class RenderTarget(_gl: WebGLRenderingContext,
                   _width: Int,
                   _height: Int,
                   _scaleMode: Int,
                   _resolution: Double,
                   _root: Boolean) extends js.Object {
  /** The current WebGL drawing context */
  var gl: WebGLRenderingContext = js.native

  /** A frame buffer */
  var frameBuffer: WebGLFramebuffer = js.native

  var texture: Texture = js.native

  /** The size of the object as a rectangle */
  var size: Rectangle = js.native

  /** The current resolution */
  var resolution: Double = js.native

  /** The projection matrix */
  var projectionMatrix: Matrix = js.native

  /** The object's transform */
  var transform: Matrix = js.native

  var frame: Rectangle = js.native
  /** The stencil buffer stores masking data for the render target */
  var stencilBuffer: WebGLRenderbuffer = js.native

  /** The data structure for the stencil masks */
  var stencilMaskStack: StencilMaskStack = js.native

  /** Stores filter data for the render target */
  var filterStack: js.Array[js.Any] = js.native

  /** The scale mode */
  var scaleMode: Double = js.native

  /** Whether this object is the root element or not */
  var root: Boolean = js.native

  /** Clears the filter texture.
    *
    */
  def clear(): Unit = js.native

  /** Binds the stencil buffer.
    *
    */
  def attachStencilBuffer(): Unit = js.native

  /** Binds the buffers and initialises the viewport.
    *
    */
  def activate(): Unit = js.native

  /** Updates the projection matrix based on a projection frame (which is a rectangle)
    *
    */
  def calculateProjection(): Unit = js.native

  /** Resizes the texture to the specified width and height
    *
    * @param width the new width of the texture
    * @param height the new height of the texture
    */
  def resize(width: Double, height: Double): Unit = js.native

  /** Destroys the render target.
    *
    */
  def destroy(): Unit = js.native

}
