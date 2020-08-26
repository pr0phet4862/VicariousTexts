package com.poeticManifestations.vicarioustexts.story;

/*
* StoryBuilder class is used to create a Story
*/

import java.util.Date;

public class StoryBuilder extends Story{

    private int index;
    private boolean storyStarted, storyCompleted;

    public StoryBuilder(String genre, String author) {
        super(genre, author);
        index = 0;
        storyStarted = storyCompleted = false;
    }

    //Function to start building the story
    public void startStoryBuild(String message){
        if(storyStarted || storyCompleted)   //return if storyBuilding has already started or completed
            return;

        index = 1; //first message starts at index 1
        storyStart = new StoryMessage(message, false, index);
        currentMessage = storyStart;
        storyStarted = true;
    }

    //Add a single reply for the bot
    public boolean addReply(String message){
        if (!storyStarted || storyCompleted)
            return false;
        StoryMessage nextMessage = currentMessage.addNextMessage(message, false, ++index);
        currentMessage = nextMessage;
        return true;
    }

    //Add a single reply for the player
    public boolean addPlayerReply(String message){
        if (!storyStarted || storyCompleted)
            return false;
        StoryMessage nextMessage = currentMessage.addNextMessage(message, true, ++index);
        currentMessage = nextMessage;
        return true;
    }

    //Set variables indicating StoryBuilding is Complete
    public boolean completeStoryBuild(){
        if (storyStarted) { //end the story if the story has started Build process
            setTotalMessages(index);
            storyCompleted = true;
        }
        return storyCompleted;
    }

    //Set publication date if writer wishes
    public void setPublicationDate(Date publicationDate){
        this.publicationDate = publicationDate;
    }
}
