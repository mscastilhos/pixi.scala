package pixi.core

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.annotation.ScalaJSDefined

/** The scale modes that are supported by pixi. */
@ScalaJSDefined
sealed trait ScaleMode extends js.Object

/** The scale modes that are supported by pixi.
  *
  * The `Default` scale mode affects the default scaling mode of future operations.
  * It can be re-assigned to either `Linear` or `Nearest`, depending upon suitability.
  */
object ScaleMode {
  /** LINEAR */
  @inline
  def Default: ScaleMode = g.PIXI.SCALE_MODES.DEFAULT.asInstanceOf[ScaleMode]

  @inline
  def Default_=(scaleMode: ScaleMode): Unit = {
    g.PIXI.SCALE_MODES.DEFAULT = scaleMode
  }

  /** Smooth scaling */
  val Linear: ScaleMode = g.PIXI.SCALE_MODES.DEFAULT.asInstanceOf[ScaleMode]
  /** Pixelating scaling */
  val Nearest: ScaleMode = g.PIXI.SCALE_MODES.DEFAULT.asInstanceOf[ScaleMode]
}