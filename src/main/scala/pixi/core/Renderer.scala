package pixi.core

import org.scalajs.dom.raw.HTMLCanvasElement
import pixi.Env

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The CanvasRenderer draws the scene and all its content onto a 2d canvas. This renderer should be used for browsers that do not support webGL.
  * Don't forget to add the CanvasRenderer.view to your DOM or you will not see anything :)
  * @constructor
  */
@JSName("PIXI.SystemRenderer")
trait Renderer extends js.Object {

  /** The type of this renderer as a standardised const */
  var `type`: Int = js.native

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
  trait Options extends js.Object {
    /** the canvas to use as a view */
    var view: HTMLCanvasElement = js.native

    /** If the render view is transparent */
    var transparent: Boolean = js.native

    /** If the render view is automatically resized */
    var autoResize: Boolean = js.native

    /** sets antialias (only applicable in chrome at the moment) */
    var antialias: Boolean = js.native

    /** forces FXAA antialiasing to be used over native. FXAA is faster, but may not always look as great */
    var forceFXAA: Boolean = js.native

    /** the resolution of the renderer retina would be 2 */
    var resolution: Double = js.native

    /** The background color */
    var backgroundColor: Int = js.native

    /** This sets if the CanvasRenderer will clear the canvas or not before the new render pass. */
    var clearBeforeRender: Boolean = js.native

    /** enables drawing buffer preservation, enable this if you need to call toDataUrl on the webgl context. */
    var preserveDrawingBuffer: Boolean = js.native
  }

  object Options {
    /** The options of the renderer
      *
      * @param view the canvas to use as a view, optional
      * @param transparent If the render view is transparent, default false
      * @param autoResize If the render view is automatically resized, default false
      * @param antialias sets antialias (only applicable in chrome at the moment)
      * @param forceFXAA forces FXAA antialiasing to be used over native. FXAA is faster, but may not always look as great
      * @param resolution the resolution of the renderer retina would be 2
      * @param backgroundColor The background color
      * @param clearBeforeRender This sets if the CanvasRenderer will clear the canvas or not before the new render pass.
      * @param preserveDrawingBuffer enables drawing buffer preservation, enable this if you need to call toDataUrl on
      *                              the webgl context.
      * @return A JavaScript object with the renderer options
      */
    def apply(view: HTMLCanvasElement = null,
              transparent: Boolean = false,
              autoResize: Boolean = false,
              antialias: Boolean = false,
              forceFXAA: Boolean = false,
              resolution: Double = 1,
              backgroundColor: Int = 0x000000,
              clearBeforeRender: Boolean = true,
              preserveDrawingBuffer: Boolean = false): Options = {
      val opt: Options = js.Dynamic.literal(
        transparent = transparent,
        autoResize = autoResize,
        antialias = antialias,
        forceFXAA = forceFXAA,
        resolution = resolution,
        backgroundColor = backgroundColor,
        clearBeforeRender = clearBeforeRender,
        preserveDrawingBuffer = preserveDrawingBuffer).asInstanceOf[Options]

      if (view != null) {
        opt.view = view
      }
      opt
    }

    /** Default renderer options */
    val DEFAULT = apply()
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
                 options: Options = Options.DEFAULT,
                 noWebGL: Boolean = false): Renderer = {
    Env.PIXI.autoDetectRenderer(width, height, options, noWebGL).asInstanceOf[Renderer]
  }

}
