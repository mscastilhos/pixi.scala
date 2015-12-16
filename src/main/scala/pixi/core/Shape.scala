package pixi.core

import scala.scalajs.js
import js.Dynamic.{global => g}
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

/** Common trait for shapes
  * @author Marcelo Serra Castilhos
  */
@js.native
trait Shape extends js.Object {
  /** The type of the object, mainly used to avoid `instanceof` checks */
  val `type`: Shape.Type = js.native

  /** The type of the object, mainly used to avoid `instanceof` checks */
  @JSName("type")
  val shapeType: Shape.Type = js.native
}

object Shape {

  /** Type of shapes */
  @ScalaJSDefined
  sealed trait Type extends js.Object

  /** Type of polygon shapes */
  val Poly = g.PIXI.SHAPES.POLY.asInstanceOf[Type]
  /** Type of rectangle shapes */
  val Rect = g.PIXI.SHAPES.RECT.asInstanceOf[Type]
  /** Type of circle shapes */
  val Circ = g.PIXI.SHAPES.CIRC.asInstanceOf[Type]
  /** Type of ellipse shapes */
  val Elip = g.PIXI.SHAPES.ELIP.asInstanceOf[Type]
  /** Type of rounded rectangle shape */
  val RRec = g.PIXI.SHAPES.RREC.asInstanceOf[Type]
}
