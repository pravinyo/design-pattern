package structural.flyweight

import structural.flyweight.forest.Forest
import java.awt.Color
import java.awt.Dimension
import kotlin.random.Random

/**
 * Flyweight is a structural design pattern that lets you fit more objects into the available
 * amount of RAM by sharing common parts of state between multiple objects instead of keeping
 * all of the data in each object.
 *
 * URL: https://refactoring.guru/design-patterns/flyweight
 */
object Demo {
    private const val CANVAS_SIZE = 500
    private const val TREES_TO_DRAW = 1_000_000
    private const val TREE_TYPES = 2
    private val guess = {
        Random.nextInt(0, CANVAS_SIZE)
    }

    @JvmStatic
    fun main(args: Array<String>) {

        val forest = Forest()
        for (i in 0 until TREES_TO_DRAW/TREE_TYPES){
            forest.plantTree(guess.invoke(), guess.invoke(),"summer oak", Color.BLUE,"oak summer stub")
            forest.plantTree(guess.invoke(), guess.invoke(),"Autumn oak", Color.BLUE,"oak Autumn stub")
        }

        forest.size = Dimension(CANVAS_SIZE, CANVAS_SIZE)
        forest.isVisible = true

        println("$TREES_TO_DRAW trees drawn")
        println("---------------------")
        println("Memory usage:")
        println("Tree size (8 bytes) * $TREES_TO_DRAW")
        println("+ TreeTypes size (~30 bytes) * $TREE_TYPES")
        println("---------------------")
        println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)")
    }
}