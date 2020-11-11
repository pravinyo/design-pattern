package structural.facade.facade

import structural.facade.example_complex_lib.*
import structural.facade.example_complex_lib.BitrateReader.convert
import structural.facade.example_complex_lib.BitrateReader.read
import structural.facade.example_complex_lib.CodecFactory.extract
import java.io.File


class VideoConversionFacade {

    fun convertVideo(fileName: String, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName)
        val sourceCodec = extract(file)
        val destinationCodec: Codec = if (format != "mp4") {
            OggCompressionCodec()
        } else {
            MPEG4CompressionCodec()
        }

        val buffer = read(file, sourceCodec)
        val intermediateResult = convert(buffer, destinationCodec)
        val result = AudioMixer().fix(intermediateResult)
        println("VideoConversionFacade: conversion completed.")
        return result
    }
}