package structural.facade.example_complex_lib

import java.io.File

class AudioMixer {
    fun fix(result:VideoFile): File {
        println("${this.javaClass::getSimpleName} :: fixing audio...")
        return File("temp")
    }
}