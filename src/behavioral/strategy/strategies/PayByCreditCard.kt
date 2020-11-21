package behavioral.strategy.strategies

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class PayByCreditCard: PayStrategy {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private var card: CreditCard? = null

    /**
     * Collect credit card data.
     */
    override fun collectPaymentDetails() {
        try {
            print("Enter the card number: ")
            val number = reader.readLine()
            print("Enter the card expiration date 'mm/yy': ")
            val date = reader.readLine()
            print("Enter the CVV code: ")
            val cvv = reader.readLine()
            card = CreditCard(number, date, cvv)

            // Validate credit card number...
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    /**
     * After card validation we can charge customer's credit card.
     */
    override fun pay(amount: Int): Boolean {
        return if (cardIsPresent()) {
            println("Paying $amount using Credit Card.")
            card!!.amount = card!!.amount - amount
            true
        } else {
            false
        }
    }

    private fun cardIsPresent(): Boolean {
        return card != null
    }
}