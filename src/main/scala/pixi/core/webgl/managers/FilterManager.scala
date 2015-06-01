package pixi.core.webgl.managers

import org.scalajs.dom.webgl.Shader
import pixi.core.{Rectangle, Sprite, Matrix}
import pixi.core.webgl.WebGLRenderer
import pixi.core.webgl.filters.Filter
import pixi.core.webgl.utils.RenderTarget

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.typedarray.ArrayBuffer

/**
 * @constructor
 * @param renderer The renderer this manager works for.
 */
@JSName("PIXI.FilterManager")
class FilterManager(renderer: WebGLRenderer) extends WebGLManager {

  /**
   * @param renderer
   * @param buffer
   */
  def setFilterStack(renderer: WebGLRenderer, buffer: ArrayBuffer): Unit = js.native

  /** Applies the filter and adds it to the current filter stack.
    *
    * @param filterBlock the filter that will be pushed to the current filter stack
    */
  def pushFilter(filterBlock: Filter): Unit = js.native

  /** Removes the last filter from the filter stack and returns it. */
  def popFilter(): Filter = js.native

  /** Grabs an render target from the internal pool
    *
    * @param clear Whether or not we need to clear the RenderTarget
    * @return
    */
  def getRenderTarget(clear: Boolean): RenderTarget = js.native

  /** Returns a RenderTarget to the internal pool
    *
    * @param renderTarget The RenderTarget we want to return to the pool
    */
  def returnRenderTarget(renderTarget: RenderTarget): Unit = js.native

  /** Applies the filter
    *
    * @param shader The shader to upload
    * @param inputTarget
    * @param outputTarget
    * @param clear Whether or not we want to clear the outputTarget
    */
  def applyFilter(shader: Shader, inputTarget: RenderTarget, outputTarget: RenderTarget, clear: Boolean): Unit = js.native

  /** Calculates the mapped matrix
    *
    * @param filterArea The filter area
    * @param sprite the target sprite
    * @param outputMatrix @alvin
    */
  def calculateMappedMatrix(filterArea: Rectangle, sprite: Sprite, outputMatrix: Matrix): Unit = js.native

  /** Constrains the filter area to the texture size
    *
    * @param filterArea The filter area we want to cap
    */
  def capFilterArea(filterArea: Rectangle): Unit = js.native

  /** Resizes all the render targets in the pool
    *
    * @param width the new width
    * @param height the new height
    */
  def resize(width: Double, height: Double): Unit = js.native
}
