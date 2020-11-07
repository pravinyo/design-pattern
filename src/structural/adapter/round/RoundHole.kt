package structural.adapter.round

class RoundHole (private val radius:Double) {

    fun radius():Double = radius

    fun fits(peg:RoundPeg):Boolean{
        return radius() >= peg.radius()
    }
}