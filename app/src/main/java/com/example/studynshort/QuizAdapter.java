package com.example.studynshort;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<com.example.studynshort.QuizAdapter.ViewHolder> {

    private List<QuizModel> QuizList;
    Context context;



    public QuizAdapter(List<QuizModel> QuizList, Context context) {
        this.QuizList = QuizList;
        this.context = context;
    }



    @NonNull
    @Override
    public com.example.studynshort.QuizAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_card, parent, false);
        return new com.example.studynshort.QuizAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.studynshort.QuizAdapter.ViewHolder holder, int position) {

        holder.setData(QuizList.get(position).getUrl(), QuizList.get(position).getTitle(), QuizList.get(position).getDesp());

    }

    @Override
    public int getItemCount() {
        return QuizList.size();
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

        public void setData(String resource, String title, String description) {
            Glide.with(itemView.getContext()).load(resource).into(imageView);
            this.textView.setText(title);
            this.textView2.setText(description);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), QuizOptionActivity.class);
                    intent.putExtra("title", title);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}


