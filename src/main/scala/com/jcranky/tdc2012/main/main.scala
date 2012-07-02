package com.jcranky.tdc2012.main

import akka.actor.Props
import com.jcranky.tdc2012._
import java.awt.Color

object main extends App {
  val (width, height) = (800, 600)
  
  val updateFunc = showUI()
  
  val master = ColorfulSystem.system.actorOf(
    Props(new ColorfulMasterActor(new ColorfulMaster(width, height, updateFunc))), "color-master")
  master ! StartColorPicking
  
  //TODO: terribly ugly workaround, replace this with a count of the messages
  //      to find out when we are done
  Thread.sleep(60000)
  
  ColorfulSystem.system.shutdown
  
  //TODO: replace with scala-swing? manual classpath adding required?
  def showUI(): (Int, Int, Color) => Unit = {
    import java.awt._
    import javax.swing._

    val panel = new JPanel()
    panel.setPreferredSize(new Dimension(width, height))
  
    val frame = new JFrame("Akka TDC 2012 Demo")
    frame.setLayout(new BorderLayout())
    frame.add(panel)
    frame.pack()
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setVisible(true)
    
    (x: Int, y: Int, color: Color) => {
      val g = frame.getGraphics
      g.setColor(color)
      g.drawLine(x, y, x, y)
    }
  }
}

//TODO: have another kind of main, to startup a node with the akka micro kernel
