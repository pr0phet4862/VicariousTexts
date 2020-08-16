package com.PoeticManifestations.vicarioustexts;

/*
* StoryBuilder class is used to create a Story
*/

public class StoryBuilder extends Story{

    private final int maxChoices = 4;
    private int currentChoices;
    private int index;
    private boolean storyStarted;

    public StoryBuilder(String genre, String author) {
        super(genre, author);
        currentChoices = 0;
        index = 0;
        storyStarted = false;
    }

    //Function to start building the story
    public void startStory(String storyStartMessage){
        index = 0;
        this.storyStartMessage = storyStartMessage;
        story = new StoryMessage(this.storyStartMessage, false, index);
        currentMessage = story;
        storyStarted = true;
    }

    //Used when Player has multiple replies to choose from
    public boolean addPlayerChoice(String message, String messageSummary){
        if (!storyStarted || currentChoices >= maxChoices)
            return false;
        StoryMessage nextMessage = currentMessage.addNextMessage(message, true, ++index);
        nextMessage.setMessageSummary(messageSummary);
        return true;
    }

    //Add a single reply for the bot
    public boolean addReply(String message){
        if (!storyStarted || currentChoices > 0)
            return false;
        StoryMessage nextMessage = currentMessage.addNextMessage(message, false, ++index);
        currentChoices += 1;
        return true;
    }

    //Add a single reply for the player
    public boolean addPlayerReply(String message){
        if (!storyStarted || currentChoices > 0)
            return false;
        StoryMessage nextMessage = currentMessage.addNextMessage(message, true, ++index);
        currentChoices += 1;
        return true;
    }


    public boolean moveToNextMessage(){
        if (currentChoices > 0)
            return false;
        currentMessage = currentMessage.getFirstNextMessage();
        return true;
    }

    //Find and return a message by its ID
    /*public StoryMessage findMessageById(){
        //BFS Algorithm
    }*/
}
