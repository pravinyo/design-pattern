package behavioral.observer.editor

import behavioral.observer.publisher.EventManager
import java.io.File

class Editor {
    val events:EventManager = EventManager("open", "save")
    var file: File? = null

    fun openFile(filePath: String){
        file = File(filePath)
        file?.let { events.notify("open", it) }
    }

    @Throws(Exception::class)
    fun saveFile() {
        if (file == null) throw Exception("Please open a file first.")

        file?.let { events.notify("save", it) }
    }
}