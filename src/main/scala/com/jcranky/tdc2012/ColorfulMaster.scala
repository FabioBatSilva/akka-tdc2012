package com.jcranky.tdc2012

import akka.actor.Actor

class ColorfulMaster extends Actor {
  def receive = {
    case ColorFound(pos, color) =>  // paint it ?
  }
}
