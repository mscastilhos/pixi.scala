package pixi.extras

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const
import pixi.{Consts, Env}
import pixi.core.{Point, Texture, Sprite}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A tiling sprite is a fast way of rendering a tiling image
  * @constructor
  * @param _texture the texture of the tiling sprite
  * @param _width the width of the tiling sprite
  * @param _height the height of the tiling sprite
  */
@js.native
@JSName("PIXI.extras.TilingSprite")
class TilingSprite(_texture: Texture, _width: Double, _height: Double) extends Sprite(_texture) {
  /** The scaling of the image that is being tiled */
  var tileScale: Point = js.native

  /** The offset position of the image that is being tiled */
  var tilePosition: Point = js.native
}

object TilingSprite {
  /** Helper function that creates a tiling sprite that will use a texture from the TextureCache based on the frameId
    * The frame ids are created when a Texture packer file has been loaded
    *
    * @param frameId The frame Id of the texture in the cache
    * @param width the width of the tiling sprite
    * @param height the height of the tiling sprite
    * @return A new TilingSprite using a texture from the texture cache matching the frameId
    */
  @inline
  def fromFrame(frameId: String, width: Int, height: Int): TilingSprite = {
    Env.PIXI.extras.TilingSprite.fromFrame(frameId, width, height).asInstanceOf[TilingSprite]
  }

  /** Helper function that creates a sprite that will contain a texture based on an image url
    * If the image is not in the texture cache it will be loaded
    *
    * @param imageId The image url of the texture
    * @param width the width of the tiling sprite
    * @param height the height of the tiling sprite
    * @return A new TilingSprite using a texture from the texture cache matching the image id
    */
  @inline
  def fromImage(imageId: String, width: Int, height: Int): TilingSprite = {
    Env.PIXI.extras.TilingSprite.fromImage(imageId, width, height).asInstanceOf[TilingSprite]
  }

  /** Helper function that creates a sprite that will contain a texture based on an image url
    * If the image is not in the texture cache it will be loaded
    *
    * @param imageId The image url of the texture
    * @param width the width of the tiling sprite
    * @param height the height of the tiling sprite
    * @param crossorigin if you want to specify the cross-origin parameter
    * @param scaleMode if you want to specify the scale mode, see { @link SCALE_MODES} for possible values
    * @return A new TilingSprite using a texture from the texture cache matching the image id
    */
  @inline
  def fromImage(imageId: String,
                width: Int,
                height: Int,
                crossorigin: Boolean,
                scaleMode: Double = Consts.SCALE_MODES.DEFAULT): TilingSprite = {
    Env.PIXI.extras.TilingSprite.fromImage(imageId, width, height, crossorigin, scaleMode).asInstanceOf[TilingSprite]
  }
}

