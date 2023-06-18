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

public class BscNotesActivity extends AppCompatActivity {

    RecyclerView semViewI;

    RelativeLayout relativeLayoutI, relativeLayoutII, relativeLayoutIII, relativeLayoutIV, relativeLayoutV, relativeLayoutVI;

    LinearLayout linearLayoutI, linearLayoutII, linearLayoutIII, linearLayoutIV, linearLayoutV, linearLayoutVI;
    LinearLayoutManager layoutManager;
    List<ModelClass> semBscList;
    SemAdapterI semAdapterI;


    RecyclerView semViewII;
    List<ModelClass>semBscListII;
    SemAdapterII semAdapterII;

    RecyclerView semViewIII;
    List<ModelClass>semBscListIII;
    SemAdapterIII semAdapterIII;

    RecyclerView semViewIV;
    List<ModelClass>semBscListIV;
    SemAdapterIV semAdapterIV;

    RecyclerView semViewV;
    List<ModelClass>semBscListV;
    SemAdapterV semAdapterV;

    RecyclerView semViewVI;
    List<ModelClass>semBscListVI;
    SemAdapterVI semAdapterVI;

    ImageView semIArrow, semIIArrow, semIIIArrow, semIVArrow, semVArrow, semVIArrow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsc_notes);

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

        semBscList = new ArrayList<>();
        semBscList.add(new ModelClass(R.drawable.html,"Computer Science One","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FComputerScienceOne_removed_compressed.pdf?alt=media&token=932d8f79-86f9-4f4e-b6bf-d34b42e8358e"));
        semBscList.add(new ModelClass(R.drawable.css,"Environmental Science","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FEnvironmental%20Sciences_removed_compressed.pdf?alt=media&token=fa475c05-2bb9-49c0-b153-371834cd367e"));
        semBscList.add(new ModelClass(R.drawable.css,"Foundation Course in Mathematics","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FFoundation%20Course%20in%20Mathematics_removed_compressed.pdf?alt=media&token=41c78fb1-f6d7-4aed-bb65-bccf6a9be501"));
        semBscList.add(new ModelClass(R.drawable.css,"Functional English-I","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FFunctional%20English%20-%20I_removed_compressed.pdf?alt=media&token=2425bd3e-74ab-43d1-b380-16617238c1ae"));
        semBscList.add(new ModelClass(R.drawable.css,"Introduction of Digital Electronic","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FIntroduction%20to%20Digital%20Electronic_compressed.pdf?alt=media&token=84b3d61a-f4f4-48c5-b471-fe3ea05c78d8"));


        semBscListII = new ArrayList<>();
        semBscListII.add(new ModelClass(R.drawable.html,"Computer Organization","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FComputer%20Organization_removed_compressed.pdf?alt=media&token=a73ae19f-ecc7-4647-a7e1-6a4e2e6fa499"));
        semBscListII.add(new ModelClass(R.drawable.css,"Discrete Mathematics","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FDiscrete%20Mathematics_removed_compressed.pdf?alt=media&token=d84c62ad-21a1-4820-be6c-2a4bb8fadee6"));
        semBscListII.add(new ModelClass(R.drawable.css,"Front Office Management","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FFront%20Office%20Management_removed_compressed.pdf?alt=media&token=9ced3ebf-c27f-4cf6-bd59-5cacf5404c90"));
        semBscListII.add(new ModelClass(R.drawable.css,"Fundamental of Open Source Software-LINUX","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FFundamental%20of%20Open%20Source%20Software-LINUX_removed_compressed.pdf?alt=media&token=b7a94464-cfa3-4136-862f-c6338cc02bd3"));
        semBscListII.add(new ModelClass(R.drawable.css,"Value and Ethics","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FValue%20and%20Ethics_removed_compressed.pdf?alt=media&token=a02c0e61-28fb-4da6-b289-4f16669cbb1c"));

        semBscListIII = new ArrayList<>();
        semBscListIII.add(new ModelClass(R.drawable.html,"Analytical Skill Development-I","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FAnalytical%20Skill%20Development-I_removed_compressed.pdf?alt=media&token=9846fea5-97cc-4e9e-8516-0533eb965b29"));
        semBscListIII.add(new ModelClass(R.drawable.css,"Introduction to Data Structure","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FIntroduction%20to%20Data%20Structures_removed_compressed.pdf?alt=media&token=e01a80b9-6a83-4ab7-bf97-18adc03ee776"));
        semBscListIII.add(new ModelClass(R.drawable.css,"Object-Oriented Programming Using C++","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FIntroduction%20to%20Data%20Structures_removed_compressed.pdf?alt=media&token=e01a80b9-6a83-4ab7-bf97-18adc03ee776"));
        semBscListIII.add(new ModelClass(R.drawable.css,"Operating System Concept","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FOperating%20Systems%20Concepts_removed_compressed.pdf?alt=media&token=38fb2dcc-e8a8-46fe-9ffd-2574b5104035"));
        semBscListIII.add(new ModelClass(R.drawable.css,"System Analysis and Design","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FSystem%20Analysis%20and%20Design_removed_compressed.pdf?alt=media&token=fa3caa4f-08a0-4bce-88e1-d53536069910"));
        semBscListIII.add(new ModelClass(R.drawable.css,"Technical Writing","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FTechnical%20Writing_removed_compressed.pdf?alt=media&token=dc22e76d-f046-443a-b9ec-db3031fe488f"));

        semBscListIV = new ArrayList<>();
        semBscListIV.add(new ModelClass(R.drawable.html,"Analytical Skill Development-II ","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FAnalytical%20Skill%20Development-II_removed_compressed.pdf?alt=media&token=b07724ed-030a-49bc-9d25-6a3a7d8bb334"));
        semBscListIV.add(new ModelClass(R.drawable.css,"Database Management System","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FDatabase%20Management%20Systems_removed_compressed.pdf?alt=media&token=0b294e33-7703-4c5f-af2f-8ee918487d7e"));
        semBscListIV.add(new ModelClass(R.drawable.css,"Introduction to Computer Network","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FIntroduction%20to%20Computer%20Network_removed_compressed.pdf?alt=media&token=d6f0f45d-42e3-49a0-823d-505b6553ce65"));
        semBscListIV.add(new ModelClass(R.drawable.css,"Numerical Analysis ","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FNumerical%20Analysis_removed_compressed.pdf?alt=media&token=b92739f6-c70a-4b99-ab36-436945c69022"));
        semBscListIV.add(new ModelClass(R.drawable.css,"Report Writing (Yantra)","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FReport%20Writing%20(Yantra)_removed_compressed.pdf?alt=media&token=6742354d-691d-4077-8cb6-d853ee090b78"));
        semBscListIV.add(new ModelClass(R.drawable.css,"System Programming","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FSystem%20Programming_removed_compressed.pdf?alt=media&token=7e5e797e-d3fe-44fd-acaf-a2064341ecf1"));

        semBscListV = new ArrayList<>();
        semBscListV.add(new ModelClass(R.drawable.html,"Introduction to Software Engineering","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem6%2FIntroduction%20to%20software%20Engineering_removed_compressed.pdf?alt=media&token=e7093d6f-fb93-47e0-a6a5-918258e00663"));
        semBscListV.add(new ModelClass(R.drawable.css,"Mobile Application Development","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem5%2FMobile%20Application%20Development_removed_compressed.pdf?alt=media&token=d3853bc4-d10e-4355-a08c-a207e8400309"));
        semBscListV.add(new ModelClass(R.drawable.css,"Python Programming","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem5%2FPython%20Programming_removed_compressed.pdf?alt=media&token=d853a5b6-d072-4dc2-9eed-5198b4aac1da"));

        semBscListVI = new ArrayList<>();
        semBscListVI.add(new ModelClass(R.drawable.html,"Introduction to Web Technology","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem5%2FIntroduction%20to%20Web%20Technology_removed_compressed.pdf?alt=media&token=e5838244-04cb-4ae5-89f3-eb8c287a524e"));
        semBscListVI.add(new ModelClass(R.drawable.css,"Personality Development","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem5%2FPersonality%20Development%20Program_compressed.pdf?alt=media&token=5e32765e-1684-4c7b-b18b-6fa2d415b601"));

    }

    @SuppressLint("NotifyDataSetChanged")
    private void initRecycleView() {
        semViewI = findViewById(R.id.semIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewI.setLayoutManager(layoutManager);
        semAdapterI = new SemAdapterI(semBscList, getApplicationContext());
        semViewI.setAdapter(semAdapterI);
        semAdapterI.notifyDataSetChanged();

        semViewII = findViewById(R.id.semIIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewII.setLayoutManager(layoutManager);
        semAdapterII = new SemAdapterII(semBscListII, getApplicationContext());
        semViewII.setAdapter(semAdapterII);
        semAdapterII.notifyDataSetChanged();


        semViewIII = findViewById(R.id.semIIIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewIII.setLayoutManager(layoutManager);
        semAdapterIII = new SemAdapterIII(semBscListIII, getApplicationContext());
        semViewIII.setAdapter(semAdapterIII);
        semAdapterIII.notifyDataSetChanged();

        semViewIV = findViewById(R.id.semIVView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewIV.setLayoutManager(layoutManager);
        semAdapterIV = new SemAdapterIV(semBscListIV, getApplicationContext());
        semViewIV.setAdapter(semAdapterIV);
        semAdapterIV.notifyDataSetChanged();

        semViewV = findViewById(R.id.semVView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewV.setLayoutManager(layoutManager);
        semAdapterV = new SemAdapterV(semBscListV, getApplicationContext());
        semViewV.setAdapter(semAdapterV);
        semAdapterV.notifyDataSetChanged();

        semViewVI = findViewById(R.id.semVIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewVI.setLayoutManager(layoutManager);
        semAdapterVI = new SemAdapterVI(semBscListVI, getApplicationContext());
        semViewVI.setAdapter(semAdapterVI);
        semAdapterVI.notifyDataSetChanged();


    }
}