package structural.facade.example_complex_lib

object CodecFactory {
    fun extract(file: VideoFile): Codec {
        val type: String = file.codecType()
        return if (type == "mp4") {
            println("CodecFactory: extracting mpeg audio...")
            MPEG4CompressionCodec()
        } else {
            println("CodecFactory: extracting ogg audio...")
            OggCompressionCodec()
        }
    }
}