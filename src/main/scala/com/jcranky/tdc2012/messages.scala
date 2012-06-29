package com.jcranky.tdc2012

import java.awt.Color

case class Position(x: Int, y: Int)

case class FindColor(pos: Position)
case class ColorFound(pos: Position, color: Color)

case object FindColorPart
case class ColorPartFound(value: Float)
