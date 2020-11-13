package structural.proxy

import structural.proxy.downloader.YoutubeDownloader
import structural.proxy.proxy.YoutubeCacheProxy
import structural.proxy.third_party_library.ThirdPartyYoutubeLibImpl

object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val service = ThirdPartyYoutubeLibImpl()

        val nativeDownloader = YoutubeDownloader(service)
        val smartDownloader = YoutubeDownloader(YoutubeCacheProxy(service))

        val naive = test(nativeDownloader)
        val smart = test(smartDownloader)
        println("Time saved by caching proxy: ${naive - smart}ms")
    }

    private fun test(downloader: YoutubeDownloader): Long {
        val startTime = System.currentTimeMillis()

        // User behavior in our app:
        downloader.renderPopularVideos()
        downloader.renderVideoPage("catzzzzzzzzz")
        downloader.renderPopularVideos()
        downloader.renderVideoPage("dancesvideoo")
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz")
        downloader.renderVideoPage("someothervid")
        val estimatedTime = System.currentTimeMillis() - startTime
        print("Time elapsed: ${estimatedTime}ms")
        return estimatedTime
    }
}