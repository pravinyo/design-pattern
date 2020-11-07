package structural.adapter.adapters

import structural.adapter.round.RoundPeg
import structural.adapter.square.SquarePeg
import kotlin.math.pow
import kotlin.math.sqrt

// Adapter allows fitting square pegs into round holes.
class SquarePegAdapter(private val squarePeg: SquarePeg) : RoundPeg(){

    override fun radius():Double{
        // Calculate a minimum circle radius, which can fit this peg.
        return sqrt((squarePeg.width() / 2).pow(2.0))+2
    }
}