package structural.composite.shapes

import java.awt.Color
import java.awt.Graphics


class CompoundShape() : BaseShape(0, 0, Color.BLACK) {

    private val children:MutableList<Shape> = ArrayList()

    constructor(vararg components: Shape):this(){
        add(*components)
    }

    fun add(vararg components: Shape) {
        children.addAll(listOf(*components))
    }

    fun add(component: Shape) {
        children.add(component)
    }

    fun remove(child: Shape) {
        children.remove(child)
    }

    fun remove(vararg components: Shape) {
        children.removeAll(listOf(*components))
    }

    fun clear() {
        children.clear()
    }

    override fun x(): Int {
        if (children.size == 0) {
            return 0
        }
        var x: Int = children[0].x()
        for (child in children) {
            if (child.x() < x) {
                x = child.x()
            }
        }
        return x
    }

    override fun y(): Int {
        if (children.size == 0) {
            return 0
        }
        var y: Int = children[0].y()
        for (child in children) {
            if (child.y() < y) {
                y = child.y()
            }
        }
        return y
    }

    override fun width(): Int {
        var maxWidth = 0
        val x = x()
        for (child in children) {
            val childsRelativeX: Int = child.x() - x
            val childWidth: Int = childsRelativeX + child.width()
            if (childWidth > maxWidth) {
                maxWidth = childWidth
            }
        }
        return maxWidth
    }

    override fun height(): Int {
        var maxHeight = 0
        val y = y()
        for (child in children) {
            val childsRelativeY: Int = child.y() - y
            val childHeight: Int = childsRelativeY + child.height()
            if (childHeight > maxHeight) {
                maxHeight = childHeight
            }
        }
        return maxHeight
    }

    override fun move(x: Int, y: Int) {
        for (child in children) {
            child.move(x, y)
        }
    }

    override fun isInsideBounds(x: Int, y: Int): Boolean {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                return true
            }
        }
        return false
    }

    override fun unSelect() {
        super.unSelect()
        for (child in children) {
            child.unSelect()
        }
    }

    fun selectChildAt(x: Int, y: Int): Boolean {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                child.select()
                return true
            }
        }
        return false
    }

    fun childAt(x: Int, y: Int): Shape? {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                return child
            }
        }
        return null
    }

    override fun paint(graphics: Graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics)
            graphics.drawRect(x(), y(), width(), height())
            disableSelectionStyle(graphics)
        }
        for (child in children) {
            child.paint(graphics)
        }
    }
}