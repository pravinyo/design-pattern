package structural.adapter.square

import kotlin.math.pow

// SquarePegs are not compatible with RoundHoles (they were implemented by
// previous development team). But we have to integrate them into our program.
class SquarePeg (private val width:Double) {

    fun width():Double = width

    fun square():Double{
        return width().pow(2)
    }
}