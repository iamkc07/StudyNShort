package com.example.studynshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BcaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<SubjectModel> sList;
    private BcaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca);

        recyclerView = findViewById(R.id.bca_view);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));

       sList = new ArrayList<>();

        List<String> nestedList1 = new ArrayList<>();
        nestedList1.add("Jams and Honey");
        nestedList1.add("Pickles and Chutneys");
        nestedList1.add("Readymade Meals");
        nestedList1.add("Chyawanprash and Health Foods");

        List<String> nestedList2 = new ArrayList<>();
        nestedList2.add("Book");
        nestedList2.add("Pen");
        nestedList2.add("Office Chair");
        nestedList2.add("Pencil");

        List<String> nestedList3 = new ArrayList<>();
        nestedList3.add("Decorates");
        nestedList3.add("Tea Table");
        nestedList3.add("Wall Paint");
        nestedList3.add("Furniture");

        sList.add(new SubjectModel(nestedList1 , "Instant Food and Noodles"));
        sList.add(new SubjectModel( nestedList2,"Stationary"));
        sList.add(new SubjectModel( nestedList3,"Home Care"));

        adapter = new BcaAdapter(sList);
        recyclerView.setAdapter(adapter);
    }
}