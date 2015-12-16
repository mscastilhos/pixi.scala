package pixi.core.webgl.shaders

import pixi.core.webgl.managers.ShaderManager

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * @constructor
 * @param shaderManager The webgl shader manager this shader works for.
 */
@js.native
@JSName("PIXI.PrimitiveShader")
class PrimitiveShader(shaderManager: ShaderManager) extends Shader