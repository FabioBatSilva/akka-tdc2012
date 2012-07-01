package com.jcranky.tdc2012

import akka.actor.Actor

class ColorfulMaster extends Actor {
  def receive = {
    case StartColorPicking => //TODO: kick-off work
    case ColorFound(pos, color) =>  //TODO: paint it ?
  }
}
