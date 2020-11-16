package behavioral.iterator.social_network

import behavioral.iterator.profile.Profile

abstract class AbstractSocialNetwork(private val profiles: List<Profile>) : SocialNetwork {
    protected fun simulateNetworkLatency() {
        try {
            Thread.sleep(2500)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

    protected fun findProfile(profileEmail: String): Profile? {
        for (profile in profiles) {
            if (profile.email() == profileEmail) {
                return profile
            }
        }
        return null
    }
}