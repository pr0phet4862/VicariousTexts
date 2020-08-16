package com.PoeticManifestations.vicarioustexts;

/*
* StoryBuilder class is used to create a Story
*/

public class StoryBuilder extends Story{

    private int index;
    private boolean storyStarted;

    public StoryBuilder(String genre, String author) {
        super(genre, author);
        index = 0;
        storyStarted = false;
    }

    //Function to start building the story
    public void startStoryBuild(String storyStartMessage){
        index = 1;
        this.storyStartMessage = storyStartMessage;
        storyStart = new StoryMessage(storyStartMessage, false, index);
        currentMessage = storyStart;
        storyStarted = true;
        setTotalMessages(index);
    }

    //Add a single reply for the bot
    public boolean addReply(String message){
        if (!storyStarted)
            return false;
        StoryMessage nextMessage = currentMessage.addNextMessage(message, false, ++index);
        currentMessage = nextMessage;
        setTotalMessages(index);
        return true;
    }

    //Add a single reply for the player
    public boolean addPlayerReply(String message){
        if (!storyStarted)
            return false;
        StoryMessage nextMessage = currentMessage.addNextMessage(message, true, ++index);
        currentMessage = nextMessage;
        setTotalMessages(index);
        return true;
    }
}
