package pixi.loaders

import pixi.eventemitter3.EventEmitter

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
trait Loader extends EventEmitter {

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
    * @param url Url of the resource
    * @return This loader
    */
  def add(url: String): Loader = js.native

  /** Adds a resource to the loader queue.
    *
    * @param url Url of the resource. It's also used as the name
    * @param callback A function called when the resource is loaded
    * @return This loader
    */
  def add(url: String, callback: js.Function2[Loader, js.Dictionary[Resource], _]): Loader = js.native

  /** Adds a resource to the loader queue.
    *
    * @param name The name of the resource to load
    * @param url Url of the resource
    * @return This loader
    */
  def add(name: String, url: String): Loader = js.native

  /** Adds a resource to the loader queue.
    *
    * @param name The name of the resource to load
    * @param url Url of the resource
    * @param callback A function called when the resource is loaded
    * @return This loader
    */
  def add(name: String, url: String, callback: js.Function2[Loader, js.Dictionary[Resource], _]): Loader = js.native

  /** Resets the queue of the loader to prepare for a new load.
    *
    * @return
    */
  def reset(): Loader = js.native

  /** Starts loading the queued resources.
    *
    * @return
    */
  def load(): Loader = js.native

  /** Starts loading the queued resources.
    *
    * @param callback Optional callback that will be bound to the `complete` event.
    * @return
    */
  def load(callback: js.Function0[_]): Loader = js.native
}