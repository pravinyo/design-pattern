package creational.prototype

import creational.prototype.shapes.Circle
import creational.prototype.shapes.Rectangle
import creational.prototype.shapes.Shape

class BundledShapeCache() {
    private val cache = HashMap<String,Shape>()

    init {
        val circle = Circle()
        circle.x = 3
        circle.y = 4
        circle.radius = 45
        circle.color = "red"
        val rect = Rectangle()
        rect.x = 6
        rect.y = 7
        rect.width = 8
        rect.height = 6
        rect.color = "blue"
        put("big red circle",circle)
        put("blue rectangle",rect)
    }

    fun put(key:String,value:Shape):Shape{
        cache[key] = value
        return value
    }

    fun get(key:String):Shape? {
        return cache[key]?.clone()
    }
}

object Demo2{
    @JvmStatic
    fun main(args: Array<String>) {
        val shapeCache = BundledShapeCache()
        val rect = shapeCache.get("blue rectangle")
        rect?.let {
            print(rect.color)
        }
    }
}