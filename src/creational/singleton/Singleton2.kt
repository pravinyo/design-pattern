package creational.singleton

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

// Kotlin has a default implementation
object Singleton2 {
    fun getDataProvider() = DataProviderManager

    fun getListener() = DefaultListener
}

// Object declaration’s initialization is thread-safe.
object DataProviderManager {
    fun registerDataProvider(provider: Any) {
        print(provider.toString())
    }

    val allDataProviders: Collection<Any>?
        get() = null
}

// Objects can have supertypes:
object DefaultListener : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) { print(e.locationOnScreen) }

    override fun mouseEntered(e: MouseEvent) { print(e.locationOnScreen) }
}