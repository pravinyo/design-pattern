package structural.adapter.round

// RoundPegs are compatible with RoundHoles.
open class RoundPeg(private val radius:Double) {
    constructor() : this(0.0)

    open fun radius():Double = radius
}