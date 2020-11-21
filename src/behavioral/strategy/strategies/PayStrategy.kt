package behavioral.strategy.strategies

interface PayStrategy {
    fun pay(amount:Int):Boolean
    fun collectPaymentDetails()
}