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



}
