package creational.builder.cars

import creational.builder.components.Engine
import creational.builder.components.GPSNavigator
import creational.builder.components.Transmission
import creational.builder.components.TripComputer

class Manual(private val carType: CarType,
             private val seat: Int,
             private val engine: Engine,
             private val transmission: Transmission,
             private val tripComputer: TripComputer?,
             private val gpsNavigator: GPSNavigator?) {

    override fun toString(): String {
        val info = StringBuilder()
        info.append("Type of car: $carType \n")
        info.append("Count of seats: $seat")
        info.append("Engine: volume - ${engine.volume()}; mileage - ${engine.mileage()}")
        info.append("Transmission: $transmission \n")

        tripComputer.let {
            info.append("Trip Computer: Functional")
        } ?:info.append("Trip Computer: N/A")

        gpsNavigator.let {
            info.append("GPS Navigator: Functional")
        } ?:info.append("GPS Navigator: N/A")

        return info.toString()
    }
}