package pixi.filters

import pixi.core.{Point, Texture}
import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The NormalMapFilter class uses the pixel values from the specified texture (called the normal map)
  * to project lighting onto an object.
  * @constructor
  * @param texture The texture used for the normal map, must be power of 2 texture at the moment
  */
@JSName("PIXI.filters.NormalMapFilter")
class NormalMapFilter(texture: Texture) extends Filter {
  /** Sets the map dimensions uniforms when the texture becomes available.
    *
    */
  def onTextureLoaded(): Unit = js.native

  /** The texture used for the displacement map. Must be power of 2 texture. */
  var map: Texture = js.native

  /** The multiplier used to scale the displacement result from the map calculation. */
  var scale: Point = js.native

  /** The offset used to move the displacement map. */
  var offset: Point = js.native
}
