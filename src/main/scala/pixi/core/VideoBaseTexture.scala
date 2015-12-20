package pixi.core

import org.scalajs.dom.raw.HTMLVideoElement

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.annotation.JSName

/** A texture of a [playing] Video.
  *
  * Video base textures mimic Pixi BaseTexture.from.... method in their creation process.
  *
  * This can be used in several ways, such as:
  *
  * {{{js
  * var texture = PIXI.VideoBaseTexture.fromUrl('http://mydomain.com/video.mp4');
  *
  * var texture = PIXI.VideoBaseTexture.fromUrl({ src: 'http://mydomain.com/video.mp4', mime: 'video/mp4' });
  *
  * var texture = PIXI.VideoBaseTexture.fromUrls(['/video.webm', '/video.mp4']);
  *
  * var texture = PIXI.VideoBaseTexture.fromUrls([
  * { src: '/video.webm', mime: 'video/webm' },
  * { src: '/video.mp4', mime: 'video/mp4' }
  * ]);
  * }}}
  *
  * See the ["deus" demo](http://www.goodboydigital.com/pixijs/examples/deus/).
  * @constructor
  * @param source
  * @param scaleMode See {@link SCALE_MODES} for possible values
  */
@js.native
@JSName("PIXI.VideoBaseTexture")
class VideoBaseTexture(source: HTMLVideoElement, scaleMode: Int) extends BaseTexture(source) {
  /** Should the base texture automatically update itself, set to true by default */
  var autoUpdate: Boolean = js.native
}

object VideoBaseTexture {
  /** Mimic Pixi BaseTexture.from.... method.
    *
    * @param video
    * @param scaleMode See { @link SCALE_MODES} for possible values
    * @return
    */
  @inline
  def fromVideo(video: HTMLVideoElement, scaleMode: ScaleMode = ScaleMode.Default): VideoBaseTexture = {
    g.PIXI.VideoBaseTexture.fromVideo(video, scaleMode).asInstanceOf[VideoBaseTexture]
  }

  /** Helper function that creates a new BaseTexture based on the given video element.
    * This BaseTexture can then be used to create a texture
    *
    * @param videoSrc The URL(s) for the video.
    * @param scaleMode See { @link SCALE_MODES} for possible values
    * @return
    */
  @inline
  def fromUrl(videoSrc: js.Any, scaleMode: ScaleMode = ScaleMode.Default): VideoBaseTexture = {
    g.PIXI.VideoBaseTexture.fromUrl(videoSrc, scaleMode).asInstanceOf[VideoBaseTexture]
  }
}