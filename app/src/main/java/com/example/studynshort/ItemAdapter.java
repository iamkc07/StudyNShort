package com.example.studynshort;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<Item> itemList;
    private List<SubItem> subItemList;
    SubItemAdapter subItemAdapter;

    ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ItemViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        Item item = itemList.get(position);
        itemViewHolder.itemTitle.setText(item.getItemTitle());

        boolean isExpandable = item.isExpandable();
        itemViewHolder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        if(isExpandable){
            itemViewHolder.sarrow.setImageResource(R.drawable.baseline_arrow_drop_up_24);
        }else {
            itemViewHolder.sarrow.setImageResource(R.drawable.baseline_arrow_drop_down_24);
        }

        itemViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setExpandable(!item.isExpandable());
                subItemList = item.getSubItemList();
                notifyItemChanged(position);
            }
        });
        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                itemViewHolder.subView.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(item.getSubItemList().size());

        // Create sub item view adapter
        subItemAdapter = new SubItemAdapter(item.getSubItemList());

        itemViewHolder.subView.setLayoutManager(layoutManager);
        itemViewHolder.subView.setAdapter(subItemAdapter);
        itemViewHolder.subView.setRecycledViewPool(viewPool);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private RecyclerView subView;

        private ImageView sarrow;

        private LinearLayout linearLayout;
        private RelativeLayout expandableLayout;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            subView = itemView.findViewById(R.id.itemview);
            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            sarrow = itemView.findViewById(R.id.ItemArrow);
        }
    }
}