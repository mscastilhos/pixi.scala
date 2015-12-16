import pixi.loaders.Loader

/**
 * @author Marcelo Serra Castilhos
 */
package object pixi {
  type AbstractFilter = pixi.core.webgl.filters.Filter
  type SystemRenderer = pixi.core.Renderer

  /** The asset loader */
  val loader: Loader = Env.PIXI.loader.asInstanceOf[Loader]
}
