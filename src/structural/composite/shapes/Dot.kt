package structural.composite.shapes

import java.awt.Color
import java.awt.Graphics

class Dot(x:Int, y:Int, color:Color) : BaseShape(x, y, color) {
    private companion object{
        const val DOT_SIZE = 3
    }

    override fun width(): Int {
        return DOT_SIZE
    }

    override fun height(): Int {
        return DOT_SIZE
    }

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.fillRect(x(),y(),width(),height())
    }
}