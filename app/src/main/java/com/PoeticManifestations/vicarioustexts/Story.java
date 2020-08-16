package com.PoeticManifestations.vicarioustexts;

public class Story {
    //Starting node of the story
    String storyStartMessage;
    StoryMessage story;
    StoryMessage currentMessage;

    //Story info
    String genre, author;

    public Story(String genre, String author) {
        this.genre = genre;
        this.author = author;
    }

    public void startStory(String storyStartMessage){
        this.storyStartMessage = storyStartMessage;
        story = new StoryMessage(this.storyStartMessage, false, 0);
        currentMessage = story;
    }

}
