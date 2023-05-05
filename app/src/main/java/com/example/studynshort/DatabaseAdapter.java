package com.example.studynshort;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DatabaseAdapter extends RecyclerView.Adapter<com.example.studynshort.DatabaseAdapter.ViewHolder> {

    private List<ModelClass> databaseList;
    Context context;

    public DatabaseAdapter(List<ModelClass> databaseList, Context context) {
        this.databaseList = databaseList;
        this.context = context;
    }

    @NonNull
    @Override
    public com.example.studynshort.DatabaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.databasecard, parent, false);
        return new com.example.studynshort.DatabaseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.studynshort.DatabaseAdapter.ViewHolder holder, int position) {

        final ModelClass temp = databaseList.get(position);
        int resource = databaseList.get(position).getImageview1();
        String title = databaseList.get(position).getTextview1();
        String description = databaseList.get(position).getTextview2();
        String url = databaseList.get(position).getSendUrl();


        holder.setData(resource, title, description, url);
        holder.databaseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("imageView", temp.getImageview1());
                intent.putExtra("textview", temp.getTextview1());
                intent.putExtra("textview1", temp.getTextview2());
                intent.putExtra("url", temp.getSendUrl());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return databaseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        private TextView textView2, textView3;
        CardView databaseCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.web_image);
            textView = itemView.findViewById(R.id.web_title);
            textView2 = itemView.findViewById(R.id.web_desp);

            textView3 =  itemView.findViewById(R.id.web_url);
            databaseCard = itemView.findViewById(R.id.database_card);
            databaseCard.setNestedScrollingEnabled(false);


        }


        public void setData(int resource, String title, String description, String url) {
            imageView.setImageResource(resource);
            textView.setText(title);
            textView2.setText(description);
            textView3.setText(url);
        }
    }
}


