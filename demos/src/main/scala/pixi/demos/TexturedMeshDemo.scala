package pixi.demos

import org.scalajs.dom
import pixi.core._
import pixi.mesh.Rope

import scala.scalajs.js.annotation.JSExport

@JSExport("TexturedMesh")
object TexturedMeshDemo {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  var count = 0.0

  // build a rope!
  val ropeLength = 45

  val points = (0 until 25).map(i => new Point(i * ropeLength, 0))

  val strip = new Rope(Texture.fromImage("_assets/snake.png"), points.to)

  strip.position.x = -40
  strip.position.y = 300

  stage.addChild(strip)

  val g = new Graphics

  g.x = strip.x
  g.y = strip.y
  stage.addChild(g)

  // start animating
  animate()

  def animate(d: Double = 0) {

    count += 0.1

    // make the snake
    for (i <- 0 until points.length) {
      points(i).y = Math.sin((i * 0.5) + count) * 30

      points(i).x = i * ropeLength + Math.cos((i * 0.3) + count) * 20

    }

    // render the stage
    renderer.render(stage);

    renderPoints()

    dom.requestAnimationFrame(animate _)
  }

  def renderPoints(): Unit = {

    g.clear()

    g.lineStyle(2, 0xffc2c2)
    g.moveTo(points(0).x, points(0).y)

    for (p <- points.tail) {
      g.lineTo(p.x, p.y)
    }

    for (p <- points.tail) {
      g.beginFill(0xff0022)
      g.drawCircle(p.x, p.y, 10)
      g.endFill()
    }
  }

}
