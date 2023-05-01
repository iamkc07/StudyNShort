package com.example.studynshort;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class LanguageAdapter extends RecyclerView.Adapter<com.example.studynshort.LanguageAdapter.ViewHolder> {

        private List<ModelClass> lanList;


        public LanguageAdapter(List<ModelClass> lanList) {
            this.lanList = lanList;
        }



        @NonNull
        @Override
        public com.example.studynshort.LanguageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.languagecard, parent, false);
            return new com.example.studynshort.LanguageAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.studynshort.LanguageAdapter.ViewHolder holder, int position) {

            int resource = lanList.get(position).getImageview1();
            String title = lanList.get(position).getTextview1();
            String description = lanList.get(position).getTextview2();

            holder.setData(resource, title, description);
        }

        @Override
        public int getItemCount() {
            return lanList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            private ImageView imageView;
            private TextView textView;
            private TextView textView2;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.web_image);
                textView = itemView.findViewById(R.id.web_title);
                textView2 = itemView.findViewById(R.id.web_desp);




            }

            public void setData(int resource, String title, String description) {
                imageView.setImageResource(resource);
                textView.setText(title);
                textView2.setText(description);
            }
        }
    }


