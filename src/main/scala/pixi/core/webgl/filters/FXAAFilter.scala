package pixi.core.webgl.filters

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** Basic FXAA implementation based on the code on geeks3d.com with the
  * modification that the texture2DLod stuff was removed since it's
  * unsupported by WebGL.
  *
  * --
  * From:
  * https://github.com/mitsuhiko/webgl-meincraft
  * @constructor
  */
@js.native
@JSName("PIXI.FXAAFilter")
class FXAAFilter() extends Filter