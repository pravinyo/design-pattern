package behavioral.chain_of_responsibility.middleware

/**
 * Base middleware class
 */
abstract class Middleware {

    private var next:Middleware?=null

    // Builds chains of middleware objects.
    fun linkWith(next:Middleware):Middleware{
        this.next = next
        return next
    }

    abstract fun check(email:String, password:String):Boolean

    // Runs check on the next object in chain or ends traversing if we're in
    // last object in chain.
    protected fun checkNext(email: String,password: String):Boolean{
        next?.let { return it.check(email, password) }
        return true
    }
}