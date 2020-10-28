package creational.builder.cars

sealed class CarType {
    object CityCar : CarType()
    object SportsCar : CarType()
    object SUV : CarType()
}