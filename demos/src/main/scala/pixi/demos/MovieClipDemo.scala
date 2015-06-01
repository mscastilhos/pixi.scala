package pixi.demos

import org.scalajs.dom
import pixi.core.{Texture, Container, Renderer}
import pixi.extras.MovieClip

import scala.scalajs.js.annotation.JSExport

@JSExport("MovieClip")
object MovieClipDemo {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  pixi.loader.add("spritesheet", "_assets/mc.json").loadAnd {
    // Create a sequence with all textures
    val explosionTextures = for {
      i <- 0 until 26
    } yield Texture.fromFrame("Explosion_Sequence_A " + (i + 1) + ".png")

    for (i <- 0 until 50) {
      // create an explosion MovieClip
      val explosion = new MovieClip(explosionTextures.to)

      explosion.position.x = Math.random() * 800
      explosion.position.y = Math.random() * 600
      explosion.anchor.x = 0.5
      explosion.anchor.y = 0.5

      explosion.rotation = Math.random() * Math.PI

      explosion.scale.set(0.75 + Math.random() * 0.5)

      explosion.gotoAndPlay(Math.random() * 27)

      stage.addChild(explosion)
    }

    // start animating
    dom.requestAnimationFrame(animate _)
  }

  def animate(d: Double = 0) {
    renderer.render(stage)

    dom.requestAnimationFrame(animate _)
  }

}
