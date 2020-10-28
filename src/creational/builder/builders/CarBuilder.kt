package creational.builder.builders

import creational.builder.cars.Car
import creational.builder.cars.CarType
import creational.builder.components.Engine
import creational.builder.components.GPSNavigator
import creational.builder.components.Transmission
import creational.builder.components.TripComputer

class CarBuilder : Builder {

    private lateinit var carType:CarType
    private lateinit var engine:Engine
    private lateinit var transmission: Transmission

    private var tripComputer: TripComputer? = null
    private var gpsNavigator: GPSNavigator? = null
    private var seats: Int = 0

    override fun setCarType(type: CarType) {
        this.carType = type
    }

    override fun setSeats(seats: Int) {
        this.seats = seats
    }

    override fun setEngine(engine: Engine) {
        this.engine = engine
    }

    override fun setTransmission(transmission: Transmission) {
        this.transmission = transmission
    }

    override fun setTripComputer(tripComputer: TripComputer?) {
        this.tripComputer = tripComputer
    }

    override fun setGPSNavigator(gpsNavigator: GPSNavigator?) {
        this.gpsNavigator = gpsNavigator
    }

    fun build():Car{
        return Car(carType,seats,engine,transmission,tripComputer,gpsNavigator)
    }
}