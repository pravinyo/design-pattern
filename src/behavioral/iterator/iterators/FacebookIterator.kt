package behavioral.iterator.iterators

import behavioral.iterator.profile.Profile
import behavioral.iterator.social_network.Facebook

class FacebookIterator(private val facebook: Facebook,
                       private val type:String,
                       private val email:String) : ProfileIterator {
    private var currentPos = 0
    private val emails = mutableListOf<String>()
    private val profiles = mutableListOf<Profile>()

    private fun lazyLoad(){
        if (emails.isEmpty()){
            facebook.requestProfileFriendsFromFacebook(email,type)
                    .map { profile ->
                        emails.add(profile)
                        profiles.add(Profile("","",""))
                    }
        }
    }

    override fun hasNext(): Boolean {
        lazyLoad()
        return currentPos < emails.size
    }

    override fun next(): Profile {
        if (!hasNext()) {
            throw NoSuchElementException("No more profile")
        }

        val friendEmail = emails[currentPos]
        var friendProfile = profiles[currentPos]

        if (friendProfile.email().isEmpty()){
            friendProfile = facebook.requestProfileFromFacebook(friendEmail)
            profiles[currentPos] = friendProfile
        }
        currentPos++
        return friendProfile
    }

    override fun reset() {
        currentPos = 0
    }
}