package com.jcranky.tdc2012

import akka.actor.Actor

class ColorChooserCoordinator extends Actor {
  def receive = {
    case FindColorForRange(init, end) =>  // distribute work among ColorChooserActors
  }
}
