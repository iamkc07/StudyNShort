package com.example.studynshort;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubItemAdapter extends RecyclerView.Adapter<SubItemAdapter.SubItemViewHolder> {

    private List<SubItem> subItemList;
    private  List<Item> itemList;
    Context context;

    SubItemAdapter(List<SubItem> subItemList) {
        this.subItemList = subItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public SubItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_item, viewGroup, false);
        return new SubItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemViewHolder subItemViewHolder, int position) {
        SubItem subItem = subItemList.get(position);
        subItemViewHolder.subTitle.setText(subItem.getSubItemTitle());
        subItemViewHolder.subDesp.setText(subItem.getSubItemDesc());
        subItemViewHolder.suburl.setText(subItem.getSubItemUrl());
        subItemViewHolder.imageR.setImageResource(subItem.getSubItemImage());

        subItemViewHolder.subCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return subItemList.size();
    }

    class SubItemViewHolder extends RecyclerView.ViewHolder {
        TextView subTitle, subDesp, suburl;
        ImageView imageR;

        CardView subCard;

        SubItemViewHolder(View itemView) {
            super(itemView);
            subTitle = itemView.findViewById(R.id.subTitle);
            subDesp = itemView.findViewById(R.id.subDesp);
            suburl = itemView.findViewById(R.id.subUrl);
            imageR = itemView.findViewById(R.id.subImage);
            subCard = itemView.findViewById(R.id.subCardView);

        }

    }
}
