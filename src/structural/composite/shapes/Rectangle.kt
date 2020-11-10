package structural.composite.shapes

import java.awt.Color
import java.awt.Graphics

class Rectangle(x:Int, y:Int,private val width:Int,private val height:Int, color:Color) : BaseShape(x, y, color) {
    override fun width(): Int {
        return width
    }

    override fun height(): Int {
        return height
    }

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.drawRect(x(),y(),width(),height())
    }
}