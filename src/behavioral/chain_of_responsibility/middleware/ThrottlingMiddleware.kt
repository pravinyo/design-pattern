package behavioral.chain_of_responsibility.middleware

class ThrottlingMiddleware(private val requestPerMin:Int) : Middleware() {

    private var currentTime:Long = System.currentTimeMillis()
    private var request:Int = 0

    override fun check(email: String, password: String): Boolean {
        if (System.currentTimeMillis() > currentTime + 60_000){
            request = 0
            currentTime = System.currentTimeMillis()
        }

        request++

        if (request > requestPerMin){
            println("Request limit exceeded!")
            Thread.currentThread().interrupt()
        }

        return checkNext(email, password)
    }
}