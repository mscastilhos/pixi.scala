package pixi.core.webgl.shaders

import pixi.core.webgl.managers.ShaderManager

import scala.scalajs.js.annotation.JSName

/**
* @constructor
* @param shaderManager The webgl shader manager this shader works for.
*/
@JSName("PIXI.ComplexPrimitiveShader")
class ComplexPrimitiveShader(shaderManager: ShaderManager) extends Shader