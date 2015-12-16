package pixi.core.webgl.utils

import org.scalajs.dom.raw.WebGLRenderingContext
import pixi.core.Rectangle

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.typedarray.Float32Array

/** Helper class to create a quad
  * @constructor
  * @param gl The gl context for this quad to use.
  */
@js.native
@JSName("PIXI.Quad")
class Quad(gl: WebGLRenderingContext) extends js.Object {
  /** An array of vertices */
  var vertices: Float32Array = js.native

  /** The Uvs of the quad */
  var uvs: Float32Array = js.native

  /** The color components of the triangles */
  var colors: Float32Array = js.native

  /** Maps two Rectangle to the quad
    *
    * @param rect the first rectangle
    * @param rect2 the second rectangle
    */
  def map(rect: Rectangle, rect2: Rectangle): Unit = js.native

  /** Binds the buffer and uploads the data
    *
    */
  def upload(): Unit = js.native
}

