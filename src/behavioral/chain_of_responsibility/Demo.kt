package behavioral.chain_of_responsibility

import behavioral.chain_of_responsibility.middleware.RoleCheckMiddleware
import behavioral.chain_of_responsibility.middleware.ThrottlingMiddleware
import behavioral.chain_of_responsibility.middleware.UserExistsMiddleware
import behavioral.chain_of_responsibility.server.Server
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Chain of Responsibility is a behavioral design pattern that lets you pass requests
 * along a chain of handlers. Upon receiving a request, each handler decides either to
 * process the request or to pass it to the next handler in the chain.
 *
 * URL: https://refactoring.guru/design-patterns/chain-of-responsibility
 */
object Demo {

    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private lateinit var server:Server

    private fun init(){
        this.server = Server()
        server.register("admin@pravin.com", "admin_pass")
        server.register("user@pravin.com", "user_pass")

        // All checks are linked. Client can build various chains using the
        // same components.
        val throttleMW = ThrottlingMiddleware(requestPerMin = 2)
        val userExistsMW = UserExistsMiddleware(server)
        val roleCheckMW = RoleCheckMiddleware()

        throttleMW.linkWith(userExistsMW).linkWith(roleCheckMW)

        // Server gets a chain from client code.
        server.setMiddleware(middleware = throttleMW)

    }

    @JvmStatic
    fun main(args: Array<String>) {
        init()

        var success: Boolean
        do {
            print("Enter email: ")
            val email = reader.readLine()
            print("Input password: ")
            val password = reader.readLine()
            success = server.login(email, password)
        } while (!success)
    }
}