package pixi.core

import org.scalajs.dom.raw.HTMLCanvasElement

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, `|`}
import scala.scalajs.js.annotation.{ScalaJSDefined, JSName}

/** A Text Object will create a line or multiple lines of text. To split a line you can use '\n' in your text string,
  * or add a wordWrap property set to true and and wordWrapWidth property with a value in the style object.
  *
  * A Text can be created directly from a string and a style object
  *
  * ```js
  * var text = new PIXI.Text('This is a pixi text',{font : '24px Arial', fill : 0xff1010, align : 'center'});
  * ```
  */
@js.native
@JSName("PIXI.Text")
class Text protected[pixi]() extends Sprite() {
  /**
   * @param text The copy that you would like the text to display
   * @param style The style parameters
   */
  def this(text: String, style: UndefOr[Text.Style] = js.undefined) = this()

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

  /** Custom style for text */
  @ScalaJSDefined
  class Style extends js.Object {
    /** default 'bold 20px Arial' The style and size of the font */
    var font: UndefOr[String] = js.undefined

    /** A canvas fillstyle that will be used on the text e.g 'red', '#00FF00' */
    var fill: String | Int | Double = "black"

    /** Alignment for multiline text ('left', 'center' or 'right'), does not affect single line text */
    var align: UndefOr[String] = js.undefined

    /** A canvas fillstyle that will be used on the text stroke e.g 'blue', '#FCFF00' */
    var stroke: String | Int | Double = "black"

    /** A number that represents the thickness of the stroke. Default is 0 (no stroke) */
    var strokeThickness: UndefOr[Double] = js.undefined

    /** Indicates if word wrap should be used */
    var wordWrap: UndefOr[Boolean] = js.undefined

    /** The width at which text will wrap, it needs wordWrap to be set to true */
    var wordWrapWidth: UndefOr[Double] = js.undefined

    /** The line height, a number that represents the vertical space that a letter uses */
    var lineHeight: UndefOr[Double] = js.undefined

    /** Set a drop shadow for the text */
    var dropShadow: UndefOr[Boolean] = js.undefined

    /** A fill style to be used on the dropshadow e.g 'red', '#00FF00' */
    var dropShadowColor: UndefOr[String] = js.undefined

    /** Set a angle of the drop shadow */
    var dropShadowAngle: UndefOr[Double] = js.undefined

    /** Set a distance of the drop shadow */
    var dropShadowDistance: UndefOr[Double] = js.undefined

    /** Occasionally some fonts are cropped on top or bottom. Adding some padding will prevent this from
      * happening by adding padding to the top and bottom of text height.
      */
    var padding: UndefOr[Double] = js.undefined

    /** The baseline of the text that is rendered. */
    var textBaseline: UndefOr[String] = js.undefined

    /** The lineJoin property sets the type of corner created, it can resolve spiked text issues. Default
      * is 'miter' (creates a sharp corner).
      */
    var lineJoin: UndefOr[String] = js.undefined

    /** The miter limit to use when using the 'miter' lineJoin mode. This can reduce or increase the
      * spikiness of rendered text.
      */
    var miterLimit: UndefOr[Double] = js.undefined
  }

}
