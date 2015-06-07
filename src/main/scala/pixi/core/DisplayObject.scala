package pixi.core

import pixi.core.canvas.CanvasRenderer
import pixi.core.webgl.WebGLRenderer
import pixi.core.webgl.filters.Filter
import pixi.eventemitter3.EventEmitter
import pixi.interaction.InteractiveTarget

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

// TODO: EventEmitter stuff

/** The base class for all objects that are rendered on the screen.
  * This is an abstract class and should not be used on its own rather it should be extended.
  * @constructor
  */
@JSName("PIXI.DisplayObject")
class DisplayObject() extends EventEmitter with InteractiveTarget {
  /** The coordinate of the object relative to the local coordinates of the parent. */
  var position: Point = js.native

  /** The scale factor of the object. */
  var scale: Point = js.native

  /** The pivot point of the displayObject that it rotates around */
  var pivot: Point = js.native

  /** The rotation of the object in radians. */
  var rotation: Double = js.native

  /** The opacity of the object. */
  var alpha: Double = js.native

  /** The visibility of the object. If false the object will not be drawn, and the updateTransform function will not be
    * called.
    */
  var visible: Boolean = js.native

  /** Can this object be rendered, if false the object will not be drawn but the updateTransform methods will
    * still be called.
    */
  var renderable: Boolean = js.native

  /** The display object container that contains this display object. */
  val parent: Container = js.native

  /** The multiplied alpha of the displayObject */
  val worldAlpha: Double = js.native

  /** Current transform of the object based on world (parent) factors */
  val worldTransform: Matrix = js.native

  /** The area the filter is applied to. This is used as more of an optimisation rather than figuring out the
    * dimensions of the displayObject each frame you can set this rectangle
    */
  var filterArea: Rectangle = js.native

  /** The position of the displayObject on the x axis relative to the local coordinates of the parent. */
  var x: Double = js.native

  /** The position of the displayObject on the y axis relative to the local coordinates of the parent. */
  var y: Double = js.native

  /** Indicates if the sprite is globally visible. */
  val worldVisible: Boolean = js.native

  /** Sets a mask for the displayObject. A mask is an object that limits the visibility of an object to the shape of
    * the mask applied to it.
    * In PIXI a regular mask must be a PIXI.Graphics object. This allows for much faster masking in canvas as it
    * utilises shape clipping.
    * To remove a mask, set this property to null.
    */
  var mask: DisplayObject = js.native

  /** Sets the filters for the displayObject.
    * IMPORTANT: This is a webGL only feature and will be ignored by the canvas renderer.
    * To remove filters simply set this property to 'null'
    */
  var filters: js.Array[Filter] = js.native

  /** Set this to true if you want this display object to be cached as a bitmap.
    *
    * This basically takes a snap shot of the display object as it is at that moment. It can provide a performance
    * benefit for complex static displayObjects.
    *
    * To remove simply set this property to 'null'
    */
  var cacheAsBitmap: Boolean = js.native

  /** Retrieves the bounds of the displayObject as a rectangle object
    *
    * @param matrix
    * @return the rectangular bounding area
    */
  def getBounds(matrix: Matrix): Rectangle = js.native

  /** Retrieves the local bounds of the displayObject as a rectangle object
    *
    * @return the rectangular bounding area
    */
  def getLocalBounds(): Rectangle = js.native

  /** Calculates the global position of the display object
    *
    * @param position The world origin to calculate from
    * @return A point object representing the position of this object
    */
  def toGlobal(position: Point): Point = js.native

  /** Calculates the local position of the display object relative to another point
    *
    * @param position The world origin to calculate from
    * @return A point object representing the position of this object
    */
  def toLocal(position: Point): Point = js.native

  /** Calculates the local position of the display object relative to another point
    *
    * @param position The world origin to calculate from
    * @param from The DisplayObject to calculate the global position from
    * @return A point object representing the position of this object
    */
  def toLocal(position: Point, from: DisplayObject): Point = js.native

  /** Renders the object using the WebGL renderer
    *
    * @param renderer The renderer
    */
  def renderWebGL(renderer: WebGLRenderer): Unit = js.native

  /** Renders the object using the Canvas renderer
    *
    * @param renderer The renderer
    */
  def renderCanvas(renderer: CanvasRenderer): Unit = js.native

  /** Useful function that returns a texture of the display object that can then be used to create sprites
    * This can be quite useful if your displayObject is static / complicated and needs to be reused multiple times.
    *
    * @param renderer The renderer used to generate the texture.
    * @param resolution The resolution of the texture being generated
    * @param scaleMode See { @link SCALE_MODES}
  for possible values
    * @return a texture of the display object
    */
  def generateTexture(renderer: Renderer, resolution: Double, scaleMode: Double): Texture = js.native

  /** Base destroy method for generic display objects */
  def destroy(): Unit = js.native


  /** Returns the global position of the displayObject
    *
    * @param point the point to write the global value to. If null a new point will be returned
    * @return the global position of the displayObject
    */
  def getGlobalPosition(point: Point = null): Point = js.native
}