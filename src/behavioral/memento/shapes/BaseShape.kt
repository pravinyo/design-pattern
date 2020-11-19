package behavioral.memento.shapes

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D

abstract class BaseShape(var x:Int, var y:Int, val color:Color) : Shape {
    var selected = false

    override fun x(): Int = x

    override fun y(): Int = y

    override fun width(): Int = 0

    override fun height(): Int = 0

    override fun move(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    override fun isInsideBounds(x: Int, y: Int): Boolean {
        val c1 = x > x() && x < (x() + width())
        val c2 = y > y() && y < (y() + height())

        return c1 && c2
    }

    override fun select() {
        selected = true
    }

    override fun unSelect() {
        selected = false
    }

    override fun isSelected(): Boolean = selected

    fun enableSelectionStyle(graphics: Graphics){
        graphics.color = Color.LIGHT_GRAY

        val graphics2D = graphics as Graphics2D
        val dash1 = floatArrayOf(2f)
        graphics2D.stroke = BasicStroke(1f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                2f,dash1,0f)
    }

    fun disableSelectionStyle(graphics: Graphics){
        graphics.color = color

        val graphics2D = graphics as Graphics2D
        graphics2D.stroke = BasicStroke()
    }

    override fun paint(graphics: Graphics) {
        if (isSelected()){
            enableSelectionStyle(graphics)
        }else{
            disableSelectionStyle(graphics)
        }
    }
}