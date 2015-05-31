package pixi

import scala.scalajs.js

/**
 * Manages the state and loading of multiple resources to load.
 *
 * Events fired:
 *
 * - progress Emitted once per loaded or errored resource.
 * - error Emitted once per errored resource.
 * - load Emitted once per loaded resource.
 * - start Emitted when the loader begins to process the queue.
 * - complete Emitted when the queued resources all load.
 */
trait Loader extends js.Object {

  /** The base url for all resources loaded by this loader. */
  var baseUrl: String = js.native

  /** The progress percent of the loader going through the queue. */
  var progress: Double = js.native

  /** Loading state of the loader, true if it is currently loading resources. */
  var loading: Boolean = js.native

  /** The percentage of total progress that a single resource represents. */
  var _progressChunk: Double = js.native

  /** All the resources for this loader keyed by name. */
  var resources: js.Object = js.native

  // TODO: Better add()
  /** Adds a resource to the loader queue.
    *
    * @param name Name of the resource
    * @return This loader
    */
  def add(name: String): Loader = js.native

  /** Resets the queue of the loader to prepare for a new load.
    *
    * @return
    */
  def reset(): Loader = js.native

  /** Starts loading the queued resources.
    *
    * @param callback Optional callback that will be bound to the `complete` event.
    * @return
    */
  def load(callback: js.Function0[_]): Loader = js.native
}