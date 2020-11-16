package behavioral.iterator.social_network

import behavioral.iterator.iterators.ProfileIterator

interface SocialNetwork {
    fun createFriendsIterator(profileEmail:String):ProfileIterator
    fun createCoworkerIterator(profileEmail:String):ProfileIterator
}