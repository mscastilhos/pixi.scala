package pixi.core.webgl.filters

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
@JSName("PIXI.FXAAFilter")
class FXAAFilter() extends AbstractFilter