package pixi.filters

import pixi.core.{Texture, Sprite}
import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The DisplacementFilter class uses the pixel values from the specified texture (called the displacement map) to
  * perform a displacement of an object.
  *
  * You can use this filter to apply all manor of crazy warping effects
  * Currently the r property of the texture is used to offset the x and the g property of the texture is used to offset the y.
  * @constructor
  * @param sprite the sprite used for the displacement map. (make sure its added to the scene!)
  */
@JSName("PIXI.filters.DisplacementFilter")
class DisplacementFilter(sprite: Sprite) extends Filter {
  /** The texture used for the displacement map. Must be power of 2 sized texture. */
  var map: Texture = js.native
}

