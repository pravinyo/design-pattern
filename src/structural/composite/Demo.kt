package structural.composite

import structural.composite.editors.ImageEditor
import structural.composite.shapes.Circle
import structural.composite.shapes.CompoundShape
import structural.composite.shapes.Dot
import structural.composite.shapes.Rectangle
import java.awt.Color

/**
 * Composite is a structural design pattern that lets you compose objects into tree structures
 * and then work with these structures as if they were individual objects.
 *
 * URI: https://refactoring.guru/design-patterns/composite
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val editor = ImageEditor()

        editor.loadShapes(
                Circle(10, 10, Color.RED, 10),

                CompoundShape(
                        Circle(110, 110, Color.BLUE, 50),
                        Dot(160, 160, Color.BLUE)
                ),

                CompoundShape(
                        Rectangle(250, 250, 100, 100, Color.GREEN),
                        Dot(240, 240, Color.GREEN),
                        Dot(240, 360, Color.GREEN),
                        Dot(360, 360, Color.GREEN),
                        Dot(360, 240, Color.GREEN)
                )
        )
    }
}