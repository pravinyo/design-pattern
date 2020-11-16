package behavioral.iterator.social_network

import behavioral.iterator.iterators.FacebookIterator
import behavioral.iterator.iterators.ProfileIterator
import behavioral.iterator.profile.Profile

class Facebook(profiles: List<Profile>) : AbstractSocialNetwork(profiles) {

    override fun createFriendsIterator(profileEmail: String): ProfileIterator {
        return FacebookIterator(this,"friends",profileEmail)
    }

    override fun createCoworkerIterator(profileEmail: String): ProfileIterator {
        return FacebookIterator(this, "coworkers", profileEmail)
    }

    fun requestProfileFromFacebook(profileEmail: String):Profile{
        simulateNetworkLatency()
        println("Facebook: Loading profile '$profileEmail' over the network...")
        return findProfile(profileEmail) ?: Profile("","","")
    }

    fun requestProfileFriendsFromFacebook(profileEmail: String, contactType: String): List<String> {
        simulateNetworkLatency()
        println("Facebook: Loading '$contactType' list of '$profileEmail' over the network...")

        val profile = findProfile(profileEmail)
        return profile?.contacts(contactType) ?: emptyList()
    }
}