package com.jcranky.tdc2012

case class Position(x: Int, y: Int)

case object StartColorPicking

case class FindColorForRange(initialPos: Position, finalPos: Position)

case class FindColor(pos: Position)
case class ColorFound(pos: Position, rgb: Tuple3[Float, Float, Float])

case object FindColorPart
case class ColorPartFound(value: Float)
