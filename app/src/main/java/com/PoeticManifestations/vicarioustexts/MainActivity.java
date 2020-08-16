package com.PoeticManifestations.vicarioustexts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    //View Component Variables
    MaterialToolbar toolbar;
    RecyclerView messageRecyclerView;
    EditText messageInput;
    ImageButton sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize all view components
        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
        messageRecyclerView = findViewById(R.id.messageRecyclerView);
        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);

    }
}