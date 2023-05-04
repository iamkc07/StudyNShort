package com.example.studynshort;

import android.content.Intent;
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

public class BcaAdapter extends RecyclerView.Adapter<BcaAdapter.ItemVeiwHolder> {

    private List<SubjectModel> sList;
    private List<String> list;
    public BcaAdapter(List<SubjectModel> sList){
        this.sList = sList;
    }
    @NonNull
    @Override
    public ItemVeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bca_item, parent, false);
        return new ItemVeiwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVeiwHolder holder, int position) {
        SubjectModel model = sList.get(position);
        holder.stxt.setText((model.getItemText()));

        boolean isExpandable = model.isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        if(isExpandable){
            holder.sarrow.setImageResource(R.drawable.baseline_arrow_drop_up_24);
        }else {
            holder.sarrow.setImageResource(R.drawable.baseline_arrow_drop_down_24);
        }

        NestedAdapter adapter = new NestedAdapter(list);
        holder.nestedView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.nestedView.setHasFixedSize(true);
        holder.nestedView.setAdapter(adapter);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setExpandable(!model.isExpandable());
                list = model.getNestedList();
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

    public class ItemVeiwHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private RelativeLayout expandableLayout;
        private TextView stxt;
        private ImageView sarrow;

        private RecyclerView nestedView;
        public ItemVeiwHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            stxt = itemView.findViewById(R.id.sub_title);
            sarrow =  itemView.findViewById(R.id.sub_arrow);
            nestedView =  itemView.findViewById(R.id.bca_childview);

        }
    }
}
