package pixi.mesh

import pixi.core.{Container, Texture, Matrix, Rectangle}
import pixi.mesh.Mesh.DRAW_MODES

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.typedarray.{Uint16Array, Float32Array}

/** Base mesh class
  * @constructor
  * @param _texture The texture to use
  * @param _vertices if you want to specify the vertices
  * @param _uvs if you want to specify the uvs
  * @param _indices if you want to specify the indices
  * @param _drawMode the drawMode, can be any of the Mesh.DRAW_MODES consts
  */
@JSName("PIXI.mesh.Mesh")
class Mesh(_texture: Texture,
           _vertices: Float32Array = null,
           _uvs: Float32Array = null,
           _indices: Uint16Array = null,
           _drawMode: Int = DRAW_MODES.TRIANGLE_MESH) extends Container {

  /** The Uvs of the Mesh */
  var uvs: Float32Array = js.native

  /** An array of vertices */
  var vertices: Float32Array = js.native

  /** Whether the Mesh is dirty or not */
  var dirty: Boolean = js.native

  /** The blend mode to be applied to the sprite. Set to blendModes.NORMAL to remove any blend mode. */
  var blendMode: Double = js.native

  /** Triangles in canvas mode are automatically antialiased, use this value to force triangles to overlap a bit with each other. */
  var canvasPadding: Double = js.native

  /** The way the Mesh should be drawn, can be any of the Mesh.DRAW_MODES consts */
  var drawMode: Double = js.native

  /** The texture that the sprite is using */
  var texture: Texture = js.native
}

object Mesh {

  /** Different drawing buffer modes supported */
  object DRAW_MODES {
    val TRIANGLE_MESH: Int = js.Dynamic.global.PIXI.Mesh.DRAW_MODES.TRIANGLE_MESH.asInstanceOf[Int]
    val TRIANGLES: Int = js.Dynamic.global.PIXI.Mesh.DRAW_MODES.TRIANGLES.asInstanceOf[Int]
  }

}