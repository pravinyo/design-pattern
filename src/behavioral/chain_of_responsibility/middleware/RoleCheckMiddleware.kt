package behavioral.chain_of_responsibility.middleware

class RoleCheckMiddleware : Middleware() {
    override fun check(email: String, password: String): Boolean {
        if (email == "admin@pravin.com"){
            println("Hello, Admin!")
            return true
        }

        println("Hello, user!")
        return checkNext(email, password)
    }
}