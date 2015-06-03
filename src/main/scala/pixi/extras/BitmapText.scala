package pixi.extras

import pixi.core.{Rectangle, Container}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportAll, JSName}

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

  /** Base trait for font styles */
  trait Style extends js.Object

  object Style {
    /** Creates a font style
      *
      * @param font The font descriptor for the object, passed as a string of form "24px FontName" or "FontName"
      * @param align Alignment for multiline text ('left', 'center' or 'right'), does not affect single line text
      * @param tint The tint color
      * @return A font style with these parameters
      */
    def apply(font: String,
              align: String = "left",
              tint: Int = 0xFFFFFF): Style = {
      js.Dynamic.literal(font = font, align = align, tint = tint).asInstanceOf[Style]
    }
  }

}
