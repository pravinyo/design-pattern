package behavioral.template_method.networks

abstract class Network {
    lateinit var username:String
    lateinit var password:String

    fun post(message:String):Boolean{
        // Authenticate before posting. Every network uses a different
        // authentication method.
        if (logIn(this.username, this.password)){
            val result = sendData(message.toByteArray())
            logOut()
            return result
        }

        return false
    }

    abstract fun logIn(username:String, password:String):Boolean
    abstract fun logOut()

    abstract fun sendData(data:ByteArray):Boolean
}