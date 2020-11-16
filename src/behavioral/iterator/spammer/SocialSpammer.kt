package behavioral.iterator.spammer

import behavioral.iterator.iterators.ProfileIterator
import behavioral.iterator.profile.Profile
import behavioral.iterator.social_network.SocialNetwork

class SocialSpammer(private val network: SocialNetwork) {
    private lateinit var iterator: ProfileIterator

    fun sendSpamToFriends(profileEmail: String, message: String) {
        println("\nIterating over friends...\n")
        iterator = network.createFriendsIterator(profileEmail)
        while (iterator.hasNext()) {
            val profile: Profile = iterator.next()
            sendMessage(profile.email(), message)
        }
    }

    fun sendSpamToCoworkers(profileEmail: String, message: String) {
        println("\nIterating over coworkers...\n")
        iterator = network.createCoworkerIterator(profileEmail)
        while (iterator.hasNext()) {
            val profile: Profile = iterator.next()
            sendMessage(profile.email(), message)
        }
    }

    private fun sendMessage(email: String, message: String) {
        println("Sent message to: '$email'. Message body: '$message'")
    }
}