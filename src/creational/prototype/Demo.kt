package creational.prototype

import creational.prototype.shapes.Circle
import creational.prototype.shapes.Rectangle
import creational.prototype.shapes.Shape

/**
 * Prototype pattern: Clone class
 * https://refactoring.guru/design-patterns/prototype
 */
object Demo {

    @JvmStatic
    fun main(args: Array<String>) {
        val shapes = mutableListOf<Shape>()
        val shapesCopy = mutableListOf<Shape>()

        val circle = Circle()
        circle.x = 10
        circle.y = 20
        circle.radius = 20
        circle.color = "blue"

        shapes.add(circle)
        shapes.add(circle.clone())

        val rectangle = Rectangle()
        rectangle.x = 10
        rectangle.y = 20
        rectangle.color = "green"
        shapes.add(rectangle)

        cloneAndCompare(shapes, shapesCopy)
    }

    private fun cloneAndCompare(shapes: List<Shape>, shapesCopy: MutableList<Shape>) {

        shapes.forEach {
            shapesCopy.add(it.clone())
        }

        for (i in shapes.indices) {
            if (shapes[i] !== shapesCopy[i]) {
                println("$i: Shapes are different objects (yay!)")
                if (shapes[i] == shapesCopy[i]) {
                    println("$i: And they are identical (yay!)")
                } else {
                    println("$i: But they are not identical (booo!)")
                }
            } else {
                println("$i: Shape objects are the same (booo!)")
            }
        }
    }
}