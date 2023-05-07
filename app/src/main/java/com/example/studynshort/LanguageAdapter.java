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

    public class LanguageAdapter extends RecyclerView.Adapter<com.example.studynshort.LanguageAdapter.ViewHolder> {

        private List<ModelClass> lanList;
        Context context;


        public LanguageAdapter(List<ModelClass> lanList, Context context) {
            this.lanList = lanList;
            this.context = context;
        }



        @NonNull
        @Override
        public com.example.studynshort.LanguageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.languagecard, parent, false);
            return new com.example.studynshort.LanguageAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.studynshort.LanguageAdapter.ViewHolder holder, int position) {
            final ModelClass temp = lanList.get(position);
            int resource = lanList.get(position).getImageview1();
            String title = lanList.get(position).getTextview1();
            String description = lanList.get(position).getTextview2();
            String url = lanList.get(position).getSendUrl();


            holder.setData(resource, title, description, url);

            holder.language_card.setOnClickListener(new View.OnClickListener() {
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
            return lanList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            private ImageView imageView;
            private TextView textView;
            private TextView textView2, textView3;
            CardView language_card;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.web_image);
                textView = itemView.findViewById(R.id.web_title);
                textView2 = itemView.findViewById(R.id.web_desp);

                textView3 =  itemView.findViewById(R.id.web_url);
                language_card = itemView.findViewById(R.id.language_card);
                language_card.setNestedScrollingEnabled(false);

            }

            public void setData(int resource, String title, String description, String url) {
                imageView.setImageResource(resource);
                textView.setText(title);
                textView2.setText(description);
                textView3.setText(url);
            }
        }
    }


