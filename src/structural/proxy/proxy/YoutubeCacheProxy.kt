package structural.proxy.proxy

import structural.proxy.third_party_library.ThirdPartYoutubeLib
import structural.proxy.third_party_library.Video

class YoutubeCacheProxy(private val youtubeService: ThirdPartYoutubeLib) : ThirdPartYoutubeLib {

    private val cachePopular = HashMap<String,Video>()
    private val cacheAll = HashMap<String,Video>()

    override fun popularVideos(): HashMap<String, Video> {
        if (cachePopular.isEmpty()){
            cachePopular.putAll(youtubeService.popularVideos())
        }else{
            println("Retrieving list from cache")
        }

        return cachePopular
    }

    override fun video(videoId: String): Video {
        var video = cacheAll[videoId]

        if (video == null){
            video = youtubeService.video(videoId)
            cacheAll[videoId] = video
        }else{
            println("returned from cache")
        }

        return video
    }

    fun reset(){
        cacheAll.clear()
        cachePopular.clear()
    }
}