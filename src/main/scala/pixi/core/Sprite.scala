package pixi.core

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.annotation.JSName


/** The Sprite object is the base for all textured objects that are rendered to the screen
  *
  * A sprite can be created directly from an image like this:
  *
  * {{{
  * val sprite = Sprite.fromImage('assets/image.png');
  * }}}
  */
@js.native
@JSName("PIXI.Sprite")
class Sprite protected[pixi]() extends Container {

  /**
   * @param texture The texture for this sprite
   */
  def this(texture: Texture) = this()

  /** The anchor sets the origin point of the texture.
The default is 0,0 this means the texture's origin is the top left
Setting the anchor to 0.5,0.5 means the texture's origin is centered
Setting the anchor to 1,1 would mean the texture's origin point will be the bottom right corner */
  var anchor: Point = js.native

  /** The tint applied to the sprite. This is a hex value. A value of 0xFFFFFF will remove any tint effect. */
  var tint: Int = js.native

  /** The blend mode to be applied to the sprite. Apply a value of [[BlendMode.N]] to reset the blend mode. */
  var blendMode: BlendMode = js.native

  /** The shader that will be used to render the sprite. Set to null to remove a current shader. */
  var shader: Filter = js.native

  /** The texture that the sprite is using */
  var texture: Texture = js.native

  /** Tests if a point is inside this sprite
    *
    * @param point the point to test
    * @return the result of the test
    */
  def containsPoint(point: Point): Boolean = js.native

  /** Destroys this sprite and optionally its texture
    *
    * @param destroyTexture Should it destroy the current texture of the sprite as well
    * @param destroyBaseTexture Should it destroy the base texture of the sprite as well
    */
  def destroy(destroyTexture: Boolean, destroyBaseTexture: Boolean): Unit = js.native
}

object Sprite {
  /** Helper function that creates a sprite that will contain a texture from the TextureCache based on the frameId
    * The frame ids are created when a Texture packer file has been loaded
    *
    * @param frameId The frame Id of the texture in the cache
    * @return A new Sprite using a texture from the texture cache matching the frameId
    */
  @inline
  def fromFrame(frameId: String): Sprite = {
    g.PIXI.Sprite.fromFrame(frameId).asInstanceOf[Sprite]
  }

  /** Helper function that creates a sprite that will contain a texture based on an image url
    * If the image is not in the texture cache it will be loaded
    *
    * @param imageId The image url of the texture
    * @return A new Sprite using a texture from the texture cache matching the image id
    */
  @inline
  def fromImage(imageId: String): Sprite = {
    g.PIXI.Sprite.fromImage(imageId).asInstanceOf[Sprite]
  }
}
