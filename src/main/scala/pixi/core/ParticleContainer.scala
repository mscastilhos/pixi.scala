package pixi.core

import ParticleContainer.Properties
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/** The ParticleContainer class is a really fast version of the Container built solely for speed,
  * so use when you need a lot of sprites or particles. The tradeoff of the ParticleContainer is that advanced
  * functionality will not work. ParticleContainer implements only the basic object transform (position, scale, rotation).
  * Any other functionality like tinting, masking, etc will not work on sprites in this batch.
  *
  * It's extremely easy to use :
  *
  * ```js
  * var container = new ParticleContainer();
  *
  * for (var i = 0; i < 100; ++i)
  * {
  * var sprite = new PIXI.Sprite.fromImage("myImage.png");
  * container.addChild(sprite);
  * }
  * ```
  *
  * And here you have a hundred sprites that will be renderer at the speed of light.
  * @constructor
  * @param size The number of images in the SpriteBatch before it flushes.
  * @param properties The properties of children that should be uploaded to the gpu and applied.
  */
@JSName("PIXI.ParticleContainer")
class ParticleContainer(size: Double = 15000,
                        properties: Properties = ParticleContainer.DEFAULT) extends Container {

  /** The blend mode to be applied to the sprite. Apply a value of blendModes.NORMAL to reset the blend mode. */
  var blendMode: Double = js.native

  /** Used for canvas renderering. If true then the elements will be positioned at the nearest pixel. This provides a
    * nice speed boost.
    */
  var roundPixels: Boolean = js.native

  /** Sets the private properties array to dynamic / static based on the passed properties object
    *
    * @param properties The properties to be uploaded
    */
  def setProperties(properties: Properties): Unit = js.native

  /** Adds a child to this particle container at a specified index. If the index is out of bounds an error will be thrown
    *
    * @param child The child to add
    * @param index The index to place the child in
    * @return The child that was added.
    */
  def addChildAt(child: DisplayObject, index: Double): DisplayObject = js.native

  /** Removes a child from the specified index position.
    *
    * @param index The index to get the child from
    * @return The child that was removed.
    */
  def removeChildAt(index: Double): DisplayObject = js.native
}

object ParticleContainer {

  trait Properties extends js.Object

  /** Creates the properties object for a particle container
    *
    * @param scale When true, scale be uploaded and applied.
    * @param position When true, position be uploaded and applied.
    * @param rotation When true, rotation be uploaded and applied.
    * @param uvs When true, uvs be uploaded and applied.
    * @param alpha When true, alpha be uploaded and applied.
    */
  def properties(scale: Boolean = false,
                 position: Boolean = true,
                 rotation: Boolean = false,
                 uvs: Boolean = false,
                 alpha: Boolean = false): Properties = {
    js.Dynamic.literal(
      scale = scale,
      position = position,
      rotation = rotation,
      uvs = uvs,
      alpha = alpha).asInstanceOf[Properties]
  }

  /** Default properties */
  val DEFAULT = properties()
}
