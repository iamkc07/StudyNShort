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

public class BcomNotesActivity extends AppCompatActivity {

    RecyclerView semViewI;

    RelativeLayout relativeLayoutI, relativeLayoutII, relativeLayoutIII, relativeLayoutIV, relativeLayoutV, relativeLayoutVI;

    LinearLayout linearLayoutI, linearLayoutII, linearLayoutIII, linearLayoutIV, linearLayoutV, linearLayoutVI;
    LinearLayoutManager layoutManager;
    List<ModelClass> semBcomList;
    SemAdapterI semAdapterI;


    RecyclerView semViewII;
    List<ModelClass>semBcomListII;
    SemAdapterII semAdapterII;

    RecyclerView semViewIII;
    List<ModelClass>semBcomListIII;
    SemAdapterIII semAdapterIII;

    RecyclerView semViewIV;
    List<ModelClass>semBcomListIV;
    SemAdapterIV semAdapterIV;

    RecyclerView semViewV;
    List<ModelClass>semBcomListV;
    SemAdapterV semAdapterV;

    RecyclerView semViewVI;
    List<ModelClass>semBcomListVI;
    SemAdapterVI semAdapterVI;

    ImageView semIArrow, semIIArrow, semIIIArrow, semIVArrow, semVArrow, semVIArrow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcom_notes);

        ImageView back;
        back = findViewById(R.id.imageView2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

        semBcomList = new ArrayList<>();
        semBcomList.add(new ModelClass(R.drawable.css,"BASIC_COMPUTER_SKILLS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem1%2FDCAP101_BASIC_COMPUTER_SKILLS_removed_compressed.pdf?alt=media&token=96d2c033-8954-4f8c-90bb-b126f4759aa1"));
        semBcomList.add(new ModelClass(R.drawable.css,"FINANCIAL_ACCOUNTING_I","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem1%2FDCOM101_FINANCIAL_ACCOUNTING_I_removed_compressed.pdf?alt=media&token=8b64c6d1-cd45-44bc-9fd2-1f23f449fc61"));
        semBcomList.add(new ModelClass(R.drawable.css,"PRINCIPLES_AND_PRACTICES_OF_MANAGEMENT","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem1%2FDCOM102_DMGT101_PRINCIPLES_AND_PRACTICES_OF_MANAGEMENT_removed_compressed.pdf?alt=media&token=2c1362ad-2a8f-4a58-a6be-dad132301de7"));
        semBcomList.add(new ModelClass(R.drawable.css,"COMMERCIAL_LAW","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem1%2FDCOM103_COMMERCIAL_LAW_removed_compressed.pdf?alt=media&token=970df9b1-0d7f-4281-8b61-5dcdac9aa816"));
        semBcomList.add(new ModelClass(R.drawable.css,"COMMUNICATION_SKILLS_I","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem1%2FDENG101_COMMUNICATION_SKILLS_I_removed_compressed.pdf?alt=media&token=0b0cd3d2-0dc6-4f6d-ad79-8909b82d4415"));



        semBcomListII = new ArrayList<>();
        semBcomListII.add(new ModelClass(R.drawable.css,"FINANCIAL_ACCOUNTING_II","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem2%2FDCOM104_FINANCIAL_ACCOUNTING_II_removed_compressed.pdf?alt=media&token=104be87d-dfc9-4b9b-baf3-c6a68e3e111e"));
        semBcomListII.add(new ModelClass(R.drawable.css,"BUSINESS_ENVIRONMENT","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem2%2FDCOM105_DCOM402_DMGT105_DMGT401_BUSINESS_ENVIRONMENT_removed_compressed.pdf?alt=media&token=d839ea28-c596-4019-83ab-df8b1a84ff4d"));
        semBcomListII.add(new ModelClass(R.drawable.css,"COMPANY_LAW","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem2%2FDCOM106_DMGT201_COMPANY_LAW_removed_compressed.pdf?alt=media&token=2d7b14a8-8b9e-4a00-a281-3eea70eccb53"));
        semBcomListII.add(new ModelClass(R.drawable.css,"MICRO_ECONOMICS_ENGLISH","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem2%2FDECO101_MICRO_ECONOMICS_ENGLISH_removed_compressed.pdf?alt=media&token=132ae3dc-645f-4152-ab0d-41f7c8470e08"));
        semBcomListII.add(new ModelClass(R.drawable.css,"COMMUNICATION_SKILLS_II","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem2%2FDENG102_COMMUNICATION_SKILLS_II_removed_compressed.pdf?alt=media&token=9a1d0b89-3222-4d86-a159-38b78a51df71"));

        semBcomListIII = new ArrayList<>();
        semBcomListIII.add(new ModelClass(R.drawable.css,"ACCOUNTING_FOR_COMPANIES_I","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem3%2FDCOM201_ACCOUNTING_FOR_COMPANIES_I_removed_compressed.pdf?alt=media&token=df99e266-8a7a-49c3-9c67-c9325c4f8c95"));
        semBcomListIII.add(new ModelClass(R.drawable.css,"COST_ACCOUNTING_I","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem3%2FDCOM202_COST_ACCOUNTING_I_removed_compressed.pdf?alt=media&token=9ea2a925-1c2a-400b-90e5-2647735396d8"));
        semBcomListIII.add(new ModelClass(R.drawable.css,"QUANTITATIVE_TECHNIQUES_I","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem3%2FDCOM203_DMGT204_QUANTITATIVE_TECHNIQUES_I_removed_compressed.pdf?alt=media&token=9d1faa0d-80e6-4a48-ba2f-36c4be96b300"));
        semBcomListIII.add(new ModelClass(R.drawable.css,"AUDITING_THEORY","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem3%2FDCOM204_AUDITING_THEORY_removed_compressed.pdf?alt=media&token=b92c8158-225e-4f60-a527-02b64a38681d"));
        semBcomListIII.add(new ModelClass(R.drawable.css,"ECONOMICS_ENGLISH","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem3%2FDECO201_MACRO_ECONOMICS_ENGLISH_removed_compressed.pdf?alt=media&token=3c0ff9ab-f95b-4672-8e45-8e41861039b5"));

        semBcomListIV = new ArrayList<>();
        semBcomListIV.add(new ModelClass(R.drawable.css,"INCOME_TAX_LAWS_I","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem4%2FDCOM301_INCOME_TAX_LAWS_I_removed_compressed.pdf?alt=media&token=c0350224-ecd1-44b0-af71-3ac95a198801"));
        semBcomListIV.add(new ModelClass(R.drawable.css,"MANAGEMENT_ACCOUNTING","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem4%2FDCOM302_DCOM403_MANAGEMENT_ACCOUNTING_removed_compressed.pdf?alt=media&token=3d7fb6f7-dd40-4ba7-b465-d50f9ae8239f"));
        semBcomListIV.add(new ModelClass(R.drawable.css,"INDIAN_FINANCIAL_SYSTEM (1)","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem4%2FDCOM304_DCOM503_INDIAN_FINANCIAL_SYSTEM%20(1)_removed_compressed.pdf?alt=media&token=cbe556c5-9b01-433f-9f96-94ba0e2b7782"));
        semBcomListIV.add(new ModelClass(R.drawable.css,"INDIAN_FINANCIAL_SYSTEM","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem4%2FDCOM304_DCOM503_INDIAN_FINANCIAL_SYSTEM_removed_compressed.pdf?alt=media&token=230fd33b-6085-439a-8a2c-0fea1e5d3792"));
        semBcomListIV.add(new ModelClass(R.drawable.css,"SMALL_BUSINESS_MANAGEMENT","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem4%2FDCOM305_DMGT310_ENTREPRENEURSHIP_AND_SMALL_BUSINESS_MANAGEMENT_removed_compressed.pdf?alt=media&token=07505c96-a1f0-45a5-95f2-25c061efdbab"));

        semBcomListV = new ArrayList<>();
        semBcomListV.add(new ModelClass(R.drawable.css,"INCOME_TAX_LAWS_I","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem5%2FDCOM301_INCOME_TAX_LAWS_I_removed_compressed.pdf?alt=media&token=d4a7a959-3181-4ac2-b1e7-187fb2fbc294"));
        semBcomListV.add(new ModelClass(R.drawable.css,"MANAGEMENT_ACCOUNTING","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem5%2FDCOM302_DCOM403_MANAGEMENT_ACCOUNTING_removed_compressed.pdf?alt=media&token=401f8500-c472-4c0c-9e98-ffc56fe6f970 "));
        semBcomListV.add(new ModelClass(R.drawable.css,"INDIAN_FINANCIAL_SYSTEM","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem5%2FDCOM304_DCOM503_INDIAN_FINANCIAL_SYSTEM%20(1)_removed_compressed%20(1).pdf?alt=media&token=39f5b7a0-3e9b-48b9-bd48-063af7695d9f"));
        semBcomListV.add(new ModelClass(R.drawable.css,"INDIAN_FINANCIAL_SYSTEM","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem5%2FDCOM304_DCOM503_INDIAN_FINANCIAL_SYSTEM%20(1)_removed_compressed.pdf?alt=media&token=0099d1a9-7946-437c-a848-b8e9e9f241f0"));
        semBcomListV.add(new ModelClass(R.drawable.css,"ENTREPRENEURSHIP_AND_SMALL_BUSINESS_MANAGEMENT","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem5%2FDCOM305_DMGT310_ENTREPRENEURSHIP_AND_SMALL_BUSINESS_MANAGEMENT_removed_compressed.pdf?alt=media&token=81d2ebd7-7fe0-47fa-9a4a-26dc0eb80799"));


        semBcomListVI = new ArrayList<>();
        semBcomListVI.add(new ModelClass(R.drawable.css,"FINANCIAL MANAGEMENT","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem6%2FDCOM307_DMGT405_DCOM406_FINANCIAL%20MANAGEMENT_removed_compressed.pdf?alt=media&token=34ac400b-f2b1-41d6-8dbe-7fdb84448fba"));
        semBcomListVI.add(new ModelClass(R.drawable.css,"INDIRECT_TAX_LAWS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem6%2FDCOM308_DCOM502_INDIRECT_TAX_LAWS_removed_compressed.pdf?alt=media&token=40166283-9aa3-45db-a58c-3e9f87d83032"));
        semBcomListVI.add(new ModelClass(R.drawable.css,"INSURANCE_LAWS_AND_PRACTICES","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem6%2FDCOM309_INSURANCE_LAWS_AND_PRACTICES_removed_compressed.pdf?alt=media&token=7643f80e-b0f4-4668-a796-000042e58c45"));
        semBcomListVI.add(new ModelClass(R.drawable.css,"INDIAN_ECONOMY_ENGLISH","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Bcom%2Fsem6%2FDECO303_INDIAN_ECONOMY_ENGLISH_removed_compressed.pdf?alt=media&token=158b001e-c8de-47f4-9e1d-350b71972cf3"));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initRecycleView() {
        semViewI = findViewById(R.id.semIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewI.setLayoutManager(layoutManager);
        semAdapterI = new SemAdapterI(semBcomList, getApplicationContext());
        semViewI.setAdapter(semAdapterI);
        semAdapterI.notifyDataSetChanged();

        semViewII = findViewById(R.id.semIIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewII.setLayoutManager(layoutManager);
        semAdapterII = new SemAdapterII(semBcomListII, getApplicationContext());
        semViewII.setAdapter(semAdapterII);
        semAdapterII.notifyDataSetChanged();


        semViewIII = findViewById(R.id.semIIIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewIII.setLayoutManager(layoutManager);
        semAdapterIII = new SemAdapterIII(semBcomListII, getApplicationContext());
        semViewIII.setAdapter(semAdapterIII);
        semAdapterIII.notifyDataSetChanged();

        semViewIV = findViewById(R.id.semIVView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewIV.setLayoutManager(layoutManager);
        semAdapterIV = new SemAdapterIV(semBcomListIV, getApplicationContext());
        semViewIV.setAdapter(semAdapterIV);
        semAdapterIV.notifyDataSetChanged();

        semViewV = findViewById(R.id.semVView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewV.setLayoutManager(layoutManager);
        semAdapterV = new SemAdapterV(semBcomListV, getApplicationContext());
        semViewV.setAdapter(semAdapterV);
        semAdapterV.notifyDataSetChanged();

        semViewVI = findViewById(R.id.semVIView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        semViewVI.setLayoutManager(layoutManager);
        semAdapterVI = new SemAdapterVI(semBcomListVI, getApplicationContext());
        semViewVI.setAdapter(semAdapterVI);
        semAdapterVI.notifyDataSetChanged();


    }
}