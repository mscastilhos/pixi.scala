package pixi.core.webgl.filters

import pixi.core.{Texture, Sprite, Point}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The SpriteMaskFilter class
  * @constructor
  * @param sprite the target sprite
  */
@JSName("PIXI.SpriteMaskFilter")
class SpriteMaskFilter(sprite: Sprite) extends Filter {
  /** The texture used for the displacement map. Must be power of 2 sized texture. */
  var map: Texture = js.native

  /** The offset used to move the displacement map. */
  var offset: Point = js.native
}


