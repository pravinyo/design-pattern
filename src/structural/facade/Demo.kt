package structural.facade

import structural.facade.facade.VideoConversionFacade
import java.io.File

object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val converter = VideoConversionFacade()

        val mp4Video: File = converter.convertVideo("pravin.mp4","mp4")
    }
}