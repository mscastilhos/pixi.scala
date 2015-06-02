package pixi.scalajs

import scala.scalajs.js

/** Handle the properties of JavaScript objects as tags */
object ObjectTagView {

  /** View JavaScript objects as a collection of tags
    * @author Marcelo Serra Castilhos
    */
  implicit class TaggedObject(val obj: js.Object) extends AnyVal {
    /** Tests if the object has a tag
      *
      * @param tag The name of the tag to test
      * @return `true` if the object has the tag
      */
    @inline
    def hasTag(tag: String): Boolean = {
      js.Object.hasProperty(obj, tag)
    }

    /** Gets the value of a tag
      * @param tag  The name of the tag
      * @tparam A The type of the tag
      * @return The value of the tag
      */
    @inline
    def getTagRaw[A](tag: String): A = {
      obj.asInstanceOf[js.Dynamic].selectDynamic(tag).asInstanceOf[A]
    }

    /** Gets the value of a tag
      * @param tag  The name of the tag
      * @tparam A The type of the tag
      * @return The value of the tag
      */
    def getTag[A](tag: String): Option[A] = {
      if (hasTag(tag)) {
        Some(obj.asInstanceOf[js.Dynamic].selectDynamic(tag).asInstanceOf[A])
      } else {
        None
      }
    }

    /** Gets the value of a tag
      * @param tag  The name of the tag
      * @param default The default value of the tag, used whet the tag isn't set
      * @tparam A The type of the tag
      * @return The value of the tag
      */
    @inline
    def getTag[A](tag: String, default: A): A = {
      if (hasTag(tag)) {
        obj.asInstanceOf[js.Dynamic].selectDynamic(tag).asInstanceOf[A]
      } else {
        default
      }
    }

    /** Gets the value of a tag
      * @param tag  The name of the tag
      * @return The value of the tag
      */
    @inline
    def setTag(tag: String, value: js.Any): Unit = {
      obj.asInstanceOf[js.Dynamic].updateDynamic(tag)(value)
    }
  }

}