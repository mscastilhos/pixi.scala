package pixi

/**
 * @author Marcelo Serra Castilhos
 */
object Consts {
  /** String of the current PIXI version */
  val VERSION = Env.PIXI.VERSION.asInstanceOf[String]

  /** Two Pi */
  val PI_2: Double = Env.PIXI.PI_2.asInstanceOf[Double]

  /** Constant conversion factor for converting radians to degrees */
  val RAD_TO_DEG: Double = Env.PIXI.RAD_TO_DEG.asInstanceOf[Double]

  /** Constant conversion factor for converting degrees to radians */
  val DEG_TO_RAD: Double = Env.PIXI.DEG_TO_RAD.asInstanceOf[Double]

  /** Target frames per millisecond. */
  val TARGET_FPMS: Double = Env.PIXI.TARGET_FPMS.asInstanceOf[Double]

  /** Constant to identify the Renderer Type. */
  object RENDERER_TYPE {
    val UNKNOWN: Int = Env.PIXI.RENDERER_TYPE.UNKNOWN.asInstanceOf[Int]
    val WEBGL: Int = Env.PIXI.RENDERER_TYPE.WEBGL.asInstanceOf[Int]
    val CANVAS: Int = Env.PIXI.RENDERER_TYPE.CANVAS.asInstanceOf[Int]
  }

  /**
   * Various blend modes supported by PIXI. IMPORTANT - The WebGL renderer only supports
   * the NORMAL, ADD, MULTIPLY and SCREEN blend modes. Anything else will silently act like
   * NORMAL.
   */
  object BLEND_MODES {
    val NORMAL: Int = Env.PIXI.BLEND_MODES.NORMAL.asInstanceOf[Int]
    val ADD: Int = Env.PIXI.BLEND_MODES.ADD.asInstanceOf[Int]
    val MULTIPLY: Int = Env.PIXI.BLEND_MODES.MULTIPLY.asInstanceOf[Int]
    val SCREEN: Int = Env.PIXI.BLEND_MODES.SCREEN.asInstanceOf[Int]
    val OVERLAY: Int = Env.PIXI.BLEND_MODES.OVERLAY.asInstanceOf[Int]
    val DARKEN: Int = Env.PIXI.BLEND_MODES.DARKEN.asInstanceOf[Int]
    val LIGHTEN: Int = Env.PIXI.BLEND_MODES.LIGHTEN.asInstanceOf[Int]
    val COLOR_DODGE: Int = Env.PIXI.BLEND_MODES.COLOR_DODGE.asInstanceOf[Int]
    val COLOR_BURN: Int = Env.PIXI.BLEND_MODES.COLOR_BURN.asInstanceOf[Int]
    val HARD_LIGHT: Int = Env.PIXI.BLEND_MODES.HARD_LIGHT.asInstanceOf[Int]
    val SOFT_LIGHT: Int = Env.PIXI.BLEND_MODES.SOFT_LIGHT.asInstanceOf[Int]
    val DIFFERENCE: Int = Env.PIXI.BLEND_MODES.DIFFERENCE.asInstanceOf[Int]
    val EXCLUSION: Int = Env.PIXI.BLEND_MODES.EXCLUSION.asInstanceOf[Int]
    val HUE: Int = Env.PIXI.BLEND_MODES.HUE.asInstanceOf[Int]
    val SATURATION: Int = Env.PIXI.BLEND_MODES.SATURATION.asInstanceOf[Int]
    val COLOR: Int = Env.PIXI.BLEND_MODES.COLOR.asInstanceOf[Int]
    val LUMINOSITY: Int = Env.PIXI.BLEND_MODES.LUMINOSITY.asInstanceOf[Int]
  }

  /**
   * The scale modes that are supported by pixi.
   *
   * The DEFAULT scale mode affects the default scaling mode of future operations.
   * It can be re-assigned to either LINEAR or NEAREST, depending upon suitability.
   */
  object SCALE_MODES {
    /** LINEAR */
    def DEFAULT: Int = Env.PIXI.SCALE_MODES.DEFAULT.asInstanceOf[Int]

    def DEFAULT_=(scaleMode: Int): Unit = {
      Env.PIXI.SCALE_MODES.DEFAULT = scaleMode
    }

    /** Smooth scaling */
    val LINEAR: Int = Env.PIXI.SCALE_MODES.DEFAULT.asInstanceOf[Int]
    /** Pixelating scaling */
    val NEAREST: Int = Env.PIXI.SCALE_MODES.DEFAULT.asInstanceOf[Int]
  }


  /** The prefix that denotes a URL is for a retina asset */
  val RETINA_PREFIX: String = Env.PIXI.RETINA_PREFIX.asInstanceOf[String]

  val RESOLUTION: Int = Env.PIXI.RESOLUTION.asInstanceOf[Int]

  val FILTER_RESOLUTION: Int = Env.PIXI.FILTER_RESOLUTION.asInstanceOf[Int]

  /** Constants that identify shapes, mainly to prevent `instanceof` calls. */
  object SHAPES {
    val POLY: Int = Env.PIXI.SHAPES.POLY.asInstanceOf[Int]
    val RECT: Int = Env.PIXI.SHAPES.RECT.asInstanceOf[Int]
    val CIRC: Int = Env.PIXI.SHAPES.CIRC.asInstanceOf[Int]
    val ELIP: Int = Env.PIXI.SHAPES.ELIP.asInstanceOf[Int]
    val RREC: Int = Env.PIXI.SHAPES.RREC.asInstanceOf[Int]
  }

  val SPRITE_BATCH_SIZE: Int = Env.PIXI.SPRITE_BATCH_SIZE.asInstanceOf[Int]
}
