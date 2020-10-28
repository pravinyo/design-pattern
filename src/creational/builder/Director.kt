package creational.builder

import creational.builder.builders.Builder
import creational.builder.cars.CarType
import creational.builder.components.Engine
import creational.builder.components.GPSNavigator
import creational.builder.components.Transmission
import creational.builder.components.TripComputer


class Director {
    fun buildSportsCar(builder: Builder){
        builder.setCarType(CarType.SportsCar)
        builder.setSeats(2)
        builder.setEngine(Engine(3.0, 0.0))
        builder.setTransmission(Transmission.SemiAutomatic)
        builder.setTripComputer(TripComputer())
        builder.setGPSNavigator(GPSNavigator())
    }

    fun buildCityCar(builder: Builder) {
        builder.setCarType(CarType.CityCar)
        builder.setSeats(2)
        builder.setEngine(Engine(1.2, 0.0))
        builder.setTransmission(Transmission.Automatic)
        builder.setTripComputer(TripComputer())
        builder.setGPSNavigator(GPSNavigator())
    }

    fun buildSUV(builder: Builder) {
        builder.setCarType(CarType.SUV)
        builder.setSeats(4)
        builder.setEngine(Engine(2.5, 0.0))
        builder.setTransmission(Transmission.Manual)
        builder.setGPSNavigator(GPSNavigator())
    }
}