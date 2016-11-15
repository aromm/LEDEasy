name := "ledplusplus" // you can change this!

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= 
  Seq( "org.scalactic" %% "scalactic" % "3.0.0",
       "org.scalatest" %% "scalatest" % "3.0.0" % "test",
       "org.scalacheck" %% "scalacheck" % "1.12.5" % "test",
       "org.scalafx" % "scalafx_2.11" % "8.0.5-R5",
       "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
       "org.scala-lang" % "scala-compiler" % scalaVersion.value )

unmanagedClasspath in (Compile, runMain) += baseDirectory.value / "resources"


// parser-combinator library
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4"

// read-eval-print loop library
libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

// testing libraries
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"