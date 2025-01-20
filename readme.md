# DataDog java agent with weaver

This repository showcases how to configure DataDog java agent for Scala tests.

To configure DataDog agent this repo uses [sbt-javaagent](https://github.com/sbt/sbt-javaagent).

## How to configure agent in your project

1. In your sbt project, open `project/plugins.sbt` (create one if you don't have it) and add following line `addSbtPlugin("com.github.sbt" % "sbt-javaagent" % "0.1.8")`
2. In your `build.sbt` navigate to your module (`root` in case of this repository)
3. On your module enable java agent module by adding `.enablePlugins(JavaAgent)`
4. Within the module settings attach agent of your choice, for DataDog agent do `javaAgents += "com.datadoghq" % "dd-java-agent" % "1.45.0" % "test"`

Please note that `% "test"` by the end of the line enables the agent within test scope. Please consult [scopes](https://github.com/sbt/sbt-javaagent?tab=readme-ov-file#scopes) section of javaagent plugin for more details.

## Environment variables

For DataDog agent to work, you also need to specify environment variables. You can do this in two ways. 


If you want to keep the values in sbt, you can do it like this:
```scala
envVars := Map(
  "DD_CIVISIBILITY_AGENTLESS_ENABLED" -> "true",
  "DD_SERVICE" -> "myservcice",
  "DD_ENV" -> "local",
  "DD_SITE" -> "datadoghq.com",
  "DD_CIVISIBILITY_ENABLED" -> "true"
)
```

Otherwise you can specify the variables within command line execution:
```
DD_SERVICE=myservcice DD_ENV=local DD_SITE=datadoghq.com DD_CIVISIBILITY_AGENTLESS_ENABLED=true DD_CIVISIBILITY_ENABLED=true sbt
```

Make sure you also have `DD_API_KEY` present in your environment, but it's best not to keep it in your repository and cli invocation.
