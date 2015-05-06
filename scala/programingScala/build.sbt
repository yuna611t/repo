scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
	"org.specs2" %% "specs2-core" % "3.6" % "test"
)

resolvers ++=  Seq(
	"scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
)