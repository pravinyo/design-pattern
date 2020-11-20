package behavioral.observer.listeners

import java.io.File

class LogOpenListener(filename:String) : EventListener {

    private val log:File = File(filename)

    override fun update(eventType: String, file: File) {
        println("save to log:$log : Someone has performed $eventType operation with file:${file.name}")
    }
}