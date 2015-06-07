package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** A Container represents a collection of display objects.
  * It is the base class of all display objects that act as a container for other objects.
  *
  * {{{
  * val container = new Container();
  * container.addChild(sprite);
  * }}}
  * @constructor
  */
@JSName("PIXI.Container")
class Container() extends DisplayObject {
  /** The array of children of this container. */
  val children: js.Array[DisplayObject] = js.native

  /** The width of the Container, setting this will actually modify the scale to achieve the value set */
  var width: Double = js.native

  /** The height of the Container, setting this will actually modify the scale to achieve the value set */
  var height: Double = js.native

  /** Adds a child to the container.
    *
    * @param child The DisplayObject to add to the container
    * @return The child that was added.
    */
  def addChild(child: DisplayObject): DisplayObject = js.native

  /** Adds a child to the container at a specified index. If the index is out of bounds an error will be thrown
    *
    * @param child The child to add
    * @param index The index to place the child in
    * @return The child that was added.
    */
  def addChildAt(child: DisplayObject, index: Int): DisplayObject = js.native

  /** Swaps the position of 2 Display Objects within this container.
    *
    * @param child
    * @param child2
    */
  def swapChildren(child: DisplayObject, child2: DisplayObject): Unit = js.native

  /** Returns the index position of a child DisplayObject instance
    *
    * @param child The DisplayObject instance to identify
    * @return The index position of the child display object to identify
    */
  def getChildIndex(child: DisplayObject): Int = js.native

  /** Changes the position of an existing child in the display object container
    *
    * @param child The child DisplayObject instance for which you want to change the index number
    * @param index The resulting index number for the child display object
    */
  def setChildIndex(child: DisplayObject, index: Int): Unit = js.native

  /** Returns the child at the specified index
    *
    * @param index The index to get the child at
    * @return The child at the given index, if any.
    */
  def getChildAt(index: Int): DisplayObject = js.native

  /** Removes a child from the container.
    *
    * @param child The DisplayObject to remove
    * @return The child that was removed.
    */
  def removeChild(child: DisplayObject): DisplayObject = js.native

  /** Removes a child from the specified index position.
    *
    * @param index The index to get the child from
    * @return The child that was removed.
    */
  def removeChildAt(index: Int): DisplayObject = js.native

  /** Removes all children from this container that are within the begin and end indexes.
    *
    * @param beginIndex The beginning position. Default value is 0.
    * @param endIndex The ending position. Default value is size of the container.
    */
  def removeChildren(beginIndex: Int, endIndex: Int): Unit = js.native

  /** Returns the display object in the container
    *
    * @param name instance name
    * @return The child with that name
    */
  def getChildByName(name: String): DisplayObject = js.native

  /** Retrieves the bounds of the Container as a rectangle. The bounds calculation takes all visible children into
    * consideration.
    *
    * @return The rectangular bounding area
    */
  def getBounds(): Rectangle = js.native

  /** Retrieves the non-global local bounds of the Container as a rectangle.
    * The calculation takes all visible children into consideration.
    *
    * @return The rectangular bounding area
    */
  override def getLocalBounds(): Rectangle = js.native

  /** Destroys the container
    *
    * @param destroyChildren if set to true, all the children will have their destroy method called as well
    */
  def destroy(destroyChildren: Boolean = false): Unit = js.native
}
