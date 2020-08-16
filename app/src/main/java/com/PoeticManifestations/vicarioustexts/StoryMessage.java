package com.PoeticManifestations.vicarioustexts;

import java.util.ArrayList;

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
    private ArrayList<StoryMessage> nextMessages;

    public StoryMessage(String message, boolean isPlayer, int index) {
        this.message = message;
        this.isPlayer = isPlayer;
        this.index = index;
    }

    //A short description of the message if player has multiple reply choices
    public void setMessageSummary(String messageSummary){
        this.messageSummary = messageSummary;
    }

    public void setTimeStamp(String timeStamp){
        this.timeStamp = timeStamp;
    }

    public void setNextMessages(ArrayList<StoryMessage> nextMessages){
        this.nextMessages = nextMessages;
    }

    //Adds a new connecting message to the current message
    public StoryMessage addNextMessage(String nextMessage, boolean isPlayer, int index){
        StoryMessage nextStoryMessage = new StoryMessage(nextMessage, isPlayer, index);
        nextMessages.add(nextStoryMessage);
        return  nextStoryMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public ArrayList<StoryMessage> getNextMessages(){
        return nextMessages;
    }

    public int getNextMessagesCount() {
        return  nextMessages.size();
    }

    public boolean isPlayerMessage(){
        return isPlayer;
    }
}
