scalaVersion := "3.6.3"

val root =
  project
    .in(file("."))
    .enablePlugins(JavaAgent) // Enable adding java agents
    .settings(
      // Add DataDog java agent
      javaAgents += "com.datadoghq" % "dd-java-agent" % "1.45.0" % "test",
      // Add weaver testing framework
      libraryDependencies += "com.disneystreaming" %% "weaver-cats" % "0.8.4" % Test
    )
