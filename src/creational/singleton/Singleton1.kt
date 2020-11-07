package creational.singleton

class Singleton1 private constructor(){

    private object Holder {
        val INSTANCE = Singleton1()
    }

    companion object{
        // The evaluation of lazy properties is synchronized
        val instance : Singleton1 by lazy { Holder.INSTANCE }
    }

}