package behavioral.iterator.social_network

import behavioral.iterator.iterators.LinkedInIterator
import behavioral.iterator.iterators.ProfileIterator
import behavioral.iterator.profile.Profile

class LinkedIn(profile: List<Profile>) : AbstractSocialNetwork(profile) {
    override fun createFriendsIterator(profileEmail: String): ProfileIterator {
        return LinkedInIterator(this, "friends", profileEmail)
    }

    override fun createCoworkerIterator(profileEmail: String): ProfileIterator {
        return LinkedInIterator(this, "coworkers", profileEmail)
    }

    fun requestContactInfoFromLinkedInAPI(profileEmail: String): Profile {
        simulateNetworkLatency()
        println("LinkedIn: Loading profile '$profileEmail' over the network...")
        return findProfile(profileEmail) ?: Profile("","","")
    }

    fun requestRelatedContactsFromLinkedInAPI(profileEmail: String, contactType: String): List<String> {
        simulateNetworkLatency()
        println("LinkedIn: Loading '$contactType' list of '$profileEmail' over the network...")

        val profile: Profile? = findProfile(profileEmail)
        return profile?.contacts(contactType) ?: emptyList()
    }

}