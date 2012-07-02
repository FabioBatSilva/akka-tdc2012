package com.jcranky.tdc2012.main

import com.jcranky.tdc2012._

object main extends App {
  //TODO: pass some kind of reference to the master, so the screen can be updated with the proper colors
  ColorfulSystem.master ! StartColorPicking
  
  //TODO: terribly ugly workaround, replace this with a count of the messages
  //      to find out when we are done
  Thread.sleep(10000)
  
  ColorfulSystem.system.shutdown
}

//TODO: have another kind of main, to startup a node with the akka micro kernel
