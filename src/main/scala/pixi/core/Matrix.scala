package pixi.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{global => g}

/** The pixi Matrix class as an object, which makes it a lot faster,
  * here is a representation of it :
  * | a | b | tx|
  * | c | d | ty|
  * | 0 | 0 | 1 |
  * @constructor
  */
@js.native
@JSName("PIXI.Matrix")
class Matrix() extends js.Object {
  val a: Double = js.native
  val b: Double = js.native
  val c: Double = js.native
  val d: Double = js.native
  val tx: Double = js.native
  val ty: Double = js.native

  /** Creates a Matrix object based on the given array. The Element to Matrix mapping order is as follows:
    *
    * a = array[0]
    * b = array[1]
    * c = array[3]
    * d = array[4]
    * tx = array[2]
    * ty = array[5]
    *
    * @param array The array that the matrix will be populated from.
    */
  def fromArray(array: js.Array[Double]): Unit = js.native

  /** Creates an array from the current Matrix object.
    *
    * @param transpose Whether we need to transpose the matrix or not
    * @return the newly created array which contains the matrix
    */
  def toArray(transpose: Boolean): js.Array[Double] = js.native

  /** Get a new position with the current transformation applied.
    * Can be used to go from a child's coordinate space to the world coordinate space. (e.g. rendering)
    *
    * @param pos The origin
    * @param newPos The point that the new position is assigned to (allowed to be same as input)
    * @return The new point, transformed through this matrix
    */
  def apply(pos: Point, newPos: Point = new Point): Point = js.native

  /** Get a new position with the inverse of the current transformation applied.
    * Can be used to go from the world coordinate space to a child's coordinate space. (e.g. input)
    *
    * @param pos The origin
    * @param newPos The point that the new position is assigned to (allowed to be same as input)
    * @return The new point, inverse-transformed through this matrix
    */
  def applyInverse(pos: Point, newPos: Point = new Point): Point = js.native

  /** Translates the matrix on the x and y.
    *
    * @param x
    * @param y
    * @return This matrix. Good for chaining method calls.
    */
  def translate(x: Double, y: Double): Matrix = js.native

  /** Applies a scale transformation to the matrix.
    *
    * @param x The amount to scale horizontally
    * @param y The amount to scale vertically
    * @return This matrix. Good for chaining method calls.
    */
  def scale(x: Double, y: Double): Matrix = js.native

  /** Applies a rotation transformation to the matrix.
    *
    * @param angle The angle in radians.
    * @return This matrix. Good for chaining method calls.
    */
  def rotate(angle: Double): Matrix = js.native

  /** Appends the given Matrix to this Matrix.
    *
    * @param matrix
    * @return This matrix. Good for chaining method calls.
    */
  def append(matrix: Matrix): Matrix = js.native

  /** Prepends the given Matrix to this Matrix.
    *
    * @param matrix
    * @return This matrix. Good for chaining method calls.
    */
  def prepend(matrix: Matrix): Matrix = js.native

  /** Inverts this matrix
    *
    * @return This matrix. Good for chaining method calls.
    */
  def invert(): Matrix = js.native

  /** Resets this Matix to an identity (default) matrix.
    *
    * @return This matrix. Good for chaining method calls.
    */
  def identity(): Matrix = js.native

  /** Creates a new Matrix object with the same values as this one.
    *
    * @return A copy of this matrix. Good for chaining method calls.
    */
  override def clone(): Matrix = js.native

  /** Changes the values of the given matrix to be the same as the ones in this matrix
    *
    * @return The matrix given in parameter with its values updated.
    */
  def copy(): Matrix = js.native
}

object Matrix {
  /** A default (identity) matrix */
  val IDENTITY: Matrix = g.PIXI.Matrix.IDENTITY.asInstanceOf[Matrix]

  /** A temp matrix */
  val TEMP_MATRIX: Matrix = g.PIXI.Matrix.TEMP_MATRIX.asInstanceOf[Matrix]
}