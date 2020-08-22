package com.PoeticManifestations.vicarioustexts.story;

/*
* Story Message is the class used to store a single message of the story.
* The class contains the message, timestamp, and a list of the next connecting messages.
* The message also contains info if whether the message belongs to the Story Bot or the Player.
* The class is based on a general tree data structure.
*/

public class StoryMessage {
    private String message, timeStamp, messageSummary;
    private boolean isPlayer;
    private int index;
    private StoryMessage nextMessage;

    public StoryMessage(String message, boolean isPlayer, int index) {
        this.message = message;
        this.isPlayer = isPlayer;
        this.index = index;
        this.nextMessage = null;
    }

    //Adds a new connecting message to the current message
    public StoryMessage addNextMessage(String message, boolean isPlayer, int index){
        StoryMessage nextStoryMessage = new StoryMessage(message, isPlayer, index);
        this.nextMessage = nextStoryMessage;
        return  nextStoryMessage;
    }


    //--------- Setters -------------

    //A short description of the message if player has multiple reply choices
    public void setMessageSummary(String messageSummary){
        this.messageSummary = messageSummary;
    }

    public void setTimeStamp(String timeStamp){
        this.timeStamp = timeStamp;
    }


    //--------- Getters -------------

    public String getMessage() {
        return message;
    }

    public String getMessageSummary() {
        return messageSummary;
    }

    public StoryMessage getNextMessage() {
        return nextMessage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public boolean isPlayerMessage(){
        return isPlayer;
    }

    public int getMessageIndex(){
        return index;
    }
}
