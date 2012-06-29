package com.jcranky.tdc2012

import akka.actor.{Actor, ActorRef}
import akka.dispatch.Await
import akka.pattern.ask
import akka.util.duration._
import akka.util.Timeout
import java.awt.Color
import scala.util.Random

class ColorChooserActor(rPartChooser: ActorRef, gPartChooser: ActorRef, bPartChooser: ActorRef) extends Actor {
  implicit val timeout = Timeout(5 seconds)
  def receive = {
    case FindColor(pos) => 
      val colorFuture = for {
        r <- (rPartChooser ? FindColorPart).mapTo[ColorPartFound]
        g <- (gPartChooser ? FindColorPart).mapTo[ColorPartFound]
        b <- (bPartChooser ? FindColorPart).mapTo[ColorPartFound]
      } yield new Color(r.value, g.value, b.value)
      
      val color = Await.result(colorFuture, 5 seconds)
      sender ! ColorFound(pos, color)
  }
}

class ColorPartChooserActor extends Actor {
  def receive = {
    case FindColorPart => sender ! ColorPartFound(Random.nextFloat)
  }
}
