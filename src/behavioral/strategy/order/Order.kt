package behavioral.strategy.order

import behavioral.strategy.strategies.PayStrategy




class Order {
    private var totalCost = 0
    private var isClosed = false

    fun processOrder(strategy: PayStrategy) {
        strategy.collectPaymentDetails()
        // Here we could collect and store payment data from the strategy.

    }

    fun setTotalCost(cost: Int) {
        totalCost += cost
    }

    fun getTotalCost(): Int {
        return totalCost
    }

    fun isClosed(): Boolean {
        return isClosed
    }

    fun setClosed() {
        isClosed = true
    }
}