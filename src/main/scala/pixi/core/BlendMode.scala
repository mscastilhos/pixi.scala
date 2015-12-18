package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Blend modes supported by PIXI. IMPORTANT - The WebGL renderer only supports
  * the NORMAL, ADD, MULTIPLY and SCREEN blend modes. Anything else will silently act like
  * NORMAL.
  */
@ScalaJSDefined
sealed trait BlendMode extends js.Object

object BlendMode {

  import js.Dynamic.{global => g}

  val Normal: BlendMode = g.PIXI.BLEND_MODES.NORMAL.asInstanceOf[BlendMode]
  val Add: BlendMode = g.PIXI.BLEND_MODES.ADD.asInstanceOf[BlendMode]
  val Multiply: BlendMode = g.PIXI.BLEND_MODES.MULTIPLY.asInstanceOf[BlendMode]
  val Screen: BlendMode = g.PIXI.BLEND_MODES.SCREEN.asInstanceOf[BlendMode]
  val Overlay: BlendMode = g.PIXI.BLEND_MODES.OVERLAY.asInstanceOf[BlendMode]
  val Darken: BlendMode = g.PIXI.BLEND_MODES.DARKEN.asInstanceOf[BlendMode]
  val Lighten: BlendMode = g.PIXI.BLEND_MODES.LIGHTEN.asInstanceOf[BlendMode]
  val ColorDodge: BlendMode = g.PIXI.BLEND_MODES.COLOR_DODGE.asInstanceOf[BlendMode]
  val ColorBurn: BlendMode = g.PIXI.BLEND_MODES.COLOR_BURN.asInstanceOf[BlendMode]
  val HardLight: BlendMode = g.PIXI.BLEND_MODES.HARD_LIGHT.asInstanceOf[BlendMode]
  val SoftLight: BlendMode = g.PIXI.BLEND_MODES.SOFT_LIGHT.asInstanceOf[BlendMode]
  val Difference: BlendMode = g.PIXI.BLEND_MODES.DIFFERENCE.asInstanceOf[BlendMode]
  val Exclusion: BlendMode = g.PIXI.BLEND_MODES.EXCLUSION.asInstanceOf[BlendMode]
  val Hue: BlendMode = g.PIXI.BLEND_MODES.HUE.asInstanceOf[BlendMode]
  val Saturation: BlendMode = g.PIXI.BLEND_MODES.SATURATION.asInstanceOf[BlendMode]
  val Color: BlendMode = g.PIXI.BLEND_MODES.COLOR.asInstanceOf[BlendMode]
  val Luminosity: BlendMode = g.PIXI.BLEND_MODES.LUMINOSITY.asInstanceOf[BlendMode]
}
