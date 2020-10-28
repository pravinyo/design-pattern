package creational.builder.components

import creational.builder.cars.Car

class TripComputer {
    private lateinit var car: Car

    fun setCar(car: Car){
        this.car = car
    }

    fun fuelLevel(){
        println("Fuel level: ${car.fuel()}")
    }

    fun status(){
        if (car.engine().isStarted()){
            println("Engine is started")
        }else{
            println("Engine can't start")
        }
    }
}