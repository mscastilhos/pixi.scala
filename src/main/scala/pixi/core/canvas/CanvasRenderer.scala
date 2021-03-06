package pixi.core.canvas

import org.scalajs.dom.raw.CanvasRenderingContext2D
import pixi.core.Renderer.Options
import pixi.core.Renderer

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.JSName

/** The CanvasRenderer draws the scene and all its content onto a 2d canvas. This renderer should be used for browsers that do not support webGL.
  * Don't forget to add the CanvasRenderer.view to your DOM or you will not see anything :)
  */
@js.native
@JSName("PIXI.CanvasRenderer")
class CanvasRenderer protected[pixi]() extends Renderer {

  /**
   * @param width the width of the canvas view
   * @param height the height of the canvas view
   * @param options The optional renderer parameters
   */
  def this(width: UndefOr[Int] = js.undefined,
           height: UndefOr[Int] = js.undefined,
           options: UndefOr[Options] = js.undefined) = this()

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

}


