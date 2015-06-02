package pixi.interaction

import org.scalajs.dom.Event
import pixi.core.{DisplayObject, Sprite, Point}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** Holds all information related to an Interaction event */
@JSName("PIXI.interaction.InteractionData")
trait InteractionData extends js.Object {
  /** This point stores the global coords of where the touch/mouse event happened */
  var global: Point = js.native

  /** The target Sprite that was interacted with */
  var target: Sprite = js.native

  /** When passed to an event handler, this will be the original DOM Event that was captured */
  var originalEvent: Event = js.native

  /** This will return the local coordinates of the specified displayObject for this InteractionData
    *
    * @param displayObject The DisplayObject that you would like the local coords off
    * @param point A Point object in which to store the value, optional (otherwise will create a new point)
    * @param globalPos A Point object containing your custom global coords, optional (otherwise will use the
    *                  current global coords)
    * @return A point containing the coordinates of the InteractionData position relative to the DisplayObject
    */
  def getLocalPosition(displayObject: DisplayObject, point: Point = new Point, globalPos: Point = global): Point = js.native
}
