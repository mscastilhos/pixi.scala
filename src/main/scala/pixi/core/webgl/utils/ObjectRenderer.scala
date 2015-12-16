package pixi.core.webgl.utils

import pixi.core.webgl.WebGLRenderer
import pixi.core.webgl.managers.WebGLManager

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** Base for a common object renderer that can be used as a system renderer plugin.
  * @constructor
  * @param renderer The renderer this object renderer works for.
  */
@js.native
@JSName("PIXI.ObjectRenderer")
class ObjectRenderer(renderer: WebGLRenderer) extends WebGLManager {
  /** Starts the renderer and sets the shader */
  def start(): Unit = js.native

  /** Stops the renderer */
  def stop(): Unit = js.native

  /** flushes */
  def flush(): Unit = js.native

  /** Renders an object */
  def render(): Unit = js.native
}
