package com.example.studynshort;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.NestedViewHolder> {

    private List<String> sList;
   

    public NestedAdapter(List<String> sList) {
        this.sList = sList;
    }

    @NonNull
    @Override
    public NestedAdapter.NestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bca_nested, parent, false);
        return new NestedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedAdapter.NestedViewHolder holder, int position) {
    holder.sub_txt.setText(sList.get(position));


    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

    public class NestedViewHolder extends RecyclerView.ViewHolder {
        private TextView sub_txt;
        public NestedViewHolder(@NonNull View itemView) {
            super(itemView);
            sub_txt = itemView.findViewById(R.id.nested_title);
        }
    }
}