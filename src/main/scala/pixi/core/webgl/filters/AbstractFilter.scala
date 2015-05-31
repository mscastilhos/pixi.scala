package pixi.core.webgl.filters

import pixi.core.webgl.WebGLRenderer
import pixi.core.webgl.utils.RenderTarget

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** This is the base class for creating a PIXI filter. Currently only WebGL supports filters.
  * If you want to make a custom filter this should be your base class.
  */
@JSName("PIXI.AbstractFilter")
trait AbstractFilter extends js.Object {

  /** The extra padding that the filter might need */
  var padding: Double = js.native

  /** The uniforms as an object */
  var uniforms: js.Object = js.native

  /**
   * Grabs a shader from the current renderer
   * @param renderer {WebGLRenderer} The renderer to retrieve the shader from
   */
  def getShader(renderer: WebGLRenderer): Unit = js.native

  /**
   * Applies the filter
   * @param renderer The renderer to retrieve the filter from
   * @param input
   * @param output
   * @param clear Whether or not we want to clear the outputTarget
   */
  def applyFilter(renderer: WebGLRenderer, input: RenderTarget, output: RenderTarget, clear: Boolean): Unit = js.native

  /** Syncs a uniform between the class object and the shaders.
    *
    */
  def syncUniform(): Unit = js.native
}

// TODO: Allow defining filters in Scala