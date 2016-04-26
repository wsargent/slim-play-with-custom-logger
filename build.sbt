name := """simplest-possible-play"""

version := "1.0-SNAPSHOT"

// run "sbt publishLocal" to establish how you want to configure logging in
lazy val slf4jNop = (project in file("slf4j-nop"))

// Disable layout and logback.
// https://www.playframework.com/documentation/2.5.x/SettingsLogger#using-a-custom-logging-framework
// https://www.playframework.com/documentation/2.5.x/Anatomy#Default-SBT-layout
lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .disablePlugins(PlayLogback)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  // HTTP Client for testing
  ws,

  // Resolve this by typing "project slf4jNop; publishLocal" in sbt
  "simplest-possible-play" %% "slf4j-nop" % "0.0.1-SNAPSHOT",

  // Scalatest extensions with Play
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Don't monitor Twirl templates because they're not being used here...
//PlayKeys.playMonitoredFiles ++= (sourceDirectories in (Compile, TwirlKeys.compileTemplates)).value