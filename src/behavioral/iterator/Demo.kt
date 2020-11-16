package behavioral.iterator

import behavioral.iterator.profile.Profile
import behavioral.iterator.social_network.Facebook
import behavioral.iterator.social_network.LinkedIn
import behavioral.iterator.social_network.SocialNetwork
import behavioral.iterator.spammer.SocialSpammer
import java.util.*


object Demo {
    private fun createTestProfiles():List<Profile>{
        val data: MutableList<Profile> = ArrayList()
        data.add(Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"))
        data.add(Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"))
        data.add(Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"))
        data.add(Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"))
        data.add(Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"))
        data.add(Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"))
        return data
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val choice = 2
        val network:SocialNetwork
        network = if(choice == 2) LinkedIn(createTestProfiles()) else Facebook(createTestProfiles())
        val spammer = SocialSpammer(network)

        spammer.sendSpamToFriends("anna.smith@bing.com",
                "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?")
        spammer.sendSpamToCoworkers("anna.smith@bing.com",
                "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].")
    }
}