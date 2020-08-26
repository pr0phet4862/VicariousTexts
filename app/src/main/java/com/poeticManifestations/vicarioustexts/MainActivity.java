package com.poeticManifestations.vicarioustexts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.poeticManifestations.vicarioustexts.databinding.ActivityHomeBinding;
import com.poeticManifestations.vicarioustexts.story.Story;
import com.poeticManifestations.vicarioustexts.story.StoryBuilder;
import com.google.android.material.appbar.MaterialToolbar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    //View Component Variables
    private MaterialToolbar toolbar;
    private RecyclerView messageRecyclerView;
    private EditText messageInput;
    private ImageButton sendButton;

    //Other variables
    private String playerName;
    private StoryBuilder newStory;
    private Story story;
    private String currentPlayerMessage;
    private MessageRecycvlerViewAdapter messageRecycvlerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerName = "Nitish";
        //Initialize all view components
        initViews();
        messageRecycvlerViewAdapter = new MessageRecycvlerViewAdapter(this);
        messageRecyclerView.setAdapter(messageRecycvlerViewAdapter);
        messageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        play();
    }

    private void play() {
        createNewStory();
        toolbar.setSubtitle("Online");
        story = this.newStory;
        story.startStory();
        displayBotMessage();
    }

    private void initViews() {
        toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Annie");
        toolbar.setSubtitle("Offline");
        messageRecyclerView = findViewById(R.id.messageRecyclerView);
        messageInput = findViewById(R.id.messageInput);
        messageInput.setInputType(InputType.TYPE_NULL);
        messageInput.setHint("Wait for message");
        sendButton = findViewById(R.id.sendButton);
        sendButton.setEnabled(false);
       messageInput.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (currentPlayerMessage!=null){
                   messageInput.setText(currentPlayerMessage);
                   messageInput.setEnabled(false);
                   sendButton.setEnabled(true);
               }
           }
       });
       sendButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               sendButton.setEnabled(false);
               messageInput.setText("");
               story.getCurrentMessage().setTimeStamp(getCurrentTimeStamp());
               messageRecycvlerViewAdapter.addMessage(story.getCurrentMessage());
               messageRecyclerView.smoothScrollToPosition(messageRecycvlerViewAdapter.getItemCount() - 1);
               if (story.nextMessage()) {
                   Log.d("MainActivity", story.getCurrentMessage().getMessage());
                   if (story.getCurrentMessage().isPlayerMessage()) {
                       currentPlayerMessage = story.getCurrentMessage().getMessage();
                       messageInput.setEnabled(true);
                       messageInput.setHint("Tap here to type...");
                   } else {
                       messageInput.setHint("Wait for Reply");
                       messageInput.setEnabled(false);
                       displayBotMessage();
                   }
               } else {
                   toolbar.setSubtitle("Offline");
                   messageInput.setHint("Contact has gone offline.");
               }
           }
       });
    }

    private String getCurrentTimeStamp(){
        Date currentTime = Calendar.getInstance().getTime();
        DateFormat date = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        return date.format(currentTime);
    }

    private void displayBotMessage() {
        //Create a handler which will delay execution of code
        Handler handler = new Handler();
        toolbar.setSubtitle("Typing....");
        String currentMessageText = story.getCurrentMessage().getMessage();
        int delay = generateRandomDelay(currentMessageText.length());

        handler.postDelayed(new Runnable() {
            //Run this code after specified delay
            @Override
            public void run() {
                toolbar.setSubtitle("Online");
                story.getCurrentMessage().setTimeStamp(getCurrentTimeStamp());
                messageRecycvlerViewAdapter.addMessage(story.getCurrentMessage());
                messageRecyclerView.smoothScrollToPosition(messageRecycvlerViewAdapter.getItemCount() - 1);
                if (story.nextMessage()){
                    if(story.getCurrentMessage().isPlayerMessage()){
                        currentPlayerMessage = story.getCurrentMessage().getMessage();
                        messageInput.setEnabled(true);
                        messageInput.setHint("Tap here to type...");
                        messageInput.requestFocus();
                    } else {
                        displayBotMessage();
                    }
                } else {
                    toolbar.setSubtitle("Offline");
                    messageInput.setHint("Contact has gone offline.");
                }
            }
        }, delay);
    }


    //Generates random delay based on text length
    private int generateRandomDelay(int textLength){
        Random rand = new Random();
        int max = 1500;
        int min = 500;
        if (textLength > 50){
            max = 2500;
            min = 1000;
        } else if (textLength > 100){
            max = 3000;
            min = 1500;
        } else if (textLength > 500){
            max = 4500;
            min = 2000;
        }
        int delay = rand.nextInt(max - min) + min;
        return delay;
    }

    private void createNewStory() {
        newStory = new StoryBuilder("Horror", "Anonymous");

        newStory.startStoryBuild("you asleep??");
        newStory.addPlayerReply("no.. guess you’re not either :p");
        newStory.addReply("can’t.. it’s the wind.. sounds like cats fighting. whats your excuse? :p");
        newStory.addPlayerReply("studying :(");
        newStory.addReply("so that’s what they call porn now? :p");
        newStory.addPlayerReply("annie wtf!!!");
        newStory.addReply("not denying it? :p");
        newStory.addPlayerReply("I still can’t believe what johnny did today!!");
        newStory.addReply("me neither.. that boy has issues..");
        newStory.addReply("wtf the winds so loud.. that doesn’t seem normal lol");
        newStory.addPlayerReply("No wind over here. Just rain.");
        newStory.addReply("Lucky you. i need my beauty sleep! :p");
        newStory.addPlayerReply("Damn right you do ;)");
        newStory.addReply("what? you mean i look");
        newStory.addReply("wait, shit i think i heard footsteps on the gravel outside");
        newStory.addPlayerReply("Get your crazy dad to check it out :p");
        newStory.addReply("i'm home alone! the fam are on holiday remember? i told you this!");
        newStory.addPlayerReply("Really? Till when? We should hang out :D");
        newStory.addReply("they really sound like footsteps but theres something odd about them.. I should look out the window but my bed is so warm!!");
        newStory.addPlayerReply("Sure you wanna look out the window when you're alone? What if there really is someone there in your garden, looking up at you? :p");
        newStory.addReply("NOT FUNNY " + playerName.toUpperCase());
        newStory.addPlayerReply("wow chill.. I'm sure it's nothing");
        newStory.addReply("gonna check brb");
        newStory.addPlayerReply("If there's somethin' strange in your neighborhood");
        newStory.addPlayerReply("Who ya gonna call?");
        newStory.addReply(playerName + " theres someone in the garden!!!");
        newStory.addPlayerReply("What really?");
        newStory.addReply("YES. i can see a mans back...");
        newStory.addPlayerReply("What's he doing?");
        newStory.addReply("he's... looking for something? on his hands and knees in the bushes...");
        newStory.addPlayerReply("haha he must be high.. probably looking for his drugs :p");
        newStory.addReply(playerName + " this is serious! what should i do??");
        newStory.addPlayerReply("nothing? He'll probably go away by himself :)");
        newStory.addReply("omg now he's digging with his bare hands.. hes ruining the garden!");
        newStory.addReply("shit hes turning around");
        newStory.addPlayerReply("What does he look like?");
        newStory.addReply(playerName.toUpperCase() + " WTF THIS ISN'T FUNNY");
        newStory.addPlayerReply("What??");
        newStory.addReply("HOW ARE YOU DOING THAT?");
        newStory.addPlayerReply("What are you talking about??");
        newStory.addReply("i can see that its you! in my garden! how are you writing here without touching your phone? look up! i'm by the window can't you hear me banging on it?");
        newStory.addPlayerReply("Fuck annie now you're scaring me too.. I'm definitely not in your garden. That's not me.");
        newStory.addReply("STOP PLAYING AROUND. i can see your face. and youre wearing that stupid football jacket your so proud of!");
        newStory.addPlayerReply("it must be someone who looks like me.. honestly annie I'm at home. I wouldn't play around like that.. :)");
        newStory.addReply("it has to be a friend of yours " + playerName + ".. playing a sick prank.. how else could he be wearing your jacket??");
        newStory.addPlayerReply("there are loads of jackets like that! my friends don't look anything like me... you just have me on your mind ;)");
        newStory.addReply("hes digging again");
        newStory.addReply("fucking leave already!!!");
        newStory.addPlayerReply("annie, do you have a gun in your house?");
        newStory.addReply("dont be stupid " + playerName + ". i couldnt shoot anyone.");
        newStory.addPlayerReply("you don't have to use it. just show that you're carrying.");
        newStory.addReply("doesn't that jacket have your name on the back?");
        newStory.addPlayerReply("yeah the team all got one with their name on");
        newStory.addReply("i can see your fucking name!!!");
        newStory.addPlayerReply("what");
        newStory.addReply("WHAT THE HELL IS THIS " + playerName);
        newStory.addPlayerReply("Annie that jackets in my closet...");
        newStory.addReply("FUCK HES SEEN ME");
        newStory.addReply("WHY IS HE SMILING LIKE THAT");
        newStory.addReply("HES COMING");
        newStory.addPlayerReply("CALL THE COPS!!!");
        newStory.addPlayerReply("ANNIE?!");
        newStory.addPlayerReply("ANNIE REPLY!!!");
        newStory.addPlayerReply("i've called the cops, told them theres a break-in attempt at your place. they said they're on their way but it'll take about half an hour");
        newStory.addPlayerReply("annie are you there?");
        newStory.addReply("its in the house. cant talk i have to be quiet. lights off. im in a closet with a knife. hard to type shaking too much");
        newStory.addPlayerReply("fuck fuck hang in there annie the police will be there soon.. do you know where he is?");
        newStory.addReply("IT. not he. the look it had when it saw me " + playerName + ".. no person could look like that..");
        newStory.addPlayerReply("jesus christ does it know where you are?");
        newStory.addReply("no i grabbed the knife when i saw it running toward the house and i got in the closet when i heard it breaking in");
        newStory.addPlayerReply("ok good you'll be fine.. a druggie doesn't have the brains to find someone hiding in the closet.. the police will be there soon!");
        newStory.addReply("oh god its calling out to me");
        newStory.addReply("it doesnt sound like you " + playerName);
        newStory.addReply("its voice is so deep");
        newStory.addReply("filling the house");
        newStory.addReply("filling my head");
        newStory.addPlayerReply("what is it saying");
        newStory.addReply("\"come out annie.\"");
        newStory.addReply("\"i just want to look at you\"");
        newStory.addReply("it keeps repeating that over and over");
        newStory.addReply("have i gone mad " + playerName + "?");
        newStory.addReply("is this what that feels like?");
        newStory.addPlayerReply("just a few more minutes annie! keep it together! you are so strong you will get through this!");
        newStory.addReply("its coming up the stairs but so.. slowly.. irregular steps");
        newStory.addReply("why does it look like you " + playerName + "? why you??");
        newStory.addPlayerReply("i don't know annie!! please believe me");
        newStory.addReply("can you make it stop?");
        newStory.addReply("please make it stop?");
        newStory.addPlayerReply("i would if i could i promise you");
        newStory.addReply("its at the end of the hall");
        newStory.addReply(playerName + " i didnt say anything to my parents when they left");
        newStory.addReply("i was listening to music");
        newStory.addReply("is that the last time i see them?");
        newStory.addPlayerReply("annie");
        newStory.addReply("this has something to do with you " + playerName.toUpperCase() + ".. only you can make it stop.. think fast..");
        newStory.addPlayerReply("I DONT KNOW ANNIE GOD PLEASE");
        newStory.addReply("please...");
        newStory.addPlayerReply("it might be... because i think about you so much");
        newStory.addPlayerReply("i think about you all the time");
        newStory.addReply("so stop.");
        newStory.addPlayerReply("i dont know how");
        newStory.addReply("its scraping something on the walls getting closer.. please " + playerName + "...");
        newStory.addPlayerReply("im trying. im trying so hard");
        newStory.addReply("It's slowing down. Try harder.");
        newStory.addReply("Whatever you're doing, it's working.");
        newStory.addReply("It's stopped. I can't hear anything.");
        newStory.addPlayerReply("really?? don't go out yet! stay put until the police get there!");
        newStory.addReply("What should I tell them if he's gone?");
        newStory.addPlayerReply("EVERYTHING annie EVERYTHING you told me!");
        newStory.addReply("I didn't know you felt that way about me, " + playerName + " :)");
        newStory.addPlayerReply("im so glad its stopped");
        newStory.addReply("Can you come over in the morning " + playerName + "? I really need to see you :)");
        newStory.addPlayerReply("of course annie i'll be there");
        newStory.addReply("Great! Can't wait!");
        newStory.addPlayerReply("annie...");
        newStory.addPlayerReply("annie how do i know this is you?");
        newStory.completeStoryBuild();
    }
}