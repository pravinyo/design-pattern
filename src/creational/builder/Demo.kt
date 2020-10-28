package creational.builder

import creational.builder.builders.CarBuilder
import creational.builder.builders.CarManualBuilder

object Demo {

    @JvmStatic
    fun main(args: Array<String>) {
        val director = Director()

        //  Director gets the concrete builder object from the client
        //  (application code). That's because application knows better which
        //  builder to use to get a specific product.
        val builder = CarBuilder()
        director.buildSportsCar(builder)

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        val car = builder.build()
        println("Car built: ${car.carType()}")



        val builder2 = CarManualBuilder()
        director.buildSportsCar(builder2)

        val manualCar = builder2.build()
        println("Manual car built: $manualCar")
    }
}