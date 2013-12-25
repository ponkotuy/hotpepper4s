
scalaVersion := "2.10.3"

version := "0.0.2-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.0.2",
  "org.json4s" %% "json4s-native" % "3.2.6"
)

scalacOptions ++= Seq(
  "-deprecation"
)

// hprof settings

fork in run := true

javaOptions in run ++= Seq(
  "-XX:+HeapDumpOnOutOfMemoryError"
)
