package pixi.core.webgl.filters

import pixi.core.webgl.WebGLRenderer
import pixi.core.webgl.filters.Filter.Uniform
import pixi.core.webgl.utils.RenderTarget

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import js.Dynamic.{global => g}

/** This is the base class for creating a PIXI filter. Currently only WebGL supports filters.
  * If you want to make a custom filter this should be your base class.
  */
@js.native
@JSName("PIXI.AbstractFilter")
class Filter protected[pixi]() extends js.Object {

  /** This is the base class for creating a PIXI filter. Currently only WebGL supports filters. If you want to make a
    * custom filter this should be your base class.
    *
    * @param vertexSrc The vertex shader source as an array of strings.
    * @param fragmentSrc The fragment shader source as an array of strings.
    * @param uniforms An object containing the uniforms for this filter.
    */
  def this(vertexSrc: String | js.Array[String], fragmentSrc: String | js.Array[String], uniforms: js.Dictionary[Uniform]) = this()

  /** The extra padding that the filter might need */
  var padding: Double = js.native

  /** The uniforms as an object */
  var uniforms: js.Dictionary[Uniform] = js.native

  /**
   * Applies the filter
   * @param renderer The renderer to retrieve the filter from
   * @param input
   * @param output
   * @param clear Whether or not we want to clear the outputTarget
   */
  def applyFilter(renderer: WebGLRenderer, input: RenderTarget, output: RenderTarget, clear: Boolean): Unit = js.native

  /**
   * Grabs a shader from the current renderer
   * @param renderer {WebGLRenderer} The renderer to retrieve the shader from
   */
  def getShader(renderer: WebGLRenderer): Unit = js.native

  /** Syncs a uniform between the class object and the shaders. */
  def syncUniform(): Unit = js.native
}


object Filter {
  /** Creates a filter
    * @param vertexSrc {string|string[]} The vertex shader source as an array of strings.
    * @param fragmentSrc {string|string[]} The fragment shader source as an array of strings.
    * @param uniforms {object} An object containing the uniforms for this filter.
    */
  def apply(vertexSrc: String = null,
            fragmentSrc: String = null,
            uniforms: js.Dictionary[Uniform] = js.Dictionary()): Filter = {
    js.Dynamic.newInstance(g.PIXI.AbstractFilter)(vertexSrc, fragmentSrc, uniforms).asInstanceOf[Filter]
  }

  @ScalaJSDefined
  class Uniform(var `type`: String, var value: js.Any) extends js.Object {

    @inline
    def get[T]: T = value.asInstanceOf[T]

    @inline
    def set[T](value: T) = {
      this.value = value.asInstanceOf[js.Any]
    }
  }

}