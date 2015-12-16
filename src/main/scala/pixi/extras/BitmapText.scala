package pixi.extras

import pixi.core.Container

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{ScalaJSDefined, JSName}

/** A BitmapText object will create a line or multiple lines of text using bitmap font. To
  * split a line you can use '\n', '\r' or '\r\n' in your string. You can generate the fnt files using:
  *
  * A BitmapText can only be created when the font is loaded
  *
  * {{{
  * // in this case the font is in a file called 'desyrel.fnt'
  * val bitmapText = new BitmapText("text using a fancy font!", Style(font = "35px Desyrel", align = "right"))
  * }}}
  *
  *
  * http://www.angelcode.com/products/bmfont/ for windows or
  * http://www.bmglyph.com/ for mac.
  * @constructor
  * @param _text The copy that you would like the text to display
  * @param _style The style parameters
  */
@js.native
@JSName("PIXI.extras.BitmapText")
class BitmapText(_text: String, _style: js.Object) extends Container {
  /** The width of the overall text, different from fontSize, which is defined in the style object */
  val textWidth: Double = js.native

  /** The height of the overall text, different from fontSize, which is defined in the style object */
  val textHeight: Double = js.native

  /** The max width of this bitmap text in pixels. If the text provided is longer than the value provided, line breaks
    * will be automatically inserted in the last whitespace.
    *
    * Disable by setting value to 0 */
  var maxWidth: Double = js.native

  /** The dirty state of this object. */
  var dirty: Boolean = js.native

  /** The tint of the BitmapText object */
  var tint: Int = js.native

  /** The alignment of the BitmapText object */
  var align: String = js.native

  /** The font descriptor of the BitmapText object */
  var font: String = js.native

  /** The text of the BitmapText object */
  var text: String = js.native
}

object BitmapText {

  /** Base trait for font styles
    *
    * @param font The font descriptor for the object, can be passed as a string of form "24px FontName" or "FontName"
    *             or as an object with explicit name/size properties.
    */
  @ScalaJSDefined
  class Style(var font: String | FontDef) extends js.Object {
    /** Alignment for multiline text ('left', 'center' or 'right'), does not affect single line text */
    var align: String = "left"

    /** The tint color */
    var tint: Int = 0xFFFFFF
  }

  /**
   * Font properties
   * @param name The bitmap font id
   * @param size The size of the font in pixels, e.g. 24
   */
  @ScalaJSDefined
  class FontDef(name: String, size: Int) extends js.Object {}

}

