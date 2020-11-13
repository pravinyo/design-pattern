package structural.proxy.downloader

import structural.proxy.third_party_library.ThirdPartYoutubeLib


class YoutubeDownloader(private val api: ThirdPartYoutubeLib) {

    fun renderVideoPage(videoId: String) {
        val (id, title, data) = api.video(videoId)
        println("\n-------------------------------")
        println("Video page (imagine fancy HTML)")
        println("ID: $id")
        println("Title: $title")
        println("Video: $data")
        println("-------------------------------\n")
    }

    fun renderPopularVideos() {
        val list = api.popularVideos()
        println("\n-------------------------------")
        println("Most popular videos on YouTube (imagine fancy HTML)")
        for ((id, title) in list.values) {
            println("ID: $id / Title: $title")
        }
        println("-------------------------------\n")
    }
}