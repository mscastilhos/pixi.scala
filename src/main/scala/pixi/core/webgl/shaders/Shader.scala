package pixi.core.webgl.shaders

import org.scalajs.dom.raw.{WebGLProgram, WebGLRenderingContext}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("PIXI.Shader")
trait Shader extends js.Object {
  /** A unique id */
  val uuid: Double = js.native

  /** The current WebGL drawing context */
  val gl: WebGLRenderingContext = js.native

  /** The WebGL program. */
  val program: WebGLProgram = js.native

  /** The vertex shader as an array of strings */
  var vertexSrc: String = js.native

  /** The fragment shader as an array of strings */
  var fragmentSrc: String = js.native

  /** Adds a new uniform
    *
    * @param uniform the new uniform to attach
    */
  def syncUniform(uniform: Object): Unit = js.native

  /** Initialises a Sampler2D uniform (which may only be available later on after initUniforms once the texture has
    * loaded)
    */
  def initSampler2D(): Unit = js.native

  /** Destroys the shader. */
  def destroy(): Unit = js.native
}

