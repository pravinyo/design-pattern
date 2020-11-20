package behavioral.observer

import behavioral.observer.editor.Editor
import behavioral.observer.listeners.EmailNotificationListener
import behavioral.observer.listeners.LogOpenListener


object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val editor = Editor()
        val filename = "src/behavioral/observer/file.txt"
        editor.events.subscribe("open",
                LogOpenListener(filename))
        editor.events.subscribe("save",
                EmailNotificationListener("admin@example.com"))

        try {
            editor.openFile(filename)
            editor.saveFile()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}