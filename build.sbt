name := """simplest-possible-play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).disablePlugins(PlayLayoutPlugin).disablePlugins(PlayLogback)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.7.21",
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// https://www.playframework.com/documentation/2.5.x/Anatomy#Default-SBT-layout
PlayKeys.playMonitoredFiles ++= (sourceDirectories in (Compile, TwirlKeys.compileTemplates)).value