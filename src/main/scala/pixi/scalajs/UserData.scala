package pixi.scalajs

import scala.scalajs.js

/** Adds a typed "userData" member to JavaScript objects
  * @author Marcelo Serra Castilhos
  */
trait UserData[A] extends js.Object {
  /** Data set by the user */
  var userData: A = js.native
}

object UserData {

  /** Adds the withUserData method to objects */
  implicit class WithUserData[T <: js.Object](val obj: T) {
    def withUserData[A](userData: A): T with UserData[A] = {
      // Creates the property
      obj.asInstanceOf[js.Dynamic].updateDynamic("userData")(null)
      // Extended object
      val eObj = obj.asInstanceOf[T with UserData[A]]
      eObj.userData = userData
      eObj
    }
  }

}