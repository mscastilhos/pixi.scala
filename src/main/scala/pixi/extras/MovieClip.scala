package pixi.extras

import pixi.core.{Texture, Sprite}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{global => g}


/** A MovieClip is a simple way to display an animation depicted by a list of textures.
  *
  * {{{
  * val alienImages = Seq("image_sequence_01.png","image_sequence_02.png","image_sequence_03.png","image_sequence_04.png")
  * val textures = alienImages map (Texture.fromImage(_))
  *
  * val mc = new MovieClip(textures.to[js.Array])
  * }}}
  * @constructor
  * @param _textures an array of {Texture} objects that make up the animation
  */
@js.native
@JSName("PIXI.extras.MovieClip")
class MovieClip(_textures: js.Array[Texture]) extends Sprite() {

  /** The speed that the MovieClip will play at. Higher is faster, lower is slower */
  var animationSpeed: Double = js.native

  /** Whether or not the movie clip repeats after playing. */
  var loop: Boolean = js.native

  /** Function to call when a MovieClip finishes playing */
  var onComplete: js.Function0[_] = js.native

  /** Indicates if the MovieClip is currently playing */
  val playing: Boolean = js.native

  /** totalFrames is the total number of frames in the MovieClip. This is the same as number of textures assigned
    * to the MovieClip.
    */
  val totalFrames: Int = js.native

  /** The array of textures used for this MovieClip */
  var textures: js.Array[Texture] = js.native

  /** The MovieClips current frame index */
  val currentFrame: Int = js.native

  /** Stops the MovieClip */
  def stop(): Unit = js.native

  /** Plays the MovieClip */
  def play(): Unit = js.native

  /** Stops the MovieClip and goes to a specific frame
    *
    * @param frameNumber frame index to stop at
    */
  def gotoAndStop(frameNumber: Int): Unit = js.native

  /** Goes to a specific frame and begins playing the MovieClip
    *
    * @param frameNumber frame index to start at
    */
  def gotoAndPlay(frameNumber: Double): Unit = js.native
}

object MovieClip {
  /** A short hand way of creating a movieclip from an array of frame ids
    *
    * @param frames the array of frames ids the movieclip will use as its texture frames
    */
  @inline
  def fromFrames(frames: js.Array[String]): MovieClip = {
    g.PIXI.extras.MovieClip.fromFrames(frames).asInstanceOf[MovieClip]
  }

  /** A short hand way of creating a movieclip from an array of frame ids
    *
    * @param frames the sequence of frames ids the movieclip will use as its texture frames
    */
  @inline
  def fromFrames(frames: Seq[String]): MovieClip = {
    g.PIXI.extras.MovieClip.fromFrames(frames.to[js.Array]).asInstanceOf[MovieClip]
  }

  /** A short hand way of creating a movieclip from an array of image ids
    *
    * @param images the array of image urls the movieclip will use as its texture frames
    */
  @inline
  def fromImages(images: js.Array[String]): Unit = {
    g.PIXI.extras.MovieClip.fromImages(images).asInstanceOf[MovieClip]
  }

  /** A short hand way of creating a movieclip from an array of image ids
    *
    * @param images the sequence of image urls the movieclip will use as its texture frames
    */
  @inline
  def fromImages(images: Seq[String]): Unit = {
    g.PIXI.extras.MovieClip.fromImages(images.to[js.Array]).asInstanceOf[MovieClip]
  }
}
