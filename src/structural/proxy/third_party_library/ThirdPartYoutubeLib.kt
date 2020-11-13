package structural.proxy.third_party_library

interface ThirdPartYoutubeLib {
    fun popularVideos() : HashMap<String,Video>
    fun video(videoId:String):Video
}