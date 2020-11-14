package behavioral.chain_of_responsibility.server

import behavioral.chain_of_responsibility.middleware.Middleware

class Server {
    private val users = HashMap<String, String>()
    private lateinit var middleware:Middleware

    // Client passes a chain of object to server. This improves flexibility
    // and makes testing the server class easier.
    fun setMiddleware(middleware: Middleware){
        this.middleware = middleware
    }

    fun login(email: String, password: String):Boolean{

        if (middleware.check(email, password)){
            println("Authorization have been successful!")
            return true
        }

        return false
    }

    fun register(email: String, password: String) {
        users[email] = password
    }

    fun hasEmail(email: String): Boolean {
        return users.containsKey(email)
    }

    fun isValidPassword(email: String, password: String): Boolean {
        return users[email] == password
    }
}