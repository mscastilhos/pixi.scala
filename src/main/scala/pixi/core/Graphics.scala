package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The Graphics class contains methods used to draw primitive shapes such as lines, circles and
  * rectangles to the display, and to color and fill them.
  * @constructor
  */
@JSName("PIXI.Graphics")
class Graphics() extends Container {
  /** The alpha value used when filling the Graphics object. */
  var fillAlpha: Double = js.native

  /** The width (thickness) of any lines drawn. */
  var lineWidth: Double = js.native

  /** The color of any lines drawn. */
  var lineColor: Int = js.native

  /** The tint applied to the graphic shape. This is a hex value. Apply a value of 0xFFFFFF to reset the tint. */
  var tint: Double = js.native

  /** The blend mode to be applied to the graphic shape. Apply a value of blendModes.NORMAL to reset the blend mode. */
  var blendMode: Int = js.native

  /** Current path */
  var currentPath: GraphicsData = js.native

  /** Whether this shape is being used as a mask. */
  var isMask: Boolean = js.native

  /** The bounds' padding used for bounds calculation. */
  var boundsPadding: Double = js.native

  /** Creates a new Graphics object with the same values as this one.
    * Note that the only the properties of the object are cloned, not its transform (position,scale,etc)
    *
    * @return
    */
  override def clone(): Graphics = js.native

  /** Specifies the line style used for subsequent calls to Graphics methods such as the lineTo() method or the drawCircle() method.
    *
    * @param lineWidth width of the line to draw, will update the objects stored style
    * @param color color of the line to draw, will update the objects stored style
    * @param alpha alpha of the line to draw, will update the objects stored style
    * @return
    */
  def lineStyle(lineWidth: Double = 0, color: Int = 0, alpha: Double = 1): Graphics = js.native

  /** Moves the current drawing position to x, y.
    *
    * @param x the X coordinate to move to
    * @param y the Y coordinate to move to
    * @return
    */
  def moveTo(x: Double, y: Double): Graphics = js.native

  /** Draws a line using the current line style from the current drawing position to (x, y);
    * The current drawing position is then set to (x, y).
    *
    * @param x the X coordinate to draw to
    * @param y the Y coordinate to draw to
    * @return
    */
  def lineTo(x: Double, y: Double): Graphics = js.native

  /** Calculate the points for a quadratic bezier curve and then draws it.
    * Based on: https://stackoverflow.com/questions/785097/how-do-i-implement-a-bezier-curve-in-c
    *
    * @param cpX Control point x
    * @param cpY Control point y
    * @param toX Destination point x
    * @param toY Destination point y
    * @return
    */
  def quadraticCurveTo(cpX: Double, cpY: Double, toX: Double, toY: Double): Graphics = js.native

  /** Calculate the points for a bezier curve and then draws it.
    *
    * @param cpX Control point x
    * @param cpY Control point y
    * @param cpX2 Second Control point x
    * @param cpY2 Second Control point y
    * @param toX Destination point x
    * @param toY Destination point y
    * @return
    */
  def bezierCurveTo(cpX: Double, cpY: Double, cpX2: Double, cpY2: Double, toX: Double, toY: Double): Graphics = js.native

  /** The arcTo() method creates an arc/curve between two tangents on the canvas.
    *
    * "borrowed" from https://code.google.com/p/fxcanvas/ - thanks google!
    *
    * @param x1 The x-coordinate of the beginning of the arc
    * @param y1 The y-coordinate of the beginning of the arc
    * @param x2 The x-coordinate of the end of the arc
    * @param y2 The y-coordinate of the end of the arc
    * @param radius The radius of the arc
    * @return
    */
  def arcTo(x1: Double, y1: Double, x2: Double, y2: Double, radius: Double): Graphics = js.native

  /** The arc method creates an arc/curve (used to create circles, or parts of circles).
    *
    * @param cx The x-coordinate of the center of the circle
    * @param cy The y-coordinate of the center of the circle
    * @param radius The radius of the circle
    * @param startAngle The starting angle, in radians (0 is at the 3 o'clock position of the arc's circle)
    * @param endAngle The ending angle, in radians
    * @param anticlockwise Optional. Specifies whether the drawing should be counterclockwise or clockwise. False is
    *                      default, and indicates clockwise, while true indicates counter-clockwise.
    * @return
    */
  def arc(cx: Double,
          cy: Double,
          radius: Double,
          startAngle: Double,
          endAngle: Double,
          anticlockwise: Boolean = false): Graphics = js.native

  /** Specifies a simple one-color fill that subsequent calls to other Graphics methods
    * (such as lineTo() or drawCircle()) use when drawing.
    *
    * @param color the color of the fill
    * @param alpha the alpha of the fill
    * @return
    */
  def beginFill(color: Int = 0, alpha: Double = 1): Graphics = js.native

  /** Applies a fill to the lines and shapes that were added since the last call to the beginFill() method.
    *
    * @return
    */
  def endFill(): Graphics = js.native

  /**
   *
   * @param x The X coord of the top-left of the rectangle
   * @param y The Y coord of the top-left of the rectangle
   * @param width The width of the rectangle
   * @param height The height of the rectangle
   * @return
   */
  def drawRect(x: Double, y: Double, width: Double, height: Double): Graphics = js.native

  /**
   *
   * @param x The X coord of the top-left of the rectangle
   * @param y The Y coord of the top-left of the rectangle
   * @param width The width of the rectangle
   * @param height The height of the rectangle
   * @param radius Radius of the rectangle corners
   */
  def drawRoundedRect(x: Double, y: Double, width: Double, height: Double, radius: Double): Unit = js.native

  /** Draws a circle.
    *
    * @param x The X coordinate of the center of the circle
    * @param y The Y coordinate of the center of the circle
    * @param radius The radius of the circle
    * @return
    */
  def drawCircle(x: Double, y: Double, radius: Double): Graphics = js.native

  /** Draws an ellipse.
    *
    * @param x The X coordinate of the center of the ellipse
    * @param y The Y coordinate of the center of the ellipse
    * @param width The half width of the ellipse
    * @param height The half height of the ellipse
    * @return
    */
  def drawEllipse(x: Double, y: Double, width: Double, height: Double): Graphics = js.native

  /** Draws a polygon using the given path.
    *
    * @param path The path data used to construct the polygon.
    * @return
    */
  def drawPolygon(path: js.Object*): Graphics = js.native

  /** Clears the graphics that were drawn to this Graphics object, and resets fill and line style settings.
    *
    * @return
    */
  def clear(): Graphics = js.native

  /** Useful function that returns a texture of the graphics object that can then be used to create sprites
    * This can be quite useful if your geometry is complicated and needs to be reused multiple times.
    *
    * @param resolution The resolution of the texture being generated
    * @param scaleMode Should be one of the scaleMode consts
    * @return a texture of the graphics object
    */
  def generateTexture(resolution: Double, scaleMode: Double): Texture = js.native

  /** Retrieves the bounds of the graphic shape as a rectangle object
    *
    * @return the rectangular bounding area
    */
  override def getBounds(): Rectangle = js.native

  /** Tests if a point is inside this graphics object
    *
    * @param point the point to test
    * @return the result of the test
    */
  def containsPoint(point: Point): Boolean = js.native

  /** Update the bounds of the object */
  def updateLocalBounds(): Unit = js.native

  /** Draws the given shape to this Graphics object. Can be any of Circle, Rectangle, Ellipse, Line or Polygon.
    *
    * @param shape The shape object to draw.
    * @return The generated GraphicsData object.
    */
  def drawShape(shape: Shape): GraphicsData = js.native

}
