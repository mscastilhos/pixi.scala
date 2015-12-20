package pixi.core.canvas.utils

import org.scalajs.dom.raw.HTMLCanvasElement
import pixi.core.{Sprite, Texture}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** Utility methods for Sprite/Texture tinting. */
@js.native
@JSName("PIXI.CanvasTinter")
object CanvasTinter extends js.Object {
  /** Basically this method just needs a sprite and a color and tints the sprite with the given color.
    *
    * @param sprite the sprite to tint
    * @param color the color to use to tint the sprite with
    * @return The tinted canvas
    */
  def getTintedTexture(sprite: Sprite, color: Double): HTMLCanvasElement = js.native

  /** Tint a texture using the 'multiply' operation.
    *
    * @param texture the texture to tint
    * @param color the color to use to tint the sprite with
    * @param canvas the current canvas
    */
  def tintWithMultiply(texture: Texture, color: Double, canvas: HTMLCanvasElement): Unit = js.native

  /** Tint a texture using the 'overlay' operation.
    *
    * @param texture the texture to tint
    * @param color the color to use to tint the sprite with
    * @param canvas the current canvas
    */
  def tintWithOverlay(texture: Texture, color: Double, canvas: HTMLCanvasElement): Unit = js.native

  /** Tint a texture pixel per pixel.
    *
    * @param texture the texture to tint
    * @param color the color to use to tint the sprite with
    * @param canvas the current canvas
    */
  def tintWithPerPixel(texture: Texture, color: Double, canvas: HTMLCanvasElement): Unit = js.native

  /** Rounds the specified color according to the CanvasTinter.cacheStepsPerColorChannel.
    *
    * @param color the color to round, should be a hex color
    */
  def roundColor(color: Double): Unit = js.native

  /** Number of steps which will be used as a cap when rounding colors. */
  var cacheStepsPerColorChannel: Int = js.native

  /** Tint cache boolean flag. */
  var convertTintToImage: Boolean = js.native

  /** Whether or not the Canvas BlendModes are supported, consequently the ability to tint using the multiply method. */
  var canUseMultiply: Boolean = js.native

  /** The tinting method that will be used.
    *
    * @param texture the texture to tint
    * @param color the color to use to tint the sprite with
    * @param canvas the current canvas
    */
  def tintMethod(texture: Texture, color: Double, canvas: HTMLCanvasElement): Unit = js.native
}