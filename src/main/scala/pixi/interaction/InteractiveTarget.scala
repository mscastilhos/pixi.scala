package pixi.interaction

import scala.scalajs.js

/**
 * Property values of interactive objects
 * @author Marcelo Serra Castilhos
 */
trait InteractiveTarget extends js.Object {

  var interactive: Boolean = js.native
  var buttonMode: Boolean = js.native
  var interactiveChildren: Boolean = js.native
  var defaultCursor: String = js.native
}
