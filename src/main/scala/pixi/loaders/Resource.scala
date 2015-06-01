package pixi.loaders

import org.scalajs.dom.raw.XMLHttpRequest
import pixi.core.Texture
import pixi.eventemitter3.EventEmitter

import scala.scalajs.js

/** Manages the state and loading of a single resource represented by
  * a single URL.
  */
trait Resource extends EventEmitter {
  /** The name of this resource. */
  val name: String = js.native

  /** The url used to load this resource. */
  val url: String = js.native

  /** Stores whether or not this url is a data url. */
  val isDataUrl: Boolean = js.native

  /** The data that was loaded by the resource. */
  var data: js.Any = js.native

  /** Is this request cross-origin? If unset, determined automatically. */
  var crossOrigin: String = js.native

  ///** The method of loading to use for this resource. */
  //var loadType: LOAD_TYPE = js.native

  /** The type used to load the resource via XHR. If unset, determined automatically. */
  var xhrType: String = js.native

  /** The error that occurred while loading (if any). */
  val error: Error = js.native

  /** The XHR object that was used to load this resource. This is only set when `loadType` is `Resource.LOAD_TYPE.XHR`. */
  var xhr: XMLHttpRequest = js.native

  /** Describes if this resource was loaded as json. Only valid after the resource has completely loaded. */
  var isJson: Boolean = js.native

  /** Describes if this resource was loaded as xml. Only valid after the resource has completely loaded. */
  var isXml: Boolean = js.native

  /** Describes if this resource was loaded as an image tag. Only valid after the resource has completely loaded. */
  var isImage: Boolean = js.native

  /** Describes if this resource was loaded as an audio tag. Only valid after the resource has completely loaded. */
  var isAudio: Boolean = js.native

  /** Describes if this resource was loaded as a video tag. Only valid after the resource has completely loaded. */
  var isVideo: Boolean = js.native

  /** Marks the resource as complete.  */
  def complete(): Unit = js.native

  /** Loaded texture */
  var texture: Texture = js.native

  /** Loaded sprite sheet */
  var textures: js.Array[Texture] = js.native

  //var bitmapFont
}