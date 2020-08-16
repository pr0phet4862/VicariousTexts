package com.PoeticManifestations.vicarioustexts;

public class Story {
    //Starting node of the story
    protected String storyStartMessage;
    protected StoryMessage storyStart;
    protected StoryMessage currentMessage;
    private int totalMessages;

    //Story info
    private String genre, author;

    public Story(String genre, String author) {
        this.genre = genre;
        this.author = author;
        this.storyStart = null;
        this.totalMessages = 0;
    }

    public void startStory(){
        if (storyStart!=null)
            currentMessage = storyStart;
    }

    public StoryMessage getCurrentMessage(){
        return currentMessage;
    }

    public boolean next(){
        currentMessage = currentMessage.getNextMessage();
        return currentMessage != null;
    }

    public void setTotalMessages(int totalMessages){
        this.totalMessages = totalMessages;
    }

    public int getTotalMessages(){
        return totalMessages;
    }

}
