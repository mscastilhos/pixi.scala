package pixi.interaction

import pixi.core.DisplayObject

import scala.scalajs.js

/** Type of values passed to interaction event listeners */
@js.native
trait EventData extends js.Object {
  var stopped: Boolean = js.native
  var target: DisplayObject = js.native
  var `type`: String = js.native
  var data: InteractionData = js.native

  def stopPropagation(): Unit = js.native
}
