package behavioral.strategy.strategies

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*


class PayByPayPal : PayStrategy {
    private val database = HashMap<String, String>()
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private var email: String? = null
    private var password: String? = null
    private var signedIn = false


    init{
        database["pass"] = "p.t@gmail.com"
        database["pratik"] = "nichat@amazon.us"
    }

    /**
     * Collect customer's data.
     */
    override fun collectPaymentDetails() {
        try {
            while (!signedIn) {
                print("Enter the user's email: ")
                email = reader.readLine()
                print("Enter the password: ")
                password = reader.readLine()
                if (verify()) {
                    println("Data verification has been successful.")
                } else {
                    println("Wrong email or password!")
                }
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    private fun verify(): Boolean {
        setSignedIn(email == database[password])
        return signedIn
    }

    /**
     * EN: Save customer data for future shopping attempts.
     *
     * RU: Если клиент уже вошел в систему, то для следующей оплаты данные
     * вводить не придется.
     */
    override fun pay(amount: Int): Boolean {
        return if (signedIn) {
            println("Paying $amount using PayPal.")
            true
        } else {
            false
        }
    }

    private fun setSignedIn(signedIn: Boolean) {
        this.signedIn = signedIn
    }
}