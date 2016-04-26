import play.core.PlayVersion

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-nop" % "1.7.21",
  "com.typesafe.play" %% "play" % PlayVersion.current
)

name := "slf4j-nop"

organization := "simplest-possible-play"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.8"