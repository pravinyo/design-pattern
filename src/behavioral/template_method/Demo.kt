package behavioral.template_method

import behavioral.template_method.networks.Facebook
import behavioral.template_method.networks.Network
import behavioral.template_method.networks.Twitter
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Template Method is a behavioral design pattern that defines the skeleton of an algorithm
 * in the superclass but lets subclasses override specific steps of the algorithm without
 * changing its structure.
 *
 * URL: https://refactoring.guru/design-patterns/template-method
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val reader = BufferedReader(InputStreamReader(System.`in`))
        lateinit var network: Network

        print("Input user name: ")
        val userName = reader.readLine()
        print("Input password: ")
        val password = reader.readLine()

        // Enter the message.
        print("Input message: ")
        val message = reader.readLine()

        println("""
            Choose social network for posting message.
            1 - Facebook
            2 - Twitter
            """.trimIndent())
        val choice = reader.readLine().toInt()

        // Create proper network object and send the message.
        network = when (choice) {
            1 -> Facebook(userName, password)
            2 -> Twitter(userName, password)

            else -> {
                println("Invalid input")
                return
            }
        }

        network.post(message)
    }
}