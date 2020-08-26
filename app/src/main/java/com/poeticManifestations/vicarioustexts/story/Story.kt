package com.poeticManifestations.vicarioustexts.story

import java.util.*

/*
* Story class is used to contain a Story
* It has methods to Start Reading a Story
*/

open class Story(val genre: String = "Unknown", val author: String = "Anonymous") {

    protected lateinit var storyStart: StoryMessage   //Starting node of the story

    var currentMessage: StoryMessage? = null //Points to a specific Message in the story
        protected set

    //Total Messages in the Story
    var totalMessages = 0
        protected set

    //Progress when story is being read
    var progress = 0
        private set

    //Date of publication; Can produce null pointer exception
    var publicationDate: Date? = null

    // Start / Reset Story progress
    fun startStory() {
        currentMessage = storyStart
        progress = 1
    }

    /*
    * Will store next message in currentMessage
    * Returns true if a next message exists
    * false if next message is null
    */
    fun nextMessage(): Boolean {
        if (hasNextMessage()) {
            currentMessage = currentMessage!!.nextMessage
            progress++
            return true
        }
        return false
    }

    //Will check if Story has a next message in the list
    fun hasNextMessage(): Boolean {
        return currentMessage!!.nextMessage != null
    }
}