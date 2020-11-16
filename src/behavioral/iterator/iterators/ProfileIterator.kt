package behavioral.iterator.iterators

import behavioral.iterator.profile.Profile

interface ProfileIterator {
    fun hasNext():Boolean
    fun next():Profile
    fun reset()
}