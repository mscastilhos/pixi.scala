package pixi.core

import org.scalajs.dom.raw.HTMLCanvasElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A Text Object will create a line or multiple lines of text. To split a line you can use '\n' in your text string,
  * or add a wordWrap property set to true and and wordWrapWidth property with a value in the style object.
  *
  * A Text can be created directly from a string and a style object
  *
  * ```js
  * var text = new PIXI.Text('This is a pixi text',{font : '24px Arial', fill : 0xff1010, align : 'center'});
  * ```
  * @constructor
  * @param _text The copy that you would like the text to display
  * @param _style The style parameters
  */
@JSName("PIXI.Text")
class Text(_text: String,
           _style: Text.Style = Text.DEFAULT) extends Sprite(null) {
  /** The canvas element that everything is drawn to */
  var canvas: HTMLCanvasElement = js.native

  /** The canvas 2d context that everything is drawn with */
  var context: HTMLCanvasElement = js.native

  /** The resolution of the canvas. */
  var resolution: Double = js.native

  /** Set the style of the text */
  var style: Text.Style = js.native

  /** Sets the text */
  var text: String = js.native
}

object Text {

  trait Style extends js.Object


  /** Creates a custom style for text
    *
    * @param font default 'bold 20px Arial' The style and size of the font
    * @param fill A canvas fillstyle that will be used on the text e.g 'red', '#00FF00'
    * @param align Alignment for multiline text ('left', 'center' or 'right'), does not affect single line text
    * @param stroke A canvas fillstyle that will be used on the text stroke e.g 'blue', '#FCFF00'
    * @param strokeThickness A number that represents the thickness of the stroke. Default is 0 (no stroke)
    * @param wordWrap Indicates if word wrap should be used
    * @param wordWrapWidth The width at which text will wrap, it needs wordWrap to be set to true
    * @param lineHeight The line height, a number that represents the vertical space that a letter uses
    * @param dropShadow Set a drop shadow for the text
    * @param dropShadowColor A fill style to be used on the dropshadow e.g 'red', '#00FF00'
    * @param dropShadowAngle Set a angle of the drop shadow
    * @param dropShadowDistance Set a distance of the drop shadow
    * @param padding Occasionally some fonts are cropped on top or bottom. Adding some padding will prevent this from
    *                happening by adding padding to the top and bottom of text height.
    * @param textBaseline The baseline of the text that is rendered.
    * @param lineJoin The lineJoin property sets the type of corner created, it can resolve spiked text issues. Default
    *                 is 'miter' (creates a sharp corner).
    * @param miterLimit The miter limit to use when using the 'miter' lineJoin mode. This can reduce or increase the
    *                   spikiness of rendered text.
    */
  def style(font: String = "bold 20px Arial",
            fill: String = "black",
            align: String = "left",
            stroke: String = null,
            strokeThickness: Double = 0,
            wordWrap: Boolean = false,
            wordWrapWidth: Double = 100,
            lineHeight: Double = Double.NaN,
            dropShadow: Boolean = false,
            dropShadowColor: String = "#000000",
            dropShadowAngle: Double = Math.PI / 4,
            dropShadowDistance: Double = 5,
            padding: Double = 0,
            textBaseline: String = "alphabetic",
            lineJoin: String = "miter",
            miterLimit: Double = 10): Style = {
    val st = js.Dynamic.literal(
      font = font,
      fill = fill,
      align = align,
      strokeThickness = strokeThickness,
      wordWrap = wordWrap,
      wordWrapWidth = wordWrapWidth,
      dropShadow = dropShadow,
      dropShadowColor = dropShadowColor,
      dropShadowAngle = dropShadowAngle,
      dropShadowDistance = dropShadowDistance,
      padding = padding,
      textBaseline = textBaseline,
      lineJoin = lineJoin,
      miterLimit = miterLimit
    )
    if (stroke != null)
      st.stroke = stroke
    if (!lineHeight.isNaN)
      st.lineHeight = lineHeight

    st.asInstanceOf[Style]
  }

  /** Default style */
  def DEFAULT = style()
}
