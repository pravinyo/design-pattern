package creational.builder.builders

import creational.builder.cars.CarType
import creational.builder.components.Engine
import creational.builder.components.GPSNavigator
import creational.builder.components.Transmission
import creational.builder.components.TripComputer


/**
 * Builder interface defines all possible ways to configure a product.
 */
interface Builder {
    fun setCarType(type: CarType)
    fun setSeats(seats: Int)
    fun setEngine(engine: Engine)
    fun setTransmission(transmission: Transmission)
    fun setTripComputer(tripComputer: TripComputer?)
    fun setGPSNavigator(gpsNavigator: GPSNavigator?)
}