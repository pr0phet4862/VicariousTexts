package com.PoeticManifestations.vicarioustexts.story;

import java.util.Date;

/*
* Story class is used to contain a Story
* It has methods to Start Reading a Story
*/

public class Story {
    StoryMessage storyStart; //Starting node of the story
    StoryMessage currentMessage; //Points to a specific Message in the story
    private int totalMessages, progress;

    //Story info
    private String genre, author;
    Date publicationDate;

    public Story(String genre, String author) {
        publicationDate = null;
        this.genre = genre;
        this.author = author;
        this.storyStart = null;
        this.totalMessages = 0;
    }

    // Start / Reset Story progress
    public void startStory(){
        if (storyStart!=null) {
            currentMessage = storyStart;
            progress = 1;
        }
    }

    //Gets the StoryMessage currently being point to
    public StoryMessage getCurrentMessage(){
        return currentMessage;
    }

    //Will store next message in currentMessage
    //Returns true if a next message exists
    //false if next message is null
    public boolean nextMessage(){
        currentMessage = currentMessage.getNextMessage();
        progress++;
        return currentMessage != null;
    }

    //Will check if Story has a next message in the list
    public boolean hasNextMessage(){
        return currentMessage.getNextMessage() != null;
    }

    //Used to set the totalMessages in inherited class
    void setTotalMessages(int totalMessages){
        this.totalMessages = totalMessages;
    }

    //--------- Getters -------------

    //Get the total number of messages in the Story
    public int getTotalMessages(){
        return totalMessages;
    }

    public Date getPublicationDate(){
        //Can produce null pointer exception
        return this.publicationDate;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getGenre(){
        return this.genre;
    }

}
