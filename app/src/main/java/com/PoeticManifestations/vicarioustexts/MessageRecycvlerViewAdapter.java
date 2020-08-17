package com.PoeticManifestations.vicarioustexts;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageRecycvlerViewAdapter extends RecyclerView.Adapter<MessageRecycvlerViewAdapter.ViewHolder>{
    private Context context;
    private ArrayList<StoryMessage> story;

    public MessageRecycvlerViewAdapter(Context context) {
        this.context = context;
        this.story = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.message_list_view, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoryMessage message = story.get(position);
        if (message.isPlayerMessage()){
            holder.messageviewParentLayout.setHorizontalGravity(Gravity.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams. MATCH_PARENT ,
                    LinearLayout.LayoutParams. WRAP_CONTENT ) ;
            layoutParams.setMargins( 150,0,0,0 );
            holder.messageviewParentLayout.setLayoutParams(layoutParams);
            holder.messageViewLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.user_text));
        } else {
            holder.messageviewParentLayout.setHorizontalGravity(Gravity.START);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams. MATCH_PARENT ,
                    LinearLayout.LayoutParams. WRAP_CONTENT ) ;
            layoutParams.setMargins( 0,0, 150,0 );
            holder.messageviewParentLayout.setLayoutParams(layoutParams);
            holder.messageViewLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.bot_text));
        }
        holder.messageViewTime.setText(message.getTimeStamp());
        holder.messageViewMessage.setText(message.getText());
    }

    @Override
    public int getItemCount() {
        return story.size();
    }

    public void setMessages(){

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView messageViewMessage, messageViewTime;
        LinearLayout messageViewLayout, messageviewParentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            messageViewMessage = itemView.findViewById(R.id.messageViewMessage);
            messageViewTime = itemView.findViewById(R.id.messageViewTime);
            messageViewLayout = itemView.findViewById(R.id.messageViewLayout);
            messageviewParentLayout = itemView.findViewById(R.id.messageViewParentLayout);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public void addMessage(StoryMessage message){
        story.add(message);
        notifyItemChanged(story.size());
    }

    private int dpToPx(int dp){
        float scale = context.getResources().getDisplayMetrics().density;
        int px = (int) (dp / scale + 0.5f);
        return px;
    }
}
