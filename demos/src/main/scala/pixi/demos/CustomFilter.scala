package pixi.demos

import org.scalajs.dom
import pixi.core.webgl.filters.Filter
import pixi.core.webgl.filters.Filter.Uniform
import pixi.core.{Sprite, Container, Renderer}
import pixi.loaders.{Loader, Resource}

import scala.scalajs.js
import scala.scalajs.js.annotation.{ScalaJSDefined, JSExport}

@JSExport("CustomFilterDemo")
object CustomFilter {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  @ScalaJSDefined
  class CustomFilter(fragmentSource: String)
    extends Filter(null, fragmentSource, js.Dictionary("customUniform" -> new Uniform("1f", 0)))

  val bg = Sprite.fromImage("_assets/bkg-grass.jpg")
  bg.scale.set(1.3, 1)
  stage.addChild(bg)

  pixi.loader.add("shader", "_assets/basics/shader.frag")

  pixi.loader.once("complete", onLoaded _)

  pixi.loader.load()

  var filter: CustomFilter = _

  def onLoaded(loader: Loader) {

    val fragmentSrc = loader.resources.get("shader").get.data.asInstanceOf[String]

    filter = new CustomFilter(fragmentSrc)

    bg.filters = js.Array(filter)

    animate()
  }

  def animate(d: Double = 0) {

    for (unif <- filter.uniforms.get("customUniform")) {
      val v: Double = unif.get
      unif.set(v + 0.04)
    }

    renderer.render(stage)
    dom.requestAnimationFrame(animate _)
  }
}
