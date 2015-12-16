package pixi.core.webgl.managers

import pixi.core.webgl.WebGLRenderer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("PIXI.WebGLManager")
trait WebGLManager extends js.Object {
  /** The renderer this manager works for. */
  var renderer: WebGLRenderer = js.native

  /** Generic method called when there is a WebGL context change. */
  def onContextChange(): Unit = js.native

  /** Generic destroy methods to be overridden by the subclass */
  def destroy(): Unit = js.native
}
