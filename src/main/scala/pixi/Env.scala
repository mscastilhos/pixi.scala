package pixi

import scala.scalajs.js

/**
 * @author Marcelo Serra Castilhos
 */
private[pixi] object Env extends js.GlobalScope {
  /** Raw access to the PIXI namespace */
  val PIXI: js.Dynamic = js.native
}
