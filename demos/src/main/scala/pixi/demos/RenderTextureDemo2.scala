package pixi.demos

import org.scalajs.dom
import pixi.core.{Sprite, RenderTexture, Container, Renderer}

import scala.scalajs.js.annotation.JSExport

@JSExport("RenderTextureDemo2")
object RenderTextureDemo2 {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  // create two render textures... these dynamic textures will be used to draw the scene into itself
  var renderTexture = new RenderTexture(renderer, renderer.width, renderer.height)
  var renderTexture2 = new RenderTexture(renderer, renderer.width, renderer.height)
  var currentTexture = renderTexture

  // create a new sprite that uses the render texture we created above
  val outputSprite = new Sprite(currentTexture)

  // align the sprite
  outputSprite.position.x = 400
  outputSprite.position.y = 300
  outputSprite.anchor.set(0.5)

  // add to stage
  stage.addChild(outputSprite)

  val stuffContainer = new Container

  stuffContainer.position.x = 400
  stuffContainer.position.y = 300

  stage.addChild(stuffContainer)

  // create an array of image ids..
  val fruits = for (i <- 1 to 8) yield "_assets/spinObj_0" + i + ".png"

  // create an array of items
  // now create some items and randomly position them in the stuff container
  val items = for (i <- 0 until 20) yield {
    val item = Sprite.fromImage(fruits(i % fruits.length))
    item.position.x = Math.random() * 400 - 200
    item.position.y = Math.random() * 400 - 200

    item.anchor.set(0.5)

    stuffContainer.addChild(item)

    item // Yields item
  }

  // used for spinning!
  var count = 0.0

  animate()

  def animate(d: Double = 0)
  {
    dom.requestAnimationFrame(animate _)

    for (item <- items) {
      item.rotation += 0.1
    }

    count += 0.01

    // swap the buffers ...
    val temp = renderTexture
    renderTexture = renderTexture2
    renderTexture2 = temp

    // set the new texture
    outputSprite.texture = renderTexture

    // twist this up!
    stuffContainer.rotation -= 0.01
    outputSprite.scale.set(1 + Math.sin(count) * 0.2)

    // render the stage to the texture
    // the 'true' clears the texture before the content is rendered
    renderTexture2.render(stage, null, clear = false)

    // and finally render the stage
    renderer.render(stage)
  }

}
