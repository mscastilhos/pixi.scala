package pixi.demos

import org.scalajs.dom
import pixi.core.{Texture, Point, Container, Renderer}
import pixi.mesh.Rope

import scala.scalajs.js.annotation.JSExport

@JSExport("Strip")
object Strip {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  var count = 0.0

  // build a rope!
  val ropeLength = 918.0 / 20

  val points = for (i <- 0 until 20) yield new Point(i * ropeLength, 0)


  val strip = new Rope(Texture.fromImage("_assets/snake.png"), points.to)

  strip.x = -459

  val snakeContainer = new Container
  snakeContainer.position.x = 400
  snakeContainer.position.y = 300

  snakeContainer.scale.set(800.0 / 1100)
  stage.addChild(snakeContainer)

  snakeContainer.addChild(strip)

  // start animating
  dom.requestAnimationFrame(animate _)

  def animate (d: Double): Unit = {

    count += 0.1

    // make the snake
    for (i <- points.indices) {

      points(i).y = Math.sin((i * 0.5) + count) * 30

      points(i).x = i * ropeLength + Math.cos((i * 0.3) + count) * 20
    }

    // render the stage
    renderer.render(stage)

    dom.requestAnimationFrame(animate _)
  }
}
