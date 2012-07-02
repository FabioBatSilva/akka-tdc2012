package com.jcranky.tdc2012

import akka.actor.{Actor, ActorSystem, Props}
import java.awt.Color

//TODO: receive or configure somehow the location of the coordinators?
class ColorfulMasterActor(colorful: ColorfulMaster) extends Actor {
  val colorCoordinator = context.actorOf(Props(new ColorChooserCoordinator()), "color-chooser-coordinator")
  
  def receive = {
    case StartColorPicking => colorCoordinator ! colorful.positionsToColor
    case ColorFound(pos, color) => colorful.paintColor(pos.x, pos.y, color)
  }
}

class ColorfulMaster(width: Int, height: Int, val paintColor: (Int, Int, Color) => Unit) {
  def positionsToColor() = FindColorForRange(Position(0,0), Position(width-1, height-1))
}

object ColorfulSystem {
  val system = ActorSystem("TDC2012-Demo")
}
