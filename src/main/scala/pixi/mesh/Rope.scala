package pixi.mesh

import pixi.core.{Point, Texture}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The rope allows you to draw a texture across several points and them manipulate these points
  *
  * {{{
  * val points = 0 until 20 map (new Point(_ * 50, 0))
  * val rope = new Rope(Texture.fromImage("snake.png"), points.to[js.Array]);
  * }}}
  *
  * @constructor
  * @param texture The texture to use on the rope.
  * @param points An array of Point objects to construct this rope.
  */
@JSName("PIXI.mesh.Rope")
class Rope(texture: Texture, points: js.Array[Point]) extends Mesh(texture) {

  /** Refreshes */
  def refresh(): Unit = js.native

}