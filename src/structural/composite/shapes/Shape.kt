package structural.composite.shapes

import java.awt.Graphics

interface Shape {
    fun x():Int
    fun y():Int
    fun width():Int
    fun height():Int
    fun move(x:Int,y:Int)
    fun isInsideBounds(x:Int,y:Int):Boolean
    fun select()
    fun unSelect()
    fun isSelected():Boolean
    fun paint(graphics:Graphics)
}