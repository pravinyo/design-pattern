package behavioral.template_method.networks

class Facebook(username: String, password: String) : Network() {

    init {
        this.password = password
        this.username = username
    }

    override fun logIn(username: String, password: String): Boolean {
        println("\nChecking user's parameters")
        println("Name: $username")
        print("Password: ")
        for (i in password.indices) {
            print("*")
        }
        simulateNetworkLatency()
        println("\n\nLogIn success on Facebook")
        return true
    }

    override fun logOut() {
        println("User: '$username' was logged out from Facebook")
    }

    override fun sendData(data: ByteArray): Boolean {
        val messagePosted = true
        return if (messagePosted) {
            println("Message: '" + String(data) + "' was posted on Facebook")
            true
        } else {
            false
        }
    }

    private fun simulateNetworkLatency() {
        try {
            var i = 0
            println()
            while (i < 10) {
                print(".")
                Thread.sleep(500)
                i++
            }
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }
}