package pixi.core

import org.scalajs.dom.raw.HTMLCanvasElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The CanvasRenderer draws the scene and all its content onto a 2d canvas. This renderer should be used for browsers that do not support webGL.
  * Don't forget to add the CanvasRenderer.view to your DOM or you will not see anything :)
  * @constructor
  * @param _system The name of the system this renderer is for.
  * @param _width the width of the canvas view
  * @param _height the height of the canvas view
  * @param _options The optional renderer parameters
  */
@JSName("PIXI.SystemRenderer")
class SystemRenderer(_system: String,
                     _width: Int = 800,
                     _height: Int = 600,
                     _options: SystemRenderer.Options = SystemRenderer.options()) extends js.Object {

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
}

object SystemRenderer {

  /** Renderer options */
  trait Options extends js.Object

  /** The options of the renderer
    *
    * @param view the canvas to use as a view, optional
    * @param transparent If the render view is transparent, default false
    * @param autoResize If the render view is automatically resized, default false
    * @param antialias sets antialias (only applicable in chrome at the moment)
    * @param resolution the resolution of the renderer retina would be 2
    * @param clearBeforeRender This sets if the CanvasRenderer will clear the canvas or
    * @return A JavaScript object with the renderer options
    */
  def options(view: HTMLCanvasElement = null,
              transparent: Boolean = false,
              autoResize: Boolean = false,
              antialias: Boolean = false,
              resolution: Double = 1,
              clearBeforeRender: Boolean = true): Options = {
    val opt = js.Dynamic.literal(
      transparent = transparent,
      autoResize = autoResize,
      antialias = antialias,
      resolution = resolution,
      clearBeforeRender = clearBeforeRender)

    if (view != null) {
      opt.view = view
    }
    opt.asInstanceOf[Options]
  }

}
