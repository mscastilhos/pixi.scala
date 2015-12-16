package pixi.core.webgl

import pixi.core.Renderer.Options
import pixi.core.{Renderer, Texture, BaseTexture, DisplayObject}
import pixi.core.webgl.managers._
import pixi.core.webgl.utils.{RenderTarget, ObjectRenderer}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The WebGLRenderer draws the scene and all its content onto a webGL enabled canvas. This renderer
  * should be used for browsers that support webGL. This Render works by automatically managing webGLBatchs.
  * So no need for Sprite Batches or Sprite Clouds.
  * Don't forget to add the view to your DOM or you will not see anything :)
  */
@js.native
@JSName("PIXI.WebGLRenderer")
class WebGLRenderer protected[pixi]() extends Renderer {

  /**
   * @param width the width of the canvas view
   * @param height the height of the canvas view
   * @param options The optional renderer parameters
   */
  def this(width: Int = 0, height: Int = 0, options: Options = new Options) = this()

  type StencilManager = WebGLMaskManager

  /** Counter for the number of draws made each frame */
  var drawCount: Int = js.native

  /** Deals with managing the shader programs and their attribs. */
  var shaderManager: ShaderManager = js.native

  /** Manages the masks using the stencil buffer. */
  var maskManager: MaskManager = js.native

  /** Manages the stencil buffer. */
  var stencilManager: StencilManager = js.native

  /** Manages the filters. */
  var filterManager: FilterManager = js.native

  /** Manages the blendModes */
  var blendModeManager: BlendModeManager = js.native

  /** Holds the current render target */
  var currentRenderTarget: RenderTarget = js.native

  /** object renderer @alvin */
  var currentRenderer: ObjectRenderer = js.native

  /** Renders a Display Object.
    *
    * @param displayObject The DisplayObject to render
    * @param renderTarget The render target to use to render this display object
    */
  def renderDisplayObject(displayObject: DisplayObject, renderTarget: RenderTarget): Unit = js.native

  /** Changes the current renderer to the one given in parameter
    *
    * @param objectRenderer TODO @alvin
    */
  def setObjectRenderer(objectRenderer: Object): Unit = js.native

  /** Changes the current render target to the one given in parameter
    *
    * @param renderTarget the new render target
    */
  def setRenderTarget(renderTarget: RenderTarget): Unit = js.native

  /** Updates and/or Creates a WebGL texture for the renderer's context.
    *
    * @param texture the texture to update
    */
  def updateTexture(texture: BaseTexture): Unit = js.native

  /** Updates and/or Creates a WebGL texture for the renderer's context.
    *
    * @param texture the texture to update
    */
  def updateTexture(texture: Texture): Unit = js.native

  /** Deletes the texture from WebGL
    *
    * @param texture the texture to destroy
    */
  def destroyTexture(texture: BaseTexture): Unit = js.native

  /** Deletes the texture from WebGL
    *
    * @param texture the texture to destroy
    */
  def destroyTexture(texture: Texture): Unit = js.native
}
