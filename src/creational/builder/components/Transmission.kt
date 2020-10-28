package creational.builder.components

/**
 * Feature of Car
 */
sealed class Transmission {
    object SingleSpeed : Transmission()
    object Manual : Transmission()
    object Automatic : Transmission()
    object SemiAutomatic : Transmission()
}