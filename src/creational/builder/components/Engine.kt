package creational.builder.components

/**
 * Feature of class
 */
class Engine (private val volume:Double,private var mileage:Double) {

    private var started:Boolean = false

    fun on(){
        started = true
    }

    fun off(){
        started = false
    }

    fun isStarted() = started

    fun go(mileage: Double){
        if (started){
            this.mileage = mileage
        }else{
            System.err.println("Start Engine first!")
        }
    }

    fun volume() = this.volume

    fun mileage() = this.mileage
}