package pixi.core.canvas

import org.scalajs.dom.raw.CanvasRenderingContext2D
import pixi.core.{SystemRenderer, DisplayObject}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The CanvasRenderer draws the scene and all its content onto a 2d canvas. This renderer should be used for browsers that do not support webGL.
  * Don't forget to add the CanvasRenderer.view to your DOM or you will not see anything :)
  * @constructor
  * @param width the width of the canvas view
  * @param height the height of the canvas view
  * @param options The optional renderer parameters
  */
@JSName("PIXI.CanvasRenderer")
class CanvasRenderer(width: Int = 800,
                     height: Int = 600,
                     options: SystemRenderer.Options = SystemRenderer.options())
  extends SystemRenderer("Canvas", width, height, options) {

  /** The canvas 2d context that everything is drawn with. */
  var context: CanvasRenderingContext2D = js.native

  /** Boolean flag controlling canvas refresh. */
  var refresh: Boolean = js.native

  /** Instance of a CanvasMaskManager, handles masking when using the canvas renderer. */
  var maskManager: utils.CanvasMaskManager = js.native

  /** If true Pixi will Math.floor() x/y values when rendering, stopping pixel interpolation.
    * Handy for crisp pixel art and speed on legacy devices.
    */
  var roundPixels: Boolean = js.native

  //TODO currentScaleMode
  /* * Tracks the active scale mode for this renderer. */
  //var currentScaleMode: SCALE_MODE = js.native

  // TODO: currentBlendMode
  /* * Tracks the active blend mode for this renderer. */
  //var currentBlendMode: SCALE_MODE = js.native

  /** The canvas property used to set the canvas smoothing property. */
  var smoothProperty: String = js.native

  /** Renders the object to this canvas view
    *
    * @param obj the object to be rendered
    */
  def render(obj: DisplayObject): Unit = js.native
}


