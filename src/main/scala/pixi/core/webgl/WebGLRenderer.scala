package pixi.core.webgl

import org.scalajs.dom.raw.HTMLCanvasElement
import pixi.core.{SystemRenderer, Texture, BaseTexture, DisplayObject}
import pixi.core.webgl.managers._
import pixi.core.webgl.utils.{RenderTarget, ObjectRenderer}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The WebGLRenderer draws the scene and all its content onto a webGL enabled canvas. This renderer
  * should be used for browsers that support webGL. This Render works by automatically managing webGLBatchs.
  * So no need for Sprite Batches or Sprite Clouds.
  * Don't forget to add the view to your DOM or you will not see anything :)
  * @constructor
  * @param _width the width of the canvas view
  * @param _height the height of the canvas view
  * @param _options The optional renderer parameters
  */
@JSName("PIXI.WebGLRenderer")
class WebGLRenderer(_width: Int = 0, _height: Int = 0, _options: WebGLRenderer.Options)
  extends SystemRenderer("WebGL", _width, _height, _options) {

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

  /** Renders the object to its webGL view
    *
    * @param obj the object to be rendered
    */
  def render(obj: DisplayObject): Unit = js.native

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

object WebGLRenderer {

  /** WebGL renderer options */
  trait Options extends SystemRenderer.Options

  /** The options of the renderer
    *
    * @param view the canvas to use as a view, optional
    * @param transparent If the render view is transparent, default false
    * @param autoResize If the render view is automatically resized, default false
    * @param antialias sets antialias (only applicable in chrome at the moment)
    * @param forceFXAA forces FXAA antialiasing to be used over native. FXAA is faster, but may not always look as great
    * @param resolution the resolution of the renderer retina would be 2
    * @param clearBeforeRender This sets if the CanvasRenderer will clear the canvas or
    * @param preserveDrawingBuffer enables drawing buffer preservation, enable this if you need to call toDataUrl on
    *                              the webgl context.
    * @return A JavaScript object with the renderer options
    */
  def options(view: HTMLCanvasElement = null,
              transparent: Boolean = false,
              autoResize: Boolean = false,
              antialias: Boolean = false,
              forceFXAA: Boolean = false,
              resolution: Double = 1,
              clearBeforeRender: Boolean = true,
              preserveDrawingBuffer: Boolean = false): Options = {
    val opt = js.Dynamic.literal(
      transparent = transparent,
      autoResize = autoResize,
      antialias = antialias,
      forceFXAA = forceFXAA,
      resolution = resolution,
      clearBeforeRender = clearBeforeRender,
      preserveDrawingBuffer = preserveDrawingBuffer)

    if (view != null) {
      opt.view = view
    }
    opt.asInstanceOf[Options]
  }
}