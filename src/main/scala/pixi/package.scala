import pixi.loaders.Loader

import scala.scalajs.js

/**
 * @author Marcelo Serra Castilhos
 */
package object pixi {
  type AbstractFilter = pixi.core.webgl.filters.Filter
  type SystemRenderer = pixi.core.Renderer

  /** The asset loader */
  val loader: Loader = js.Dynamic.global.PIXI.loader.asInstanceOf[Loader]
}
