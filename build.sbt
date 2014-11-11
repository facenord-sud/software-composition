import AssemblyKeys._ // put this at the top of the file

assemblySettings

test in assembly := {}

jarName in assembly := "dicto-scala-dsl.jar"

name := """dicto-scala-dsl"""

version := "1.0"

scalaVersion := "2.11.1"

resolvers += "Twitter repo" at "http://maven.twttr.com/"

libraryDependencies ++= Seq(
  //"com.twitter" % "util-eval" % "6.5.0"
)

// Change this to another test framework if you prefer

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.3"

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.9.2"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.3"

