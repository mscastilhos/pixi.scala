package pixi.eventemitter3

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** Minimal EventEmitter interface that is molded against the Node.js
  * EventEmitter interface.
  * @constructor
  */
@JSName("EventEmitter")
trait EventEmitter extends js.Object {
  /** Emit an event to all registered event listeners.
    *
    * @param event The name of the event.
    * @return Indication if we've emitted an event.
    */
  def emit(event: String): Boolean = js.native

  /** Register a new EventListener for the given event.
    *
    * @param event Name of the event.
    * @param fn Callback function.
    */
  def on(event: String, fn: js.ThisFunction): this.type = js.native

  /** Add an EventListener that's only called once.
    *
    * @param event Name of the event.
    * @param fn Callback function.
    */
  def once(event: String, fn: js.ThisFunction): this.type = js.native

  /** Remove event listeners.
    *
    * @param event The event we want to remove.
    * @param fn The listener that we need to find.
    * @param context Only remove listeners matching this context.
    * @param once Only remove once listeners.
    */
  def removeListener(event: String, fn: js.ThisFunction, context: Any, once: Boolean): Unit = js.native

  /** Remove all listeners or only the listeners for the specified event.
    *
    * @param event The event want to remove all listeners for.
    */
  def removeAllListeners(event: String): Unit = js.native
}

object EventEmitter {

  implicit class RichEventEmitter[T <: EventEmitter](val ee: T) extends AnyVal {
    /** Checks if the event emitter has a listener for an event
      *
      * @param event The event listened to
      * @return `true` if there is a listener for the event
      */
    def hasListener(event: String): Boolean = {
      import js.DynamicImplicits.truthValue
      ee.asInstanceOf[js.Dynamic].listeners(event, true)
    }

    /** Register a new EventListener for the given events.
      *
      * @param events Names of the events.
      * @param cmd Statement executed when the event is fired
      * @return This event emitter
      */
    def on[A](events: String*)(cmd: => A): T = {
      // Turns the command into a function
      val fn: js.ThisFunction = (_: Any) => cmd

      for (e <- events) {
        ee.on(e, fn)
      }
      ee
    }

    /** Add an EventListener that's only called once for the given events.
      *
      * @param events Names of the event.
      * @param cmd Statement executed when the event is fired
      */
    def once[A](events: String*)(cmd: => A): T = {
      // Turns the command into a function
      val fn: js.ThisFunction = (_: Any) => cmd

      for (e <- events) {
        ee.once(e, fn)
      }
      ee
    }

  }

}
