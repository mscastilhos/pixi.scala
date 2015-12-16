package pixi.core

import org.scalajs.dom.raw.HTMLCanvasElement
import pixi.eventemitter3.EventEmitter

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.{ScalaJSDefined, JSName}

/** The CanvasRenderer draws the scene and all its content onto a 2d canvas. This renderer should be used for browsers that do not support webGL.
  * Don't forget to add the CanvasRenderer.view to your DOM or you will not see anything :)
  * @constructor
  */
@js.native
@JSName("PIXI.SystemRenderer")
trait Renderer extends EventEmitter {

  /** The type of this renderer as a standardised const */
  val `type`: Renderer.Type = js.native

  /** The type of this renderer as a standardised const */
  @JSName("type")
  val rendererType: Renderer.Type = js.native

  /** The width of the canvas view */
  var width: Int = js.native

  /** The height of the canvas view */
  var height: Int = js.native

  /** The canvas element that everything is drawn to */
  var view: HTMLCanvasElement = js.native

  /** The resolution of the renderer */
  var resolution: Double = js.native

  /** Whether the render view is transparent */
  var transparent: Boolean = js.native

  /** Whether the render view should be resized automatically */
  var autoResize: Boolean = js.native

  // TODO
  /* * Tracks the blend modes useful for this renderer. */
  //var blendModes: object<string, mixed > = js.native

  /** The value of the preserveDrawingBuffer flag affects whether or not the contents of the stencil buffer is retained
    * after rendering.
    */
  var preserveDrawingBuffer: Boolean = js.native

  /** This sets if the CanvasRenderer will clear the canvas or not before the new render pass.
    *
    * If the scene is NOT transparent Pixi will use a canvas sized fillRect operation every frame to set the canvas
    * background color.
    *
    * If the scene is transparent Pixi will use clearRect to clear the canvas every frame.
    *
    * Disable this by setting this to false. For example if your game has a canvas filling background image you often
    * don't need this set.
    */
  var clearBeforeRender: Boolean = js.native

  /** The background color to fill if not transparent */
  var backgroundColor: Int = js.native

  /** Resizes the canvas view to the specified width and height
    *
    * @param width the new width of the canvas view
    * @param height the new height of the canvas view
    */
  def resize(width: Int, height: Int): Unit = js.native

  /** Removes everything from the renderer and optionally removes the Canvas DOM element.
    *
    * @param removeView Removes the Canvas element from the DOM.
    */
  def destroy(removeView: Boolean = false): Unit = js.native

  /** Renders the object to this canvas view
    *
    * @param obj the object to be rendered
    */
  def render(obj: DisplayObject): Unit = js.native
}

object Renderer {

  /** Renderer options */
  @ScalaJSDefined
  class Options extends js.Object {
    /** the canvas to use as a view */
    var view: UndefOr[HTMLCanvasElement] = js.undefined
    /** If the render view is transparent */
    var transparent: UndefOr[Boolean] = js.undefined
    /** If the render view is automatically resized */
    var autoResize: UndefOr[Boolean] = js.undefined
    /** sets antialias (only applicable in chrome at the moment) */
    var antialias: UndefOr[Boolean] = js.undefined
    /** forces FXAA antialiasing to be used over native. FXAA is faster, but may not always look as great */
    var forceFXAA: UndefOr[Boolean] = js.undefined
    /** the resolution of the renderer retina would be 2 */
    var resolution: UndefOr[Double] = js.undefined
    /** The background color */
    var backgroundColor: UndefOr[Int] = js.undefined
    /** This sets if the CanvasRenderer will clear the canvas or not before the new render pass. */
    var clearBeforeRender: UndefOr[Boolean] = js.undefined
    /** enables drawing buffer preservation, enable this if you need to call toDataUrl on the webgl context. */
    var preserveDrawingBuffer: UndefOr[Boolean] = js.undefined
  }

  /**
    * This helper function will automatically detect which renderer you should be using.
    * WebGL is the preferred renderer as it is a lot faster. If webGL is not supported by
    * the browser then this function will return a canvas renderer
    *
    * @param width the width of the renderers view
    * @param height the height of the renderers view
    * @param options  The optional renderer parameters
    * @param noWebGL prevents selection of WebGL renderer, even if such is present
    *
    * @return  Returns WebGL renderer if available, otherwise CanvasRenderer
    */
  @inline
  def autoDetect(width: Int = 800,
                 height: Int = 600,
                 options: Options = new Options,
                 noWebGL: Boolean = false): Renderer = {
    js.Dynamic.global.PIXI.autoDetectRenderer(width, height, options, noWebGL).asInstanceOf[Renderer]
  }

  import js.Dynamic.{global => g}

  /** Constant to identify the Renderer Type. */
  @ScalaJSDefined
  sealed trait Type extends js.Object

  object Type {
    val Unknown: Type = g.PIXI.RENDERER_TYPE.UNKNOWN.asInstanceOf[Type]
    val WebGL: Type = g.PIXI.RENDERER_TYPE.WEBGL.asInstanceOf[Type]
    val Canvas: Type = g.PIXI.RENDERER_TYPE.CANVAS.asInstanceOf[Type]
  }

}
