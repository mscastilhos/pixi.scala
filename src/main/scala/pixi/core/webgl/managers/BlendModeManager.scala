package pixi.core.webgl.managers

import pixi.core.webgl.WebGLRenderer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * @constructor
 * @param renderer The renderer this manager works for.
 */
@JSName("PIXI.BlendModeManager")
class BlendModeManager(renderer: WebGLRenderer) extends WebGLManager {

  var currentBlendMode: Int = js.native

  /** Sets-up the given blendMode from WebGL's point of view.
    *
    * @param blendMode the blendMode, should be a Pixi const, such as BlendModes.ADD
    */
  def setBlendMode(blendMode: Int): Unit = js.native
}

