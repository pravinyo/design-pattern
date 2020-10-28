package creational.builder.cars

import creational.builder.components.Engine
import creational.builder.components.GPSNavigator
import creational.builder.components.Transmission
import creational.builder.components.TripComputer

/**
 * Car is product class
 */
class Car (private val carType:CarType,
           private val seat:Int,
           private val engine:Engine,
           private val transmission: Transmission,
           private val tripComputer: TripComputer?,
           private val gpsNavigator: GPSNavigator?) {

    private var fuel:Int
    init {
        tripComputer?.setCar(this)
        fuel = 0
    }

    fun carType() = carType

    fun fuel() = fuel

    fun setFuel(fuel:Int){
        this.fuel = fuel
    }

    fun seat() = seat

    fun engine() = engine

    fun transmission() = transmission

    fun gpsNavigator() = gpsNavigator

    fun tripComputer() = tripComputer
}