name := "Akka TDC 2012 Demo"
     
version := "1.0"
     
scalaVersion := "2.9.2"
     
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
     
libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"


seq(netbeans.NetbeansTasks.netbeansSettings:_*)
