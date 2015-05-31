lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin).
  settings(
    scalaVersion := "2.11.6",
    name := "Pixi.scala",
    version := "0.0.1",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"
  )


lazy val demos = project.in(file("demos")).
  dependsOn(root).
  enablePlugins(ScalaJSPlugin).
  settings(
    scalaVersion := "2.11.6",
    name := "Demos",
    version := "0.0.1",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"
  )

scalaJSStage in Global := FastOptStage

