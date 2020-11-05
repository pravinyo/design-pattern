package creational.prototype.shapes

import java.util.*

public abstract class Shape (target: Shape?) {
    var x:Int = 0
    var y:Int = 0
    var color:String?=null

    init {
        if (target!=null){
            this.x = target.x
            this.y = target.y
            this.color = target.color
        }
    }

    abstract fun clone(): Shape

    override fun equals(other: Any?): Boolean {
        if (other !is Shape) return false

        return other.x == x && other.y == y && Objects.equals(other.color,color)
    }
}