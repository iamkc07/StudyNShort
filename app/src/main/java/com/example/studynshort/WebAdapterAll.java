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

public class WebAdapterAll extends RecyclerView.Adapter<WebAdapterAll.ViewHolder> {

    private List<ModelClass> webList;
    Context context;


    public WebAdapterAll(List<ModelClass> webList, Context context) {
        this.webList = webList;
        this.context = context;
    }


    @NonNull
    @Override
    public WebAdapterAll.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.webcardall, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ModelClass temp = webList.get(position);
        int resource = webList.get(position).getImageview1();
        String title = webList.get(position).getTextview1();
        String description = webList.get(position).getTextview2();
        String url = webList.get(position).getSendUrl();

        holder.setData(resource, title, description, url);
        holder.webcardall.setOnClickListener(new View.OnClickListener() {
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
        return webList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private TextView textView2;
        private TextView textView3;

        CardView webcardall;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.web_image);
            textView = itemView.findViewById(R.id.web_title);
            textView2 = itemView.findViewById(R.id.web_desp);
            textView3 =  itemView.findViewById(R.id.web_url);
            webcardall = itemView.findViewById(R.id.webcardall);
            webcardall.setNestedScrollingEnabled(false);


        }

        public void setData(int resource, String title, String description, String url) {
            imageView.setImageResource(resource);
            textView.setText(title);
            textView2.setText(description);
            textView3.setText(url);
        }
    }

}
