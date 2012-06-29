package com.jcranky.tdc2012

import akka.actor.ActorSystem
import org.specs2.mutable.After

trait ActorScope extends After {
  implicit val system = ActorSystem("test-system")
  def after = system.shutdown
}
