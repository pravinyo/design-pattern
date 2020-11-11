package structural.facade.example_complex_lib

class VideoFile(private val name:String) {
    private val codec:String = name.substring(name.indexOf(".") + 1)

    fun codecType() = codec

    fun name() = name
}