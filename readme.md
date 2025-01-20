# DataDog java agent with weaver

This repository showcases how to configure DataDog java agent for Scala tests.

To configure DataDog agent this repo uses [sbt-javaagent](https://github.com/sbt/sbt-javaagent).

## How to configure agent in your project

1. In your sbt project, open `project/plugins.sbt` (create one if you don't have it) and add following line `addSbtPlugin("com.github.sbt" % "sbt-javaagent" % "0.1.8")`
2. In your `build.sbt` navigate to your module (`root` in case of this repository)
3. On your module enable java agent module by adding `.enablePlugins(JavaAgent)`
4. Within the module settings attach agent of your choice, for DataDog agent do `javaAgents += "com.datadoghq" % "dd-java-agent" % "1.45.0" % "test"`

Please note that `% "test"` by the end of the line enables the agent within test scope. Please consult [scopes](https://github.com/sbt/sbt-javaagent?tab=readme-ov-file#scopes) section of javaagent plugin for more details.