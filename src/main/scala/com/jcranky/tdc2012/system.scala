package com.jcranky.tdc2012

import akka.actor.{Actor, ActorSystem, Props}
import java.awt.Color

//TODO: receive or configure somehow the location of the coordinators?
class ColorfulMasterActor(colorful: ColorfulMaster) extends Actor {
  val colorCoordinator = context.actorOf(Props(new ColorChooserCoordinator()), "color-chooser-coordinator")
  
  def receive = {
    case StartColorPicking =>
      colorful.start
      colorCoordinator ! colorful.positionsToColor
      
    case ColorFound(pos, color) =>
      colorful.oneMore
      colorful.paintColor(pos.x, pos.y, color)
  }
}

class ColorfulMaster(width: Int, height: Int, val paintColor: (Int, Int, Color) => Unit) {
  private val totalColorsCount = (width-1) * (height-1)
  private var currentColorsCount = 0
  private var startTime: Long = _
  private var timeSpent: Long = _
  
  def start = startTime = System.currentTimeMillis
  def oneMore = {
    currentColorsCount += 1
    if (totalColorsCount == currentColorsCount) {
      timeSpent = System.currentTimeMillis - startTime
      println("[Timing] painting everything took %d milliseconds".format(timeSpent))
    }
  }
  def positionsToColor() = FindColorForRange(Position(0,0), Position(width-1, height-1))
}

object ColorfulSystem {
  val system = ActorSystem("TDC2012-Demo")
}
