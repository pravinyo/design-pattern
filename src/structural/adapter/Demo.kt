package structural.adapter

import structural.adapter.adapters.SquarePegAdapter
import structural.adapter.round.RoundHole
import structural.adapter.round.RoundPeg
import structural.adapter.square.SquarePeg

/**
 * Adapter is a structural design pattern that allows objects
 * with incompatible interfaces to collaborate.
 *
 * https://refactoring.guru/design-patterns/adapter
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val roundHole = RoundHole(radius = 6.0)
        val roundPeg = RoundPeg(radius = 5.0)

        if (roundHole.fits(roundPeg)){
            println("Round peg r5 fits round hole r5")
        }

        val smallSqPeg = SquarePeg(width = 2.0)
        val largeSqPeg = SquarePeg(width = 20.0)
        // roundHole.fits(smallSqPeg); // Won't compile.
        // Adapter solves this problem

        val smallSqPegAdapter = SquarePegAdapter(squarePeg = smallSqPeg)
        val largeSqPegAdapter = SquarePegAdapter(squarePeg = largeSqPeg)

        if (roundHole.fits(smallSqPegAdapter)){
            println("Square Peg w2 fits round hole  r5")
        }

        if (roundHole.fits(largeSqPegAdapter)){
            println("Square Peg w20 fits round hole  r5")
        }
    }
}