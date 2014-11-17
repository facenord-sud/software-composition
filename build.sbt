import AssemblyKeys._ // put this at the top of the file

assemblySettings

test in assembly := {}

jarName in assembly := "dicto-scala-dsl.jar"

name := """dicto-scala-dsl"""

version := "1.0"

scalaVersion := "2.11.1"

// resolvers += "Twitter repo" at "http://maven.twttr.com/"

libraryDependencies ++= Seq(
  //"com.twitter" % "util-eval" % "6.5.0"
)

// Change this to another test framework if you prefer

libraryDependencies += "com.novocode" % "junit-interface" % "0.8"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.3"

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.9.2"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.2"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.3"

