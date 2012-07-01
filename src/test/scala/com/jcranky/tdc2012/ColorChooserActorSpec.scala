package com.jcranky.tdc2012

import akka.testkit.TestActorRef
import akka.testkit.TestProbe
import org.specs2.mutable.Specification

class ColorChooserActorSpec extends Specification {
  "the color chooser actor" should {
    "ask for the individual color components from its child actors" in new ActorScope {
      val rProbe = TestProbe()(system)
      val gProbe = TestProbe()
      val bProbe = TestProbe()
      
      val colorChooserActor = TestActorRef(new ColorChooserActor(rProbe.ref, gProbe.ref, bProbe.ref))
      colorChooserActor ! FindColor(Position(0, 0))
      
      rProbe.expectMsg(FindColorPart); rProbe.sender ! ColorPartFound(0.1f)
      gProbe.expectMsg(FindColorPart); gProbe.sender ! ColorPartFound(0.2f)
      bProbe.expectMsg(FindColorPart); bProbe.sender ! ColorPartFound(0.3f)
    }
    
    "return ColorFound with a new color for the specified position" in new ActorScope {
      pending
    }
  }
}
