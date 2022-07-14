ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

scalacOptions ++= Seq("-deprecation")

lazy val root = (project in file("."))
  .settings(
    name := "scala"
  )
