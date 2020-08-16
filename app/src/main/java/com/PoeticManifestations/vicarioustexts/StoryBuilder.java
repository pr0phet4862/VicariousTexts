package com.PoeticManifestations.vicarioustexts;

/*
* StoryBuilder class is used to create a Story
*/

public class StoryBuilder extends Story{

    private final int maxChoices = 4;
    private int currentChoices;

    public StoryBuilder(String genre, String author) {
        super(genre, author);
        currentChoices = 0;
    }

    //Used when Player has multiple replies to choose from
    public boolean addPlayerChoice(String message, String messageSummary){
        if (currentChoices >= maxChoices)
            return false;
        currentMessage.addNextMessage(message, true);
        currentChoices += 1;
        if (currentChoices == 4){
            
        }
        return true;
    }

    //Add a reply for the bot
    public boolean addReply(String message){
        if (currentChoices > 0)
            return false;
        currentMessage.addNextMessage(message, false);
        return true;
    }
}
