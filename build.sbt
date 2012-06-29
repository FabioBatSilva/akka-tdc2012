name := "Akka TDC 2012 Demo"
     
version := "1.0"
     
scalaVersion := "2.9.2"
     
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
    "com.typesafe.akka" % "akka-actor" % "2.0.2",
    "com.typesafe.akka" % "akka-testkit" % "2.0.2" % "test",
    "org.specs2" %% "specs2" % "1.11" % "test"
)

seq(netbeans.NetbeansTasks.netbeansSettings:_*)
