package pixi

import scala.scalajs.js
import js.Dynamic.{global => g}

/**
 * @author Marcelo Serra Castilhos
 */
object Consts {
  /** String of the current PIXI version */
  val VERSION = g.PIXI.VERSION.asInstanceOf[String]

  /** Two Pi */
  val PI_2: Double = g.PIXI.PI_2.asInstanceOf[Double]

  /** Constant conversion factor for converting radians to degrees */
  val RAD_TO_DEG: Double = g.PIXI.RAD_TO_DEG.asInstanceOf[Double]

  /** Constant conversion factor for converting degrees to radians */
  val DEG_TO_RAD: Double = g.PIXI.DEG_TO_RAD.asInstanceOf[Double]

  /** Target frames per millisecond. */
  val TARGET_FPMS: Double = g.PIXI.TARGET_FPMS.asInstanceOf[Double]

  /** Constant to identify the Renderer Type. */
  object RENDERER_TYPE {
    val UNKNOWN: Int = g.PIXI.RENDERER_TYPE.UNKNOWN.asInstanceOf[Int]
    val WEBGL: Int = g.PIXI.RENDERER_TYPE.WEBGL.asInstanceOf[Int]
    val CANVAS: Int = g.PIXI.RENDERER_TYPE.CANVAS.asInstanceOf[Int]
  }

  /**
   * The scale modes that are supported by pixi.
   *
   * The DEFAULT scale mode affects the default scaling mode of future operations.
   * It can be re-assigned to either LINEAR or NEAREST, depending upon suitability.
   */
  object SCALE_MODES {
    /** LINEAR */
    def DEFAULT: Int = g.PIXI.SCALE_MODES.DEFAULT.asInstanceOf[Int]

    def DEFAULT_=(scaleMode: Int): Unit = {
      g.PIXI.SCALE_MODES.DEFAULT = scaleMode
    }

    /** Smooth scaling */
    val LINEAR: Int = g.PIXI.SCALE_MODES.DEFAULT.asInstanceOf[Int]
    /** Pixelating scaling */
    val NEAREST: Int = g.PIXI.SCALE_MODES.DEFAULT.asInstanceOf[Int]
  }


  /** The prefix that denotes a URL is for a retina asset */
  val RETINA_PREFIX: String = g.PIXI.RETINA_PREFIX.asInstanceOf[String]

  val RESOLUTION: Int = g.PIXI.RESOLUTION.asInstanceOf[Int]

  val FILTER_RESOLUTION: Int = g.PIXI.FILTER_RESOLUTION.asInstanceOf[Int]

  val SPRITE_BATCH_SIZE: Int = g.PIXI.SPRITE_BATCH_SIZE.asInstanceOf[Int]
}
