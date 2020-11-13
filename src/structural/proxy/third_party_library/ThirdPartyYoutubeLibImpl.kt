package structural.proxy.third_party_library

import java.util.*
import kotlin.random.Random


class ThirdPartyYoutubeLibImpl : ThirdPartYoutubeLib {

    override fun popularVideos(): HashMap<String, Video> {
        connectToServer("www.youtube.com")
        return getRandomVideos()
    }

    override fun video(videoId: String): Video {
        connectToServer("www.youtube.com/$videoId")
        return getSomeVideo(videoId)
    }

    private fun experienceNetworkLatency() {
        val randomLatency: Int = Random.nextInt(5,10)
        for (i in 0 until randomLatency) {
            try {
                Thread.sleep(100)
            } catch (ex: InterruptedException) {
                ex.printStackTrace()
            }
        }
    }

    private fun connectToServer(server: String) {
        print("Connecting to $server... ")
        experienceNetworkLatency()
        print(" Connected!")
    }

    private fun getRandomVideos(): HashMap<String, Video> {
        print("Downloading populars... ")
        experienceNetworkLatency()
        val hmap = HashMap<String, Video>()
        hmap["catzzzzzzzzz"] = Video("sadgahasgdas", "Catzzzz.avi",)
        hmap["mkafksangasj"] = Video("mkafksangasj", "Dog play with ball.mp4","big data")
        hmap["dancesvideoo"] = Video("asdfas3ffasd", "Dancing video.mpq")
        hmap["dlsdk5jfslaf"] = Video("dlsdk5jfslaf", "Barcelona vs RealM.mov")
        hmap["3sdfgsd1j333"] = Video("3sdfgsd1j333", "Programing lesson#1.avi")
        println("Done!")
        return hmap
    }

    private fun getSomeVideo(videoId: String): Video {
        print("Downloading video... ")
        experienceNetworkLatency()
        val video = Video(videoId, "Some video title")
        print("Done!")
        return video
    }

}