package behavioral.strategy

import behavioral.strategy.order.Order
import behavioral.strategy.strategies.PayByCreditCard
import behavioral.strategy.strategies.PayByPayPal
import behavioral.strategy.strategies.PayStrategy
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

/**
 * Strategy is a behavioral design pattern that lets you define a family of algorithms,
 * put each of them into a separate class, and make their objects interchangeable.
 *
 * URL: https://refactoring.guru/design-patterns/strategy
 */
object Demo {
    private val priceOnProducts: MutableMap<Int, Int> = HashMap()
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private val order = Order()
    private lateinit var strategy: PayStrategy


    fun init(){
        priceOnProducts[1] = 2200
        priceOnProducts[2] = 1850
        priceOnProducts[3] = 1100
        priceOnProducts[4] = 890
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {

        init()

        while (!order.isClosed()) {
            var cost: Int
            var continueChoice: String
            do {
                print("""
                        Please, select a product:
                        1 - Mother board
                        2 - CPU
                        3 - HDD
                        4 - Memory
                        """.trimIndent())
                val choice = 1
                cost = priceOnProducts[choice]!!
                print("Count: ")
                val count = reader.readLine().toInt()
                order.setTotalCost(cost * count)
                print("Do you wish to continue selecting products? Y/N: ")
                continueChoice = reader.readLine()
            } while (continueChoice.equals("Y", ignoreCase = true))

            println("""
                    Please, select a payment method:
                    1 - PalPay
                    2 - Credit Card
                    """.trimIndent())
            val paymentMethod = reader.readLine()

            // Client creates different strategies based on input from
            // user, application configuration, etc.

            strategy = if (paymentMethod == "1") {
                PayByPayPal()
            } else {
                PayByCreditCard()
            }

            // Order object delegates gathering payment data to strategy
            // object, since only strategies know what data they need to
            // process a payment.

            order.processOrder(strategy)
            print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ")
            val proceed = reader.readLine()
            if (proceed.equals("P", ignoreCase = true)) {
                // EN: Finally, strategy handles the payment.
                //
                // RU: И наконец, стратегия запускает приём платежа.
                if (strategy.pay(order.getTotalCost())) {
                    println("Payment has been successful.")
                } else {
                    println("FAIL! Please, check your data.")
                }
                order.setClosed()
            }
        }
    }
}