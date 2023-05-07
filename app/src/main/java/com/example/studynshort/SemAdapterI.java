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

public class SemAdapterI extends RecyclerView.Adapter<SemAdapterI.ViewHolder> {

    private List<ModelClass> semList;
    Context context;

    public SemAdapterI(List<ModelClass> semList, Context context) {
        this.semList = semList;
        this.context = context;
    }

    @NonNull
    @Override
    public SemAdapterI.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SemAdapterI.ViewHolder holder, int position) {

        final ModelClass temp = semList.get(position);
        int resource = semList.get(position).getImageview1();
        String title = semList.get(position).getTextview1();
        String description = semList.get(position).getTextview2();
        String url = semList.get(position).getSendUrl();

        holder.setData(resource, title, description, url);

        holder.semCard.setOnClickListener(new View.OnClickListener() {
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
        return semList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private TextView textView2, textView3;


        CardView semCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.subIImage);
            textView = itemView.findViewById(R.id.subITitle);
            textView2 = itemView.findViewById(R.id.subIDesp);
            textView3 =  itemView.findViewById(R.id.subIUrl);

            semCard = itemView.findViewById(R.id.subCardView);
            semCard.setNestedScrollingEnabled(false);

        }

        public void setData(int resource, String title, String description, String url) {
            imageView.setImageResource(resource);
            textView.setText(title);
            textView2.setText(description);
            textView3.setText(url);
        }
    }
}
