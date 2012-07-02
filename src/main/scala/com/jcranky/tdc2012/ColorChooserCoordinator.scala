package com.jcranky.tdc2012

import akka.actor.{Actor, Props}
import akka.routing.FromConfig

class ColorChooserCoordinator(coord: Coordinator = new Coordinator) extends Actor {
  val colorChooserRouter = context.actorOf(
    Props[ColorChooserActor].withRouter(FromConfig()), "color-chooser-router")
  
  def receive = {
    case FindColorForRange(init, end) => 
      coord.positions(init, end) foreach(pos => colorChooserRouter.tell(FindColor(pos), sender))
  }
}

class Coordinator {
  def positions(init: Position, end: Position) =
    for {x <- init.x to end.x-1; y <- init.y to end.y-1} yield Position(x, y)
}
