package pixi.core

import org.scalajs.dom.html.Canvas
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A texture stores the information that represents an image. All textures have a base texture.
  * @constructor
  * @param _source the source object of the texture.
  * @param _scaleMode See { @link SCALE_MODES} for possible values
  * @param _resolution the resolution of the texture for devices with different pixel ratios
  */
@JSName("PIXI.BaseTexture")
class BaseTexture(_source: HTMLElement,
                  _scaleMode: Int = Consts.SCALE_MODES.DEFAULT,
                  _resolution: Double = 1) extends js.Object {
  /** The Resolution of the texture. */
  var resolution: Double = js.native

  /** The width of the base texture set when the image has loaded */
  val width: Int = js.native

  /** The height of the base texture set when the image has loaded */
  val height: Int = js.native

  /** Used to store the actual width of the source of this texture */
  val realWidth: Int = js.native

  /** Used to store the actual height of the source of this texture */
  val realHeight: Int = js.native

  /** The scale mode to apply when scaling this texture */
  var scaleMode: Object = js.native

  /** Set to true once the base texture has successfully loaded.
    *
    * This is never true if the underlying source fails to load or has no texture data.
    */
  val hasLoaded: Boolean = js.native

  /** Set to true if the source is currently loading.
    *
    * If an Image source is loading the 'loaded' or 'error' event will be
    * dispatched when the operation ends. An underyling source that is
    * immediately-available bypasses loading entirely.
    */
  val isLoading: Boolean = js.native

  /** The image source that is used to create the texture.
    *
    * TODO: Make this a setter that calls loadSource();
    */
  val source: HTMLElement = js.native

  /** Controls if RGB channels should be pre-multiplied by Alpha  (WebGL only) */
  var premultipliedAlpha: Boolean = js.native

  var imageURL: String = js.native


  /** Set this to true if a mipmap of this texture needs to be generated. This value needs to be set before the texture
    * is used.
    * Also the texture must be a power of two size to work
    */
  var mipmap: Boolean = js.native

  /** Updates the texture on all the webgl renderers, this also assumes the src has changed.
    *
    * Fires `update`
    */
  def update(): Unit = js.native

  /** Destroys this base texture */
  def destroy(): Unit = js.native

  /** Frees the texture from WebGL memory without destroying this texture object.
    * This means you can still use the texture later which will upload it to GPU
    * memory again.
    */
  def dispose(): Unit = js.native

  /** Changes the source image of the texture.
    * The original source must be an Image element.
    *
    * @param newSrc the path of the image
    */
  def updateSourceImage(newSrc: String): Unit = js.native
}

object BaseTexture extends js.GlobalScope {
  /**
   * Helper function that creates a base texture from the given image url.
   * If the image is not in the base texture cache it will be created and loaded.
   *
   * @param imageUrl The image url of the texture
   * @param crossorigin Should use anonymous CORS? Defaults to true if the URL is not a data-URI.
   * @param scaleMode See { @link SCALE_MODES} for possible values
   * @return BaseTexture
   */
  @JSName("PIXI.BaseTexture.fromImage")
  def fromImage(imageUrl: String, crossorigin: Boolean, scaleMode: Int): BaseTexture = js.native

  /**
   * Helper function that creates a base texture from the given image url.
   * If the image is not in the base texture cache it will be created and loaded.
   *
   * @param imageUrl The image url of the texture
   * @return BaseTexture
   */
  @JSName("PIXI.BaseTexture.fromImage")
  def fromImage(imageUrl: String): BaseTexture = js.native

  /**
   * Helper function that creates a base texture from the given canvas element.
   *
   * @param canvas The canvas element source of the texture
   * @param scaleMode See {{#crossLink "PIXI/scaleModes:property"}}scaleModes{{/crossLink}} for possible values
   * @return BaseTexture
   */
  @JSName("PIXI.BaseTexture.fromCanvas")
  def fromCanvas(canvas: Canvas, scaleMode: Int): BaseTexture = js.native
}





