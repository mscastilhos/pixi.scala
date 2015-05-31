package pixi.core

import org.scalajs.dom.html.Image
import org.scalajs.dom.raw.HTMLCanvasElement
import pixi.core.Consts._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.typedarray.Uint8ClampedArray

/** A RenderTexture is a special texture that allows any Pixi display object to be rendered to it.
  *
  * __Hint__: All DisplayObjects (i.e. Sprites) that render to a RenderTexture should be preloaded
  * otherwise black rectangles will be drawn instead.
  *
  * A RenderTexture takes a snapshot of any Display Object given to its render method. The position
  * and rotation of the given Display Objects is ignored. For example:
  *
  * {{{js
  * var renderTexture = new PIXI.RenderTexture(800, 600);
  * var sprite = PIXI.Sprite.fromImage("spinObj_01.png");
  *
  * sprite.position.x = 800/2;
  * sprite.position.y = 600/2;
  * sprite.anchor.x = 0.5;
  * sprite.anchor.y = 0.5;
  *
  * renderTexture.render(sprite);
  * }}}
  *
  * The Sprite in this case will be rendered to a position of 0,0. To render this sprite at its actual
  * position a Container should be used:
  *
  * {{{js
  * var doc = new Container();
  *
  * doc.addChild(sprite);
  *
  * renderTexture.render(doc);  // Renders to center of renderTexture
  * }}}
  * @constructor
  * @param _renderer The renderer used for this RenderTexture
  * @param _width The width of the render texture
  * @param _height The height of the render texture
  * @param _scaleMode See { @link SCALE_MODES} for possible values
  * @param _resolution The resolution of the texture being generated
  */
@JSName("PIXI.RenderTexture")
class RenderTexture(_renderer: SystemRenderer,
                    _width: Double = 100,
                    _height: Double = 100,
                    _scaleMode: Double = SCALE_MODES.DEFAULT,
                    _resolution: Double = 1) extends Texture {

  /** The Resolution of the texture. */
  var resolution: Double = js.native

  /** Draw/render the given DisplayObject onto the texture.
    *
    * The displayObject and descendents are transformed during this operation.
    * If `updateTransform` is true then the transformations will be restored before the
    * method returns. Otherwise it is up to the calling code to correctly use or reset
    * the transformed display objects.
    *
    * The display object is always rendered with a worldAlpha value of 1.
    *
    * @param displayObject The display object to render this texture on
    * @param matrix Optional matrix to apply to the display object before rendering.
    * @param clear If true the texture will be cleared before the displayObject is drawn
    * @param updateTransform If true the displayObject's worldTransform/worldAlpha and all children
    *                        transformations will be restored. Not restoring this information will be a little faster.
    */
  def render(displayObject: DisplayObject, matrix: Matrix = null, clear: Boolean = false, updateTransform: Boolean = true): Unit = js.native

  /** The renderer this RenderTexture uses. A RenderTexture can only belong to one renderer at the moment if its webGL. */
  var renderer: SystemRenderer = js.native

  /** Resizes the RenderTexture.
    *
    * @param width The width to resize to.
    * @param height The height to resize to.
    * @param updateBase Should the baseTexture.width and height values be resized as well?
    */
  def resize(width: Double, height: Double, updateBase: Boolean): Unit = js.native

  /** Clears the RenderTexture. */
  def clear(): Unit = js.native

  /** Will return a HTML Image of the texture
    *
    * @return
    */
  def getImage(): Image = js.native

  /** Will return a a base64 encoded string of this texture. It works by calling RenderTexture.getCanvas and then
    * running toDataURL on that.
    *
    * @return A base64 encoded string of the texture.
    */
  def getBase64(): String = js.native

  /** Creates a Canvas element, renders this RenderTexture to it and then returns it.
    *
    * @return A Canvas element with the texture rendered on.
    */
  def getCanvas(): HTMLCanvasElement = js.native

  /** Will return a one-dimensional array containing the pixel data of the entire texture in RGBA order, with integer
    * values between 0 and 255 (included).
    *
    * @return
    */
  def getPixels(): Uint8ClampedArray = js.native

  /** Will return a one-dimensional array containing the pixel data of a pixel within the texture in RGBA order, with
    * integer values between 0 and 255 (included).
    *
    * @param x The x coordinate of the pixel to retrieve.
    * @param y The y coordinate of the pixel to retrieve.
    * @return
    */
  def getPixel(x: Double, y: Double): Uint8ClampedArray = js.native
}
