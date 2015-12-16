package pixi.core.webgl.managers

import org.scalajs.dom.webgl.Shader
import pixi.core.webgl.WebGLRenderer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * @constructor
 * @param renderer The renderer this manager works for.
 */
@js.native
@JSName("PIXI.ShaderManager")
class ShaderManager(renderer: WebGLRenderer) extends WebGLManager {

  var maxAttibs: Int = js.native
  var attribState: js.Array[js.Any] = js.native
  var tempAttribState: js.Array[js.Any] = js.native
  var stack: js.Array[js.Any] = js.native


  /** Takes the attributes given in parameters and uploads them.
    *
    * @param attribs attribs
    */
  def setAttribs(attribs: js.Array[js.Any]): Unit = js.native

  /** Sets the current shader.
    *
    * @param shader the shader to upload
    */
  def setShader(shader: Shader): Unit = js.native

}