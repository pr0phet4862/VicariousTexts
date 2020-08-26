package com.poeticManifestations.vicarioustexts.story

/*
* Story Message is the class used to store a single message of the story.
* The class contains the message, timestamp, and a list of the next connecting messages.
* The message also contains info if whether the message belongs to the Story Bot or the Player.
* The class is based on a general tree data structure.
*/
class StoryMessage(val message: String, val isPlayerMessage: Boolean, val messageIndex: Int) {
    var timeStamp: String? = null

    //A short description of the message
    var messageSummary: String? = null

    var nextMessage: StoryMessage? = null
        private set

    //Adds a new connecting message to the current message
    fun addNextMessage(message: String, isPlayer: Boolean, index: Int): StoryMessage {
        val nextStoryMessage = StoryMessage(message, isPlayer, index)
        nextMessage = nextStoryMessage
        return nextStoryMessage
    }
}