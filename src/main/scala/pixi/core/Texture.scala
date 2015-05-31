package pixi.core

import org.scalajs.dom.html.Canvas
import org.scalajs.dom.raw.HTMLVideoElement
import pixi.Env

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A texture stores the information that represents an image or part of an image. It cannot be added
  * to the display list directly. Instead use it as the texture for a Sprite. If no frame is provided then the whole image is used.
  *
  * You can directly create a texture from an image and then reuse it multiple times like this :
  *
  * {{{
  * val texture = Texture.fromImage("assets/image.png");
  * val sprite1 = new Sprite(texture);
  * val sprite2 = new Sprite(texture);
  * }}}
  */
@JSName("PIXI.Texture")
trait Texture extends js.Object {
  /** Does this Texture have any frame data assigned to it? */
  var noFrame: Boolean = js.native

  /** The base texture that this texture uses. */
  var baseTexture: BaseTexture = js.native

  /** The texture trim data. */
  var trim: Rectangle = js.native

  /** This will let the renderer know if the texture is valid. If it's not then it cannot be rendered. */
  var valid: Boolean = js.native

  /** This will let a renderer know that a texture has been updated (used mainly for webGL uv updates) */
  var requiresUpdate: Boolean = js.native

  /** The width of the Texture in pixels. */
  var width: Int = js.native

  /** The height of the Texture in pixels. */
  var height: Int = js.native

  /** This is the area of the BaseTexture image to actually copy to the Canvas / WebGL when rendering,
irrespective of the actual frame size or placement (which can be influenced by trimmed texture atlases) */
  var crop: Rectangle = js.native

  /** Updates this texture on the gpu. */
  def update(): Unit = js.native

  /** Destroys this texture
    *
    * @param destroyBase Whether to destroy the base texture as well
    */
  def destroy(destroyBase: Boolean): Unit = js.native
}

object Texture {
  /** Helper function that creates a Texture object from the given image url.
    * If the image is not in the texture cache it will be  created and loaded.
    *
    * @param imageUrl The image url of the texture
    * @return The newly created texture
    */
  @inline
  def fromImage(imageUrl: String): Texture = {
    Env.PIXI.Texture.fromImage(imageUrl).asInstanceOf[Texture]
  }

  /** Helper function that creates a Texture object from the given image url.
    * If the image is not in the texture cache it will be  created and loaded.
    *
    * @param imageUrl The image url of the texture
    * @param crossorigin Whether requests should be treated as crossorigin
    * @param scaleMode See {{#crossLink "PIXI/scaleModes:property"}}scaleModes{{/crossLink}} for possible values
    * @return The newly created texture
    */
  @inline
  def fromImage(imageUrl: String, crossorigin: Boolean, scaleMode: Int = Consts.SCALE_MODES.DEFAULT): Texture = {
    Env.PIXI.Texture.fromImage(imageUrl, crossorigin, scaleMode).asInstanceOf[Texture]
  }

  /** Helper function that creates a sprite that will contain a texture from the TextureCache based on the frameId
    * The frame ids are created when a Texture packer file has been loaded
    *
    * @param frameId The frame Id of the texture in the cache
    * @return The newly created texture
    */
  @inline
  def fromFrame(frameId: String): Texture = {
    Env.PIXI.Texture.fromFrame(frameId).asInstanceOf[Texture]
  }

  /** Helper function that creates a new Texture based on the given canvas element.
    *
    * @param canvas The canvas element source of the texture
    * @param scaleMode See {{#crossLink "PIXI/scaleModes:property"}}scaleModes{{/crossLink}} for possible values
    * @return
    */
  @inline
  def fromCanvas(canvas: Canvas, scaleMode: Int = Consts.SCALE_MODES.DEFAULT): Texture = {
    Env.PIXI.Texture.fromCanvas(canvas, scaleMode).asInstanceOf[Texture]
  }

  /** Helper function that creates a new Texture based on the given video element.
    *
    * @param video
    * @param scaleMode See {{#crossLink "PIXI/scaleModes:property"}}scaleModes{{/crossLink}} for possible values
    * @return A Texture
    */
  @inline
  def fromVideo(video: HTMLVideoElement, scaleMode: Int = Consts.SCALE_MODES.DEFAULT): Texture = {
    Env.PIXI.Texture.fromVideo(video, scaleMode).asInstanceOf[Texture]
  }

  /** Helper function that creates a new Texture based on the video url.
    *
    * @param videoUrl
    * @param scaleMode See {{ @link SCALE_MODES}} for possible values
    * @return A Texture
    */
  @inline
  def fromVideoUrl(videoUrl: String, scaleMode: Int = Consts.SCALE_MODES.DEFAULT): Texture = {
    Env.PIXI.Texture.fromVideoUrl(videoUrl, scaleMode).asInstanceOf[Texture]
  }

  /** Adds a texture to the global utils.TextureCache. This cache is shared across the whole PIXI object.
    *
    * @param texture The Texture to add to the cache.
    * @param id The id that the texture will be stored against.
    */
  @inline
  def addTextureToCache(texture: Texture, id: String): Unit = {
    Env.PIXI.Texture.addTextureToCache(texture, id)
  }

  /** Remove a texture from the global utils.TextureCache.
    *
    * @param id The id of the texture to be removed
    * @return The texture that was removed
    */
  @inline
  def removeTextureFromCache(id: String): Texture = {
    Env.PIXI.Texture.removeTextureFromCache(id).asInstanceOf[Texture]
  }
}
