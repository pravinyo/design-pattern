package behavioral.observer.publisher

import behavioral.observer.listeners.EventListener
import java.io.File


class EventManager(vararg operations: String) {
    var listeners = HashMap<String, MutableList<EventListener>>()

    init {
        for (operation in operations) {
            listeners[operation] = ArrayList()
        }
    }

    fun subscribe(eventType: String, listener: EventListener) {
        listeners[eventType]?.let {
            val users: MutableList<EventListener> = it
            users.add(listener)
        }
    }

    fun unsubscribe(eventType: String, listener: EventListener) {
        listeners[eventType]?.let {
            val users: MutableList<EventListener> = it
            users.remove(listener)
        }
    }

    fun notify(eventType: String, file: File) {
        listeners[eventType]?.let {
            val users: List<EventListener> = it

            users.forEach { listener ->
                listener.update(eventType, file)
            }
        }
    }
}