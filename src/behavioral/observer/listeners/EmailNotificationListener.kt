package behavioral.observer.listeners

import java.io.File

class EmailNotificationListener(private val email:String) : EventListener {
    override fun update(eventType: String, file: File) {
        println("Email to $email: Someone has performed $eventType operation with the following file: ${file.name}")
    }
}