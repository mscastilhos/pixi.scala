package pixi.demos

import org.scalajs.dom._
import pixi.core.{Texture, Container, Renderer}
import pixi.extras.MovieClip

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

/**
 * @author Marcelo Serra Castilhos
 */
@JSExport("SpriteSheetAnimation")
object SpriteSheetAnimation {
  var renderer = Renderer.autoDetect(800, 600);
  document.body.appendChild(renderer.view);

  // create the root of the scene graph
  var stage = new Container()

  pixi.loader.add("_assets/basics/fighter.json")
    .load(onAssetsLoaded _)

  var movie: MovieClip = _

  def onAssetsLoaded(): Unit = {
    val frames = for {
      i <- 0 until 30
      frameVal = if (i < 10) "0" + i else i.toString
    } yield Texture.fromFrame("rollSequence00" + frameVal + ".png")

    // create a MovieClip (brings back memories from the days of Flash, right ?)
    movie = new MovieClip(frames.to[js.Array])

    /*
     * A MovieClip inherits all the properties of a PIXI sprite
     * so you can change its position, its anchor, mask it, etc
     */
    movie.position.set(300)

    movie.anchor.set(0.5)
    movie.animationSpeed = 0.5

    movie.play()

    stage.addChild(movie)

    animate()
  }

  def animate(delta: Double = 0): Unit = {
    movie.rotation += 0.01

    // render the stage container
    renderer.render(stage)

    requestAnimationFrame(animate _)
  }

}
