name := "hsrhtl"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  //javaJdbc,
  //javaEbean,
  //cache,
  "org.springframework" % "spring-expression" % "3.2.4.RELEASE",
  "org.springframework" % "spring-web" % "3.2.4.RELEASE",
  "tw.com.eztravel" % "ezlogger" % "1.0.0",
  "eztravel.rest" % "ez-rest-common" % "0.0.1-SNAPSHOT",
  "eztravel.rest" % "ez-rest-hsr-common" % "0.0.2-SNAPSHOT",
  "eztravel.rest" % "ez-rest-htl-common" % "0.0.2-SNAPSHOT",
  "eztravel.rest" % "ez-rest-member-common" % "0.0.1-SNAPSHOT",
  "eztravel.rest" % "ez-rest-b2b-b2e-common" % "0.0.1-SNAPSHOT",
  "eztravel.rest" % "ez-rest-order-common" % "0.0.1-SNAPSHOT"
)     

resolvers += (
    "Eztravel Maven Repository" at "http://test.eztravel.com.tw/maven2/"
)

// sbt eclipse plugin setting
EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE17)

EclipseKeys.skipParents in ThisBuild := false

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

//EclipseKeys.withSource := true
// -- end eclipse settings

scalacOptions ++= Seq("-feature", "-language:reflectiveCalls")

play.Project.playJavaSettings

// begin lib project setting
lazy val ezplaycommon = RootProject(file("../ez-play-common/"))

lazy val root = project in (file(".")) dependsOn (ezplaycommon) aggregate (ezplaycommon)
