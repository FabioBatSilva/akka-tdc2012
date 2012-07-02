package com.jcranky.tdc2012

import akka.testkit.TestActorRef
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class ColorfulMasterActorSpec extends Specification with Mockito {
  "the color chooser master actor" should {
    "send message to the color coordinators" in new ActorScope {
      val masterInstance = mock[ColorfulMaster]
      val master = TestActorRef(new ColorfulMasterActor(masterInstance))
      
      master ! StartColorPicking
      
      there was one(masterInstance).positionsToColor
    }
  }
}
