package com.poeticManifestations.vicarioustexts.story

/*
* StoryBuilder class is used to create a Story
*/
class StoryBuilder(genre: String, author: String) : Story(genre, author) {
    private var index: Int
    private var storyStarted: Boolean
    private var storyCompleted: Boolean

    init {
        index = 0
        storyStarted = false
        storyCompleted = false
    }

    //Function to start building the story
    fun startStoryBuild(message: String) {
        if (storyStarted || storyCompleted) //return if storyBuilding has already started or completed
            return
        index = 1 //first message starts at index 1
        storyStart = StoryMessage(message, false, index)
        currentMessage = storyStart
        storyStarted = true
    }

    //Add a single reply for the bot
    fun addReply(message: String): Boolean {
        if (!storyStarted || storyCompleted) return false
        val newMessage = currentMessage!!.addNextMessage(message, false, ++index)
        currentMessage = newMessage
        return true
    }

    //Add a single reply for the player
    fun addPlayerReply(message: String): Boolean {
        if (!storyStarted || storyCompleted) return false
        val newMessage = currentMessage!!.addNextMessage(message, true, ++index)
        currentMessage = newMessage
        return true
    }

    //Set variables indicating StoryBuilding is Complete
    fun completeStoryBuild(): Boolean {
        if (storyStarted) { //end the story if the story has started Build process
            totalMessages = index
            storyCompleted = true
        }
        return storyCompleted
    }
}