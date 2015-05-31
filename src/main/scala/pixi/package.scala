/**
 * @author Marcelo Serra Castilhos
 */
package object pixi {
  /** The asset loader */
  val loader: Loader = Env.PIXI.loader.asInstanceOf[Loader]
}
