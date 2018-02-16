import Dependencies._

name := "DEAcademyMockProject"

version := "0.1"

scalaVersion := "2.10.6"

libraryDependencies ++= Seq(kafka,sparkCore,sparkSQL,sparkStreaming,sparkKafka)
