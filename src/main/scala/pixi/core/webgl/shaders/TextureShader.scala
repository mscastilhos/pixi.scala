package pixi.core.webgl.shaders

import pixi.core.webgl.managers.ShaderManager

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * @constructor
 * @param shaderManager The webgl shader manager this shader works for.
 * @param vertexSrc The source of the vertex shader.
 * @param fragmentSrc The source of the fragment shader.
 * @param customUniforms Custom uniforms to use to augment the built-in ones.
 * @param customAttributes Custom TextureShader attributes
 */
@JSName("PIXI.TextureShader")
class TextureShader(shaderManager: ShaderManager,
                    vertexSrc: js.Array[String],
                    fragmentSrc: js.Array[String],
                    customUniforms: js.Any,
                    customAttributes: js.Any) extends Shader