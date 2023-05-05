package com.example.studynshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BcaNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca_notes);

        RecyclerView Item = findViewById(R.id.bca_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(BcaNotesActivity.this);
        ItemAdapter itemAdapter = new ItemAdapter(ItemList());
        Item.setAdapter(itemAdapter);
        Item.setLayoutManager(layoutManager);


    }

    private List<Item> ItemList() {
        List<Item> itemList = new ArrayList<>();

        itemList.add(new Item("Semeter I", SubItemList()));


        return itemList;
    }

    private List<SubItem> SubItemList() {
        List<SubItem> subItem = new ArrayList<>();

        SubItem item = new SubItem(R.drawable.html, "Html", "Download Notes", "download");
        SubItem item1 = new SubItem(R.drawable.css, "Css", "Download Notes", "download");

        subItem.add(item);
        subItem.add(item1);


        return subItem;
    }

//    private List<SubItem> SubItemList1() {
//        List<SubItem> subItem = new ArrayList<>();
//
//        SubItem item = new SubItem(R.drawable.html, "Html1", "Download Notes", "download");
//        SubItem item1 = new SubItem(R.drawable.css, "Css1", "Download Notes", "download");
//
//        subItem.add(item);
//        subItem.add(item1);
//
//
//        return subItem;
//    }
}