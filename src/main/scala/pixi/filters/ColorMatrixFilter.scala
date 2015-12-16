package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The ColorMatrixFilter class lets you apply a 5x4 matrix transformation on the RGBA
  * color and alpha values of every pixel on your displayObject to produce a result
  * with a new set of RGBA color and alpha values. It's pretty powerful!
  *
  * {{{
  * val colorMatrix = new ColorMatrixFilter()
  * container.filters = js.Array(colorMatrix)
  * colorMatrix.contrast(2)
  * }}}
  * @constructor
  */
@js.native
@JSName("PIXI.filters.ColorMatrixFilter")
class ColorMatrixFilter() extends Filter {
  /** Transforms current matrix and set the new one
    *
    * @param matrix (mat 5x4)
    * @param multiply if true, current matrix and matrix are multiplied. If false, just set the current matrix with @param matrix
    */
  def _loadMatrix(matrix: js.Array[Double], multiply: Boolean): Unit = js.native

  /** Multiplies two mat5's
    *
    * @param out (mat 5x4) the receiving matrix
    * @param a (mat 5x4) the first operand
    * @param b (mat 5x4) the second operand
    * @return out  (mat 5x4)
    */
  def _multiply(out: js.Array[Double], a: js.Array[Double], b: js.Array[Double]): js.Array[Double] = js.native

  /** Create a Float32 Array and normalize the offset component to 0-1
    *
    * @param matrix (mat 5x4)
    * @return m  (mat 5x4) with all values between 0-1
    */
  def _colorMatrix(matrix: js.Array[Double]): js.Array[Double] = js.native

  /** Adjusts brightness
    *
    * Multiply the current matrix
    *
    * @param b value of the brigthness (0 is black)
    * @param multiply refer to ._loadMatrix() method
    */
  def brightness(b: Double, multiply: Boolean): Unit = js.native

  /** Set the matrices in grey scales
    *
    * Multiply the current matrix
    *
    * @param scale value of the grey (0 is black)
    * @param multiply refer to ._loadMatrix() method
    */
  def greyscale(scale: Double, multiply: Boolean): Unit = js.native

  /** Set the black and white matrice
    * Multiply the current matrix
    *
    * @param multiply refer to ._loadMatrix() method
    */
  def blackAndWhite(multiply: Boolean): Unit = js.native

  /** Set the hue property of the color
    *
    * Multiply the current matrix
    *
    * @param rotation in degrees
    * @param multiply refer to ._loadMatrix() method
    */
  def hue(rotation: Double, multiply: Boolean): Unit = js.native

  /** Set the contrast matrix, increase the separation between dark and bright
    * Increase contrast : shadows darker and highlights brighter
    * Decrease contrast : bring the shadows up and the highlights down
    *
    * @param amount value of the contrast
    * @param multiply refer to ._loadMatrix() method
    */
  def contrast(amount: Double, multiply: Boolean): Unit = js.native

  /** Set the saturation matrix, increase the separation between colors
    * Increase saturation : increase contrast, brightness, and sharpness
    *
    * @param amount
    * @param multiply refer to ._loadMatrix() method
    */
  def saturate(amount: Double, multiply: Boolean): Unit = js.native

  /** Desaturate image (remove color)
    *
    * Call the saturate function
    *
    * @param multiply refer to ._loadMatrix() method
    */
  def desaturate(multiply: Boolean): Unit = js.native

  /** Negative image (inverse of classic rgb matrix)
    *
    * @param multiply refer to ._loadMatrix() method
    */
  def negative(multiply: Boolean): Unit = js.native

  /** Sepia image
    *
    * @param multiply refer to ._loadMatrix() method
    */
  def sepia(multiply: Boolean): Unit = js.native

  /** Color motion picture process invented in 1916 (thanks Dominic Szablewski)
    *
    * @param multiply refer to ._loadMatrix() method
    */
  def technicolor(multiply: Boolean): Unit = js.native

  /** Polaroid filter
    *
    * @param multiply refer to ._loadMatrix() method
    */
  def polaroid(multiply: Boolean): Unit = js.native

  /** Filter who transforms : Red -> Blue and Blue -> Red
    *
    * @param multiply refer to ._loadMatrix() method
    */
  def toBGR(multiply: Boolean): Unit = js.native

  /** Color reversal film introduced by Eastman Kodak in 1935. (thanks Dominic Szablewski)
    *
    * @param multiply refer to ._loadMatrix() method
    */
  def kodachrome(multiply: Boolean): Unit = js.native

  /** Brown delicious browni filter (thanks Dominic Szablewski)
    *
    * @param multiply refer to ._loadMatrix() method
    */
  def browni(multiply: Boolean): Unit = js.native

  /** Sets the matrix of the color matrix filter */
  var matrix: js.Array[Double] = js.native
}

