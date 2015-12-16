lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin).
  settings(
    organization := "org.me",
    scalaVersion := "2.11.7",
    name := "Pixi.scala",
    version := "0.1.0",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.1"
  )


lazy val demos = project.in(file("demos")).
  dependsOn(root).
  enablePlugins(ScalaJSPlugin).
  settings(
    scalaVersion := "2.11.7",
    name := "Demos",
    version := "0.1.0",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.1"
  )

scalaJSStage in Global := FastOptStage

