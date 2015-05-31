package pixi

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

object Utils extends js.GlobalScope {
  /** Gets the next uuid
    *
    * @return The next uuid to use.
    */
  @JSName("PIXI.utils.uuid")
  def uuid(): Int = js.native

  /** Converts a hex color number to an [R, G, B] array
    *
    * @param hex
    * @return An array representing the [R, G, B] of the color.
    */
  @JSName("PIXI.utils.hex2rgb")
  def hex2rgb(hex: Int): js.Array[Int] = js.native

  /** Converts a hex color number to a string.
    *
    * @param hex
    * @return The string color.
    */
  @JSName("PIXI.utils.hex2string")
  def hex2string(hex: Int): String = js.native

  /** Converts a color as an [R, G, B] array to a hex number
    *
    * @param rgb
    * @return The color number
    */
  @JSName("PIXI.utils.rgb2hex")
  def rgb2hex(rgb: js.Array[Int]): Int = js.native

  /** Checks whether the Canvas BlendModes are supported by the current browser
    *
    * @return whether they are supported
    */
  @JSName("PIXI.utils.canUseNewCanvasBlendModes")
  def canUseNewCanvasBlendModes(): Boolean = js.native

  /** Given a number, this function returns the closest number that is a power of two
    * this function is taken from Starling Framework as its pretty neat ;)
    *
    * @param number
    * @return the closest number that is a power of two
    */
  @JSName("PIXI.utils.getNextPowerOfTwo")
  def getNextPowerOfTwo(number: Int): Int = js.native

  /** checks if the given width and height make a power of two rectangle
    *
    * @param width
    * @param height
    * @return
    */
  @JSName("PIXI.utils.isPowerOfTwo")
  def isPowerOfTwo(width: Int, height: Int): Boolean = js.native

  /** get the resolution of an asset by looking for the prefix
    * used by spritesheets and image urls
    *
    * @param url the image path
    * @return
    */
  @JSName("PIXI.utils.getResolutionOfUrl")
  def getResolutionOfUrl(url: String): Boolean = js.native

  /**
   * Logs out the version and renderer information for this running instance of PIXI.
   * If you don't want to see this message you can set `PIXI.utils._saidHello = true;`
   * so the library thinks it already said it. Keep in mind that doing that will forever
   * makes you a jerk face.
   *
   * @param typ The string renderer type to log.
   */
  @JSName("PIXI.utils.sayHello")
  def sayHello(typ: String): Unit = js.native

  /** Helper for checking for webgl support
    *
    * @return
    */
  @JSName("PIXI.utils.isWebGLSupported")
  def isWebGLSupported(): Boolean = js.native
}
