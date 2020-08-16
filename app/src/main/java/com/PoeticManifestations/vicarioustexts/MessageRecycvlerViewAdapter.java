package com.PoeticManifestations.vicarioustexts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageRecycvlerViewAdapter extends RecyclerView.Adapter<MessageRecycvlerViewAdapter.ViewHolder>{
    private Context context;
    private ArrayList<String> story;

    public MessageRecycvlerViewAdapter(Context context, ArrayList<String> story) {
        this.context = context;
        this.story = story;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setMessages(){

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public void addMessage(String message, boolean isPlayer){
        story.add(message);
    }
}
