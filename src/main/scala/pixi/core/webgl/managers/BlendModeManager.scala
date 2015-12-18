package pixi.core.webgl.managers

import pixi.core.BlendMode
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

