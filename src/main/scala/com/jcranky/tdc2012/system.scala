package com.jcranky.tdc2012

import akka.actor.{Actor, ActorSystem, Props}

//TODO: receive or configure somehow the location of the coordinators?
class ColorfulMasterActor(colorful: ColorfulMaster) extends Actor {
  val colorCoordinator = context.actorOf(Props(new ColorChooserCoordinator()), "color-chooser-coordinator")
  
  def receive = {
    case StartColorPicking => colorCoordinator ! colorful.positionsToColor
    case ColorFound(pos, color) =>  //TODO: paint it ?
  }
}

class ColorfulMaster(width: Int, height: Int) {
  def positionsToColor() = FindColorForRange(Position(0,0), Position(width-1, height-1))
}

object ColorfulSystem {
  val system = ActorSystem("TDC2012-Demo")
  val master = system.actorOf(Props(new ColorfulMasterActor(new ColorfulMaster(800, 600))), "color-master")
}
