package pixi.filters

import pixi.core.webgl.filters.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The ConvolutionFilter class applies a matrix convolution filter effect.
  * A convolution combines pixels in the input image with neighboring pixels to produce a new image.
  * A wide variety of image effects can be achieved through convolutions, including blurring, edge
  * detection, sharpening, embossing, and beveling. The matrix should be specified as a 9 point Array.
  * See http://docs.gimp.org/en/plug-in-convmatrix.html for more info.
  * @constructor
  * @param _matrix An array of values used for matrix transformation. Specified as a 9 point Array.
  * @param _width Width of the object you are transforming
  * @param _height Height of the object you are transforming
  */
@js.native
@JSName("PIXI.filters.ConvolutionFilter")
class ConvolutionFilter(_matrix: js.Array[Double], _width: Double, _height: Double) extends Filter {
  /** An array of values used for matrix transformation. Specified as a 9 point Array. */
  var matrix: js.Array[Double] = js.native

  /** Width of the object you are transforming */
  var width: Double = js.native

  /** Height of the object you are transforming */
  var height: Double = js.native
}
