import sbt.Keys.scalaVersion

name := "rock-the-jvm-scala-beginners"

version := "0.1"

scalaVersion := "2.12.8"

lazy val filesystem = project
  .settings(
    name := "filesystem",
  )


lazy val core = project
  .settings(
    name := "core",
  ).dependsOn(filesystem)

lazy val root = (project in file("."))
  .aggregate(filesystem, core)

mainClass := Some("FileSystem")
