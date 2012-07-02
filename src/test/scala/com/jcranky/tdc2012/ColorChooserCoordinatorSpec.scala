package com.jcranky.tdc2012

import akka.testkit.TestActorRef
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class ColorChooserCoordinatorSpec extends Specification with Mockito {
  "the color chooser coordinator actor" should {
    "call the position generator method to get positions to send to the subordinated actors" in new ActorScope {
      val coord = mock[Coordinator]
      val actor = TestActorRef(new ColorChooserCoordinator(coord))
      val (init, end) = (Position(0, 0), Position(10, 10))
      
      actor ! FindColorForRange(init, end)
      
      there was one(coord).positions(init, end)
    }
  }
  
  "the coordinator" should {
    val coord = new Coordinator()
    
    "generated the list of positions" in {
      coord.positions(Position(0, 0), Position(2, 2)) must contain(
        Position(0, 0), Position(0, 1), Position(1, 0), Position(1, 1)
      ).only
    }
  }
}
