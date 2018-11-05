/*
  General Scala attributes
 */
scalaVersion := "2.12.1"

/*
  General project attributes
 */
organization := "pl.allezon"
name := "offer-store-service"
version := "0.9"
maintainer := "Jacek Ewertowski <jacek.ewertowski1@gmail.com>"
description := "Cache for offer"

/*
  Project dependencies
 */
libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "1.5.4.RELEASE",
  "org.springframework.boot" % "spring-boot-configuration-processor" % "1.5.4.RELEASE",
  "org.apache.kafka" % "kafka-clients" % "0.10.2.0",
  "org.springframework.kafka" % "spring-kafka" % "1.2.2.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-data-mongodb" % "1.5.4.RELEASE",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % "2.8.8",
//  "org.mongodb.scala" %% "mongo-scala-driver" % "2.4.2",
  "com.google.guava" % "guava" % "20.0"
)

/*
  Packaging plugin
 */

// enable the Java app packaging archetype and Ash script (for Alpine Linux, doesn't have Bash)
enablePlugins(JavaAppPackaging, AshScriptPlugin)

// set the main entrypoint to the application that is used in startup scripts
mainClass in Compile := Some("pl.allezon.offerstore.AppRunner")

// the Docker image to base on (alpine is smaller than the debian based one (120 vs 650 MB)
//dockerBaseImage := "openjdk:8-jre-alpine"
//
//// creates tag 'latest' as well when publishing
//dockerUpdateLatest := true