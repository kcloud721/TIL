name := "test-camel"

version := "0.1"

scalaVersion := "2.12.12"

libraryDependencies ++= Seq(
    "org.apache.camel"% "camel-core"  // Camel Dependencies
).map( _ % "2.21.5")

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.13" // log library
)

libraryDependencies += "com.h2database" % "h2" % "1.4.198"
libraryDependencies += "org.apache.camel" % "camel-sql" % "2.21.5"