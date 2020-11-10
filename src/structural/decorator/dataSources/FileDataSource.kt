package structural.decorator.dataSources

import java.io.File
import java.lang.Exception

class FileDataSource(private val name:String) : DataSource {

    override fun writeData(data: String) {
        val file = File(name)
        try {
            file.bufferedWriter().use { out -> out.write(data) }
        }catch (e:Exception){
            println(e.message)
        }
    }

    override fun readData(): String {
        val file = File(name)
        return try {
            file.readText(charset = Charsets.UTF_8)
        }catch (e:Exception){
            println(e.message)
            ""
        }
    }
}