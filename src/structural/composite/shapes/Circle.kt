package structural.composite.shapes

import java.awt.Color
import java.awt.Graphics

class Circle(x:Int,y:Int,color:Color,private val radius:Int) : BaseShape(x,y,color) {

    override fun width(): Int {
        return radius * 2
    }

    override fun height(): Int {
        return radius * 2
    }

    override fun paint(graphics: Graphics){
        super.paint(graphics)
        graphics.drawOval(x(),y(),width(),height())
    }
}