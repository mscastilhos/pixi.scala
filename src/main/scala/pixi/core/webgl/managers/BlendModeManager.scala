package pixi.core.webgl.managers

import pixi.core.webgl.WebGLRenderer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("PIXI.BlendModeManager")
class BlendModeManager protected[pixi]() extends WebGLManager {
  /** @param renderer The renderer this manager works for.
    * @return
    */
  def this(renderer: WebGLRenderer) = this()

  var currentBlendMode: BlendMode = js.native

  /** Sets-up the given blendMode from WebGL's point of view.
    * @param blendMode the blendMode, should be a Pixi const, such as BlendModes.ADD
    */
  def setBlendMode(blendMode: BlendMode): Unit = js.native
}

/**
  * Blend modes supported by PIXI. IMPORTANT - The WebGL renderer only supports
  * the NORMAL, ADD, MULTIPLY and SCREEN blend modes. Anything else will silently act like
  * NORMAL.
  */
sealed trait BlendMode extends js.Object
object BlendMode {
  import js.Dynamic.{global => g}
  val NORMAL: BlendMode = g.PIXI.BLEND_MODES.NORMAL.asInstanceOf[BlendMode]
  val ADD: BlendMode = g.PIXI.BLEND_MODES.ADD.asInstanceOf[BlendMode]
  val MULTIPLY: BlendMode = g.PIXI.BLEND_MODES.MULTIPLY.asInstanceOf[BlendMode]
  val SCREEN: BlendMode = g.PIXI.BLEND_MODES.SCREEN.asInstanceOf[BlendMode]
  val OVERLAY: BlendMode = g.PIXI.BLEND_MODES.OVERLAY.asInstanceOf[BlendMode]
  val DARKEN: BlendMode = g.PIXI.BLEND_MODES.DARKEN.asInstanceOf[BlendMode]
  val LIGHTEN: BlendMode = g.PIXI.BLEND_MODES.LIGHTEN.asInstanceOf[BlendMode]
  val COLOR_DODGE: BlendMode = g.PIXI.BLEND_MODES.COLOR_DODGE.asInstanceOf[BlendMode]
  val COLOR_BURN: BlendMode = g.PIXI.BLEND_MODES.COLOR_BURN.asInstanceOf[BlendMode]
  val HARD_LIGHT: BlendMode = g.PIXI.BLEND_MODES.HARD_LIGHT.asInstanceOf[BlendMode]
  val SOFT_LIGHT: BlendMode = g.PIXI.BLEND_MODES.SOFT_LIGHT.asInstanceOf[BlendMode]
  val DIFFERENCE: BlendMode = g.PIXI.BLEND_MODES.DIFFERENCE.asInstanceOf[BlendMode]
  val EXCLUSION: BlendMode = g.PIXI.BLEND_MODES.EXCLUSION.asInstanceOf[BlendMode]
  val HUE: BlendMode = g.PIXI.BLEND_MODES.HUE.asInstanceOf[BlendMode]
  val SATURATION: BlendMode = g.PIXI.BLEND_MODES.SATURATION.asInstanceOf[BlendMode]
  val COLOR: BlendMode = g.PIXI.BLEND_MODES.COLOR.asInstanceOf[BlendMode]
  val LUMINOSITY: BlendMode = g.PIXI.BLEND_MODES.LUMINOSITY.asInstanceOf[BlendMode]
}
