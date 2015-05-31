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
  def on(event: String, fn: js.Function0[_]): Unit = js.native

  /** Register a new EventListener for the given event.
    *
    * @param event Name of the event.
    * @param fn Callback function.
    * @param context The context of the function.
    */
  def on[A](event: String, fn: js.Function1[A, _], context: A): Unit = js.native

  /** Add an EventListener that's only called once.
    *
    * @param event Name of the event.
    * @param fn Callback function.
    */
  def once(event: String, fn: js.Function0[_]): Unit = js.native

  /** Add an EventListener that's only called once.
    *
    * @param event Name of the event.
    * @param fn Callback function.
    * @param context The context of the function.
    */
  def once[A](event: String, fn: js.Function1[A, _], context: A): Unit = js.native

  /** Remove event listeners.
    *
    * @param event The event we want to remove.
    * @param fn The listener that we need to find.
    * @param context Only remove listeners matching this context.
    * @param once Only remove once listeners.
    */
  def removeListener(event: String, fn: js.Function, context: Any, once: Boolean): Unit = js.native

  /** Remove all listeners or only the listeners for the specified event.
    *
    * @param event The event want to remove all listeners for.
    */
  def removeAllListeners(event: String): Unit = js.native
}

object EventEmitter {

  implicit class RichEventEmitter(val ee: EventEmitter) extends AnyVal {
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
      */
    def on[A](events: String*)(cmd: => A): Unit = {
      // Turns the command into a function
      val fn: js.Function0[A] = () => cmd

      for (e <- events) {
        ee.on(e, () => fn)
      }
    }

    /** Add an EventListener that's only called once for the given events.
      *
      * @param events Names of the event.
      * @param cmd Statement executed when the event is fired
      */
    def once[A](events: String*)(cmd: => A): Unit = {
      // Turns the command into a function
      val fn: js.Function0[A] = () => cmd

      for (e <- events) {
        ee.once(e, () => fn)
      }
    }
  }

}

