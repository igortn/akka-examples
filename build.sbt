name := "Akka Examples"

scalaVersion := "2.10.3"

scalacOptions ++= List("-feature","-deprecation")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.2.3",
  "com.typesafe.akka" %% "akka-slf4j" % "2.2.3",
  "ch.qos.logback" % "logback-classic" % "1.0.7"
)

ideaExcludeFolders ++= List(".idea",".idea_modules")

