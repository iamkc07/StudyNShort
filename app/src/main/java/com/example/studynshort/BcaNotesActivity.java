package com.example.studynshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class BcaNotesActivity extends AppCompatActivity {

    RecyclerView semViewI;

    RelativeLayout relativeLayoutI, relativeLayoutII, relativeLayoutIII, relativeLayoutIV, relativeLayoutV, relativeLayoutVI;

    LinearLayout linearLayoutI, linearLayoutII, linearLayoutIII, linearLayoutIV, linearLayoutV, linearLayoutVI;
    LinearLayoutManager layoutManager;
    List<ModelClass> semBcaList;
    SemAdapterI semAdapterI;


    RecyclerView semViewII;
    List<ModelClass>semBcaListII;
    SemAdapterII semAdapterII;

    RecyclerView semViewIII;
    List<ModelClass>semBcaListIII;
    SemAdapterIII semAdapterIII;

    RecyclerView semViewIV;
    List<ModelClass>semBcaListIV;
    SemAdapterIV semAdapterIV;

    RecyclerView semViewV;
    List<ModelClass>semBcaListV;
    SemAdapterV semAdapterV;

    RecyclerView semViewVI;
    List<ModelClass>semBcaListVI;
    SemAdapterVI semAdapterVI;

  ImageView semIArrow, semIIArrow, semIIIArrow, semIVArrow, semVArrow, semVIArrow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca_notes);

        linearLayoutI = findViewById(R.id.linearLayoutI);
        linearLayoutII = findViewById(R.id.linearLayoutII);
        linearLayoutIII = findViewById(R.id.linearLayoutIII);
        linearLayoutIV = findViewById(R.id.linearLayoutIV);
        linearLayoutV = findViewById(R.id.linearLayoutV);
        linearLayoutVI = findViewById(R.id.linearLayoutVI);


        relativeLayoutI = findViewById(R.id.relativeLayoutI);
        relativeLayoutII = findViewById(R.id.relativeLayoutII);
        relativeLayoutIII = findViewById(R.id.relativeLayoutIII);
        relativeLayoutIV = findViewById(R.id.relativeLayoutIV);
        relativeLayoutV = findViewById(R.id.relativeLayoutV);
        relativeLayoutVI = findViewById(R.id.relativeLayoutVI);

        semIArrow = findViewById(R.id.semIArrow);
        semIIArrow = findViewById(R.id.semIIArrow);
        semIIIArrow = findViewById(R.id.semIIIArrow);
        semIVArrow = findViewById(R.id.semIVArrow);
        semVArrow = findViewById(R.id.semVArrow);
        semVIArrow = findViewById(R.id.semVIArrow);

        relativeLayoutI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutI.getVisibility() == View.GONE) {
                    linearLayoutI.setVisibility(View.VISIBLE);
                    semIArrow.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                } else {
                    linearLayoutI.setVisibility(View.GONE);
                    semIArrow.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }
            }
        });
        relativeLayoutII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutII.getVisibility() == View.GONE) {
                    linearLayoutII.setVisibility(View.VISIBLE);
                    semIIArrow.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                } else {
                    linearLayoutII.setVisibility(View.GONE);
                    semIIArrow.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }
            }
        });
        relativeLayoutIII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutIII.getVisibility() == View.GONE) {
                    linearLayoutIII.setVisibility(View.VISIBLE);
                    semIIIArrow.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                } else {
                    linearLayoutIII.setVisibility(View.GONE);
                    semIIIArrow.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }
            }
        });
        relativeLayoutIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutIV.getVisibility() == View.GONE) {
                    linearLayoutIV.setVisibility(View.VISIBLE);
                    semIVArrow.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                } else {
                    linearLayoutIV.setVisibility(View.GONE);
                    semIVArrow.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }
            }
        });
        relativeLayoutV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutV.getVisibility() == View.GONE) {
                    linearLayoutV.setVisibility(View.VISIBLE);
                    semVArrow.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                } else {
                    linearLayoutV.setVisibility(View.GONE);
                    semVArrow.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }
            }
        });
        relativeLayoutVI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutVI.getVisibility() == View.GONE) {
                    linearLayoutVI.setVisibility(View.VISIBLE);
                    semVIArrow.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                } else {
                    linearLayoutVI.setVisibility(View.GONE);
                    semVIArrow.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }
            }
        });







        initData();
        initRecycleView();
    }



    private void initData() {

        semBcaList = new ArrayList<>();
        semBcaList.add(new ModelClass(R.drawable.html,"Html","ssss-sss", "https://www.africau.edu/images/default/sample.pdf"));
        semBcaList.add(new ModelClass(R.drawable.css,"Html","Dow-ml", "kkk"));


        semBcaListII = new ArrayList<>();
        semBcaListII.add(new ModelClass(R.drawable.html,"Html","ssss-sss", "https://www.africau.edu/images/default/sample.pdf"));
        semBcaListII.add(new ModelClass(R.drawable.css,"Html","Dow-ml", "kkk"));

        semBcaListIII = new ArrayList<>();
        semBcaListIII.add(new ModelClass(R.drawable.html,"Html","ssss-sss", "https://www.africau.edu/images/default/sample.pdf"));
        semBcaListIII.add(new ModelClass(R.drawable.css,"Html","Dow-ml", "kkk"));

        semBcaListIV = new ArrayList<>();
        semBcaListIV.add(new ModelClass(R.drawable.html,"Html","ssss-sss", "https://www.africau.edu/images/default/sample.pdf"));
        semBcaListIV.add(new ModelClass(R.drawable.css,"Html","Dow-ml", "kkk"));
        semBcaListIV.add(new ModelClass(R.drawable.css,"Html ","Dow-ml", "kkk"));

        semBcaListV = new ArrayList<>();
        semBcaListV.add(new ModelClass(R.drawable.html,"Html","ssss-sss", "https://www.africau.edu/images/default/sample.pdf"));
        semBcaListV.add(new ModelClass(R.drawable.css,"Html","Dow-ml", "kkk"));

        semBcaListVI = new ArrayList<>();
        semBcaListVI.add(new ModelClass(R.drawable.html,"Html","ssss-sss", "https://www.africau.edu/images/default/sample.pdf"));
        semBcaListVI.add(new ModelClass(R.drawable.css,"Html","Dow-ml", "kkk"));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initRecycleView() {
        semViewI = findViewById(R.id.semIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewI.setLayoutManager(layoutManager);
        semAdapterI = new SemAdapterI(semBcaList, getApplicationContext());
        semViewI.setAdapter(semAdapterI);
        semAdapterI.notifyDataSetChanged();

        semViewII = findViewById(R.id.semIIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewII.setLayoutManager(layoutManager);
        semAdapterII = new SemAdapterII(semBcaListII, getApplicationContext());
        semViewII.setAdapter(semAdapterII);
        semAdapterII.notifyDataSetChanged();


        semViewIII = findViewById(R.id.semIIIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewIII.setLayoutManager(layoutManager);
        semAdapterIII = new SemAdapterIII(semBcaListIII, getApplicationContext());
        semViewIII.setAdapter(semAdapterIII);
        semAdapterIII.notifyDataSetChanged();

        semViewIV = findViewById(R.id.semIVView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewIV.setLayoutManager(layoutManager);
        semAdapterIV = new SemAdapterIV(semBcaListIV, getApplicationContext());
        semViewIV.setAdapter(semAdapterIV);
        semAdapterIV.notifyDataSetChanged();

        semViewV = findViewById(R.id.semVView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewV.setLayoutManager(layoutManager);
        semAdapterV = new SemAdapterV(semBcaListV, getApplicationContext());
        semViewV.setAdapter(semAdapterV);
        semAdapterV.notifyDataSetChanged();

        semViewVI = findViewById(R.id.semVIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewVI.setLayoutManager(layoutManager);
        semAdapterVI = new SemAdapterVI(semBcaListVI, getApplicationContext());
        semViewVI.setAdapter(semAdapterVI);
        semAdapterVI.notifyDataSetChanged();


    }
}