package behavioral.iterator.iterators

import behavioral.iterator.profile.Profile
import behavioral.iterator.social_network.LinkedIn

class LinkedInIterator(private val linkedIn: LinkedIn,
                       private val type: String,
                       private val email: String) : ProfileIterator {

    var currentPos = 0
    private val emails = mutableListOf<String>()
    private val profiles = mutableListOf<Profile>()

    private fun lazyLoad(){
        if (emails.isEmpty()){
            linkedIn.requestRelatedContactsFromLinkedInAPI(email, type)
                    .map { profile ->
                        emails.add(profile)
                        profiles.add(Profile("", "", ""))
                    }
        }
    }

    override fun hasNext(): Boolean {
        lazyLoad()
        return currentPos < emails.size
    }

    override fun next(): Profile {
        if (!hasNext()) throw NoSuchElementException("No More Profile")

        val friendEmail = emails[currentPos]
        var friendContact: Profile = profiles[currentPos]

        if (friendContact.email().isEmpty()) {
            friendContact = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail)
            profiles[currentPos] = friendContact
        }
        currentPos++
        return friendContact
    }

    override fun reset() {
        currentPos = 0
    }
}