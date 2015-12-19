import pixi.loaders.Loader

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.RegExp

/** Pixi
  */
package object pixi {
  type AbstractFilter = pixi.core.webgl.filters.Filter
  type SystemRenderer = pixi.core.Renderer

  /** The asset loader */
  val loader: Loader = g.PIXI.loader.asInstanceOf[Loader]

  /** String of the current PIXI version */
  val Version = g.PIXI.VERSION.asInstanceOf[String]

  /** Two Pi */
  val Pi_2: Double = g.PIXI.PI_2.asInstanceOf[Double]

  /** Constant conversion factor for converting radians to degrees */
  val RadToDeg: Double = g.PIXI.RAD_TO_DEG.asInstanceOf[Double]

  /** Constant conversion factor for converting degrees to radians */
  val DegToRad: Double = g.PIXI.DEG_TO_RAD.asInstanceOf[Double]

  /** Target frames per millisecond. */
  val TargetFpms: Double = g.PIXI.TARGET_FPMS.asInstanceOf[Double]

  /** The prefix that denotes a URL is for a retina asset */
  val RetinaPrefix: RegExp = g.PIXI.RETINA_PREFIX.asInstanceOf[RegExp]

  val Resolution: Int = g.PIXI.RESOLUTION.asInstanceOf[Int]

  val FilterResolution: Int = g.PIXI.FILTER_RESOLUTION.asInstanceOf[Int]

  val SpriteBatchSize: Int = g.PIXI.SPRITE_BATCH_SIZE.asInstanceOf[Int]
}
