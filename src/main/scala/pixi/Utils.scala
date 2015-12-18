package pixi

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("PIXI.utils")
@js.native
object Utils extends js.Object {
  /** Gets the next unique identifier
    *
    * @return {number} The next unique identifier to use.
    */
  def uuid(): Int = js.native

  /** Converts a hex color number to an [R, G, B] array
    *
    * @param hex
    * @return An array representing the [R, G, B] of the color.
    */
  def hex2rgb(hex: Int): js.Array[Int] = js.native

  /** Converts a hex color number to a string.
    *
    * @param hex
    * @return The string color.
    */
  def hex2string(hex: Int): String = js.native

  /** Converts a color as an [R, G, B] array to a hex number
    *
    * @param rgb
    * @return The color number
    */
  def rgb2hex(rgb: js.Array[Int]): Int = js.native

  /** Checks whether the Canvas BlendModes are supported by the current browser
    *
    * @return whether they are supported
    */
  def canUseNewCanvasBlendModes(): Boolean = js.native

  /** Given a number, this function returns the closest number that is a power of two
    * this function is taken from Starling Framework as its pretty neat ;)
    *
    * @param number
    * @return the closest number that is a power of two
    */
  def getNextPowerOfTwo(number: Int): Int = js.native

  /** checks if the given width and height make a power of two rectangle
    *
    * @param width
    * @param height
    * @return
    */
  def isPowerOfTwo(width: Int, height: Int): Boolean = js.native

  /** get the resolution of an asset by looking for the prefix
    * used by spritesheets and image urls
    *
    * @param url the image path
    * @return
    */
  def getResolutionOfUrl(url: String): Boolean = js.native

  /**
    * Logs out the version and renderer information for this running instance of PIXI.
    * If you don't want to see this message you can set `PIXI.utils._saidHello = true;`
    * so the library thinks it already said it. Keep in mind that doing that will forever
    * makes you a jerk face.
    *
    * @param typ The string renderer type to log.
    */
  def sayHello(typ: String): Unit = js.native

  /** For jerk faces who want to disable [[sayHello()]] */
  var _saidHello: Boolean = js.native

  /** Helper for checking for webgl support
    *
    * @return
    */
  def isWebGLSupported(): Boolean = js.native

  /** Returns sign of number
    *
    * @param n
    * @returns 0 if n is 0, -1 if n is negative, 1 if n i positive
    */
  def sign(n: Double): Int = js.native
}
