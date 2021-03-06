package pixi.demos

import org.scalajs.dom
import org.scalajs.dom.html.Script
import pixi.core.{Container, Renderer, Sprite, Text}
import pixi.extras.BitmapText

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => lit}
import scala.scalajs.js.annotation.{JSExport, ScalaJSDefined}

@JSExport("TextDemo2")
object TextDemo2 {
  val renderer = Renderer.autoDetect(800, 600)
  dom.document.body.appendChild(renderer.view)

  // create the root of the scene graph
  val stage = new Container

  @ScalaJSDefined
  trait WebFontConfig extends js.Object {
    var WebFontConfig: js.Dynamic
  }

  // Load them google fonts before starting...!
  dom.window.asInstanceOf[WebFontConfig].WebFontConfig = lit(
    google = lit(
      families = js.Array("Snippet", "Arvo:700italic", "Podkova:700")),
    active = init)

  // include the web-font loader script
  locally {
    val wf = dom.document.createElement("script").asInstanceOf[Script]
    wf.src = (if ("https:" == dom.document.location.protocol) "https" else "http") +
      "://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js"
    wf.`type` = "text/javascript"
    wf.async = true
    val s = dom.document.getElementsByTagName("script")(0)
    s.parentNode.insertBefore(wf, s)
  }

  def init(): Unit = {
    pixi.loader.add("desyrel", "_assets/desyrel.xml").load(onAssetsLoaded _)


    def onAssetsLoaded() {
      println("XXXXX")
      val bitmapFontText = new BitmapText("bitmap fonts are \n now supported !", new BitmapText.Style("35px Desyrel") {
        align = "right"
      })
      println(bitmapFontText)

      bitmapFontText.position.x = 600 - bitmapFontText.textWidth
      bitmapFontText.position.y = 20

      stage.addChild(bitmapFontText)
    }

    // add a shiny background...
    val background = Sprite.fromImage("_assets/textDemoBG.jpg")
    stage.addChild(background)

    // create some white text using the Snippet webfont
    val textSample = new Text("Pixi.js can has \n multiline text !",
      new Text.Style {
        font = "35px Snippet"
        fill = "white"
        align = "left"
      })

    textSample.position.set(20)

    // create a text object with a nice stroke
    val spinningText = new Text("'I'm fun !",
      new Text.Style {
        font = "bold 60px Arial"
        fill = "#cc00ff"
        align = "center"
        stroke = "#FFFFFF"
        strokeThickness = 6.0
      })

    // setting the anchor point to 0.5 will center align the text... great for spinning!
    spinningText.anchor.set(0.5)
    spinningText.position.x = 310
    spinningText.position.y = 200

    // create a text object that will be updated...
    val countingText = new Text("COUNT 4 EVAR: 0",
      new Text.Style {
        font = "bold italic 60px Arvo"
        fill = "#3e1707"
        align = "center"
        stroke = "#a4410e"
        strokeThickness = 7.0
      })

    countingText.position.x = 310
    countingText.position.y = 320
    countingText.anchor.x = 0.5

    stage.addChild(textSample)
    stage.addChild(spinningText)
    stage.addChild(countingText)

    var count = 0.0

    dom.requestAnimationFrame(animate _)

    def animate(d: Double = 0) {

      renderer.render(stage)

      count += 0.05
      // update the text with a new string
      countingText.text = "COUNT 4 EVAR: " + count.toInt

      // let's spin the spinning text
      spinningText.rotation += 0.03

      dom.requestAnimationFrame(animate _)
    }
  }

}
