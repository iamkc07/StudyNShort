package com.example.studynshort;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DatabaseAdapter extends RecyclerView.Adapter<com.example.studynshort.DatabaseAdapter.ViewHolder> {

    private List<ModelClass> databaseList;


    public DatabaseAdapter(List<ModelClass> databaseList) {
        this.databaseList = databaseList;
    }



    @NonNull
    @Override
    public com.example.studynshort.DatabaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.databasecard, parent, false);
        return new com.example.studynshort.DatabaseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.studynshort.DatabaseAdapter.ViewHolder holder, int position) {

        int resource = databaseList.get(position).getImageview1();
        String title = databaseList.get(position).getTextview1();

        holder.setData(resource, title);
    }

    @Override
    public int getItemCount() {
        return databaseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.web_image);
            textView = itemView.findViewById(R.id.web_title);





        }

        public void setData(int resource, String title) {
            imageView.setImageResource(resource);
            textView.setText(title);

        }
    }
}


