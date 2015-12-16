package pixi.core.canvas.utils

import org.scalajs.dom.raw.HTMLCanvasElement
import pixi.core.{Texture, Sprite}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** Utility methods for Sprite/Texture tinting.
  * @constructor
  */
@js.native
@JSName("PIXI.CanvasTinter")
object CanvasTinter extends js.GlobalScope {
  /** Basically this method just needs a sprite and a color and tints the sprite with the given color.
    *
    * @param sprite the sprite to tint
    * @param color the color to use to tint the sprite with
    * @return The tinted canvas
    */
  @JSName("PIXI.CanvasTinter.getTintedTexture")
  def getTintedTexture(sprite: Sprite, color: Double): HTMLCanvasElement = js.native

  /** Tint a texture using the 'multiply' operation.
    *
    * @param texture the texture to tint
    * @param color the color to use to tint the sprite with
    * @param canvas the current canvas
    */
  @JSName("PIXI.CanvasTinter.tintWithMultiply")
  def tintWithMultiply(texture: Texture, color: Double, canvas: HTMLCanvasElement): Unit = js.native

  /** Tint a texture using the 'overlay' operation.
    *
    * @param texture the texture to tint
    * @param color the color to use to tint the sprite with
    * @param canvas the current canvas
    */
  @JSName("PIXI.CanvasTinter.tintWithOverlay")
  def tintWithOverlay(texture: Texture, color: Double, canvas: HTMLCanvasElement): Unit = js.native

  /** Tint a texture pixel per pixel.
    *
    * @param texture the texture to tint
    * @param color the color to use to tint the sprite with
    * @param canvas the current canvas
    */
  @JSName("PIXI.CanvasTinter.tintWithPerPixel")
  def tintWithPerPixel(texture: Texture, color: Double, canvas: HTMLCanvasElement): Unit = js.native

  /** Rounds the specified color according to the CanvasTinter.cacheStepsPerColorChannel.
    *
    * @param color the color to round, should be a hex color
    */
  @JSName("PIXI.CanvasTinter.roundColor")
  def roundColor(color: Double): Unit = js.native

  /** Number of steps which will be used as a cap when rounding colors. */
  @JSName("PIXI.CanvasTinter.cacheStepsPerColorChannel")
  var cacheStepsPerColorChannel: Int = js.native

  /** Tint cache boolean flag. */
  @JSName("PIXI.CanvasTinter.convertTintToImage")
  var convertTintToImage: Boolean = js.native

  /** Whether or not the Canvas BlendModes are supported, consequently the ability to tint using the multiply method. */
  @JSName("PIXI.CanvasTinter.canUseMultiply")
  var canUseMultiply: Boolean = js.native

  /** The tinting method that will be used.
    *
    * @param texture the texture to tint
    * @param color the color to use to tint the sprite with
    * @param canvas the current canvas
    */
  @JSName("PIXI.CanvasTinter.tintMethod")
  def tintMethod(texture: Texture, color: Double, canvas: HTMLCanvasElement): Unit = js.native
}