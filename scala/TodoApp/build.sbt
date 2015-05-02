lazy val root = (project in file(".")).
    settings(
        name := "TodoApp",
        version := "1.0",
        scalaVersion := "2.11.2"
        )

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.10.2"