lazy val commonSettings = Seq(
  organization := "space.yaooxx",
  version := "1.0.0-SNAPSHOT",
  scalaVersion := "2.11.8"
);

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "minimal-spark",
    libraryDependencies ++= Seq(
        "org.apache.spark" %% "spark-core" % "2.1.0",
        "org.apache.hadoop" % "hadoop-client" % "2.7.2"
    )
  )

mainClass in (Compile, run) := Some("space.yaooxx.minimal.SimpleApp")
