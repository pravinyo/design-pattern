package creational.builder.builders

import creational.builder.cars.CarType
import creational.builder.cars.Manual
import creational.builder.components.Engine
import creational.builder.components.GPSNavigator
import creational.builder.components.Transmission
import creational.builder.components.TripComputer

class CarManualBuilder : Builder {
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

    fun build(): Manual {
        return Manual(carType,seats,engine,transmission,tripComputer,gpsNavigator)
    }
}