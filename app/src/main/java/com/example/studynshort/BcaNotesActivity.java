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

        semBcaList = new ArrayList<>();
        semBcaList.add(new ModelClass(R.drawable.bca,"Basic Computer Skills","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2FSem1%2FDCAP101_BASIC_COMPUTER_SKILLS_removed_compressed.pdf?alt=media&token=70b53ac3-a9f9-421c-98fe-6349d94071da"));
        semBcaList.add(new ModelClass(R.drawable.bca,"FOUNDATIONS_OF_COMPUTER_PROGRAMMING","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2FSem1%2FDCAP102_BASIC_PROGRAMMING_SKILLS_DCAP401_FOUNDATIONS_OF_COMPUTER_PROGRAMMING_removed_compressed.pdf?alt=media&token=40a25e85-5d92-498e-a5fd-f6ba57abd2a0"));
        semBcaList.add(new ModelClass(R.drawable.bca,"PRINCIPLES_OF_OPERATING_SYSTEMS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2FSem1%2FDCAP103_PRINCIPLES_OF_OPERATING_SYSTEMS_removed_compressed.pdf?alt=media&token=11eb8c8e-5808-4561-aa4c-32f2afb3d3a4"));
        semBcaList.add(new ModelClass(R.drawable.bca,"EXPOSURE_TO_COMPUTER_DISCPLINES","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2FSem1%2FDCAP104_EXPOSURE_TO_COMPUTER_DISCPLINES_removed_compressed.pdf?alt=media&token=ef03a7c0-8c2d-47b6-948d-9e4b3c9128eb"));
        semBcaList.add(new ModelClass(R.drawable.bca,"COMMUNICATION_SKILLS_I","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2FSem1%2FDENG101_COMMUNICATION_SKILLS_I_removed_compressed.pdf?alt=media&token=53447ee3-a784-4f4b-bc52-1fff0a37f379"));


        semBcaListII = new ArrayList<>();
        semBcaListII.add(new ModelClass(R.drawable.bca,"WORKSHOP_ON_COMPUTER_HARDWARE_AND_NETWORK","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem2%2FDCAP105_WORKSHOP_ON_COMPUTER_HARDWARE_AND_NETWORK_removed_compressed.pdf?alt=media&token=794dd860-e26a-48f1-a870-c23ce06b2ca5"));
        semBcaListII.add(new ModelClass(R.drawable.bca,"OPERATING_SYSTEM_TOOLS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem2%2FDCAP106_OPERATING_SYSTEM_TOOLS_removed_compressed.pdf?alt=media&token=d1c8adb6-34fc-4225-a657-653b30b2ca89"));
        semBcaListII.add(new ModelClass(R.drawable.bca,"OBJECT_ORIENTED_PROGRAMMING","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem2%2FDCAP107_DCAP404_OBJECT_ORIENTED_PROGRAMMING_removed_compressed.pdf?alt=media&token=762bf324-7ecc-4f35-8405-947bdb4b4c5d"));
        semBcaListII.add(new ModelClass(R.drawable.bca,"COMMUNICATION_SKILLS_II","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem2%2FDENG102_COMMUNICATION_SKILLS_II_removed_compressed.pdf?alt=media&token=e8c353bc-3afe-42b7-9285-f4fa2e660d65"));
        semBcaListII.add(new ModelClass(R.drawable.bca,"MANAGING_HUMAN_ELEMENTS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem2%2FDMGT106_MANAGING_HUMAN_ELEMENTS_AT_WORK_removed_compressed.pdf?alt=media&token=15f58f25-8c18-4f88-9865-90a211619f47"));


        semBcaListIII = new ArrayList<>();
        semBcaListIII.add(new ModelClass(R.drawable.bca,"FUNDAMENTALS_OF_DATA_STRUCTURES","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem3%2FDCAP201_FUNDAMENTALS_OF_DATA_STRUCTURES_removed_compressed.pdf?alt=media&token=ef5a2787-c06c-4615-a0c6-9b5086728357"));
        semBcaListIII.add(new ModelClass(R.drawable.bca,"FUNDAMENTALS_OF_WEB_PROGRAMMING","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem3%2FDCAP202_FUNDAMENTALS_OF_WEB_PROGRAMMING_removed_compressed.pdf?alt=media&token=d65dc66d-7993-493d-b291-b25cbbf1c5db"));
        semBcaListIII.add(new ModelClass(R.drawable.bca,"DATABASE_MANAGEMENT_SYSTEMS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem3%2FDCAP204_MANAGING_DATABASE_DCAP402_DATABASE_MANAGEMENT_SYSTEMS_removed_compressed.pdf?alt=media&token=36687456-b8b2-4bb5-97a3-ef018ed47fc7"));
        semBcaListIII.add(new ModelClass(R.drawable.bca,"MANAGEMENT_SUPPORT_SYSTEMS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem3%2FDCAP208_MANAGEMENT_SUPPORT_SYSTEMS_removed_compressed.pdf?alt=media&token=70b6c06e-8c48-4642-a0aa-95db8af2c115"));
        semBcaListIII.add(new ModelClass(R.drawable.bca,"BASIC_MATHEMATICS_I","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision\n", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem3%2FDMTH201_BASIC_MATHEMATICS_I_removed_compressed.pdf?alt=media&token=14e8b482-b565-4119-8e0e-fde0e1273883"));

        semBcaListIV = new ArrayList<>();
        semBcaListIV.add(new ModelClass(R.drawable.bca,"OPEN_SOURCE_TECHNOLOGIES-3","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem4%2FDCAP203_DCAP410_OPEN_SOURCE_TECHNOLOGIES-3_removed_compressed.pdf?alt=media&token=01557f5c-dcd1-44c7-b537-9f4d2863e6a9"));
        semBcaListIV.add(new ModelClass(R.drawable.bca,"ANALYSIS_AND_DESIGN_OF_INFORMATION_SYSTEMS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem4%2FDCAP205_DCAP409_ANALYSIS_AND_DESIGN_OF_INFORMATION_SYSTEMS_removed_compressed.pdf?alt=media&token=e92fe17f-533c-45a2-ba26-d57f16bc1764"));
        semBcaListIV.add(new ModelClass(R.drawable.bca,"COMPUTER_ORGANIZATION_AND_ARCHITECTURE","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem4%2FDCAP206_INTRODUCTION_TO_COMPUTER_ORGANIZATION_AND_ARCHITECTURE_DCAP502_COMPUTER_ORGANIZATION_AND_ARCHITECTURE_removed_compressed.pdf?alt=media&token=a32b3889-a72e-4774-8b92-069592988ce6"));
        semBcaListIV.add(new ModelClass(R.drawable.bca,"COMPUTER_NETWORKS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem4%2FDCAP207_NETWORKS_DCAP406_COMPUTER_NETWORKS_removed_compressed.pdf?alt=media&token=f0a9d25b-e4e0-4d13-9316-b32d9d3ae246"));
        semBcaListIV.add(new ModelClass(R.drawable.bca,"BASIC_MATHEMATICS_II","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem4%2FDMTH202_BASIC_MATHEMATICS_II_removed_compressed.pdf?alt=media&token=b7aa177d-a152-4ecd-9174-306b7c2d4557"));


        semBcaListV = new ArrayList<>();
        semBcaListV.add(new ModelClass(R.drawable.bca,"MODERN_PROGRAMMING_TOOLS_AND_TECHNIQUES_III","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem5%2FDCAP301_MODERN_PROGRAMMING_TOOLS_AND_TECHNIQUES_III_removed_compressed.pdf?alt=media&token=c2270f0b-fd4f-4b64-99e8-24599d18f320"));
        semBcaListV.add(new ModelClass(R.drawable.bca,"ENTERPRISE_RESOURCE_PLANNING","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem5%2FDCAP302_DCAP514_ENTERPRISE_RESOURCE_PLANNING_removed_compressed.pdf?alt=media&token=8080960c-7330-4901-be61-bc6584de2de2"));
        semBcaListV.add(new ModelClass(R.drawable.bca,"MULTIMEDIA_SYSTEMS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem5%2FDCAP303_MULTIMEDIA_SYSTEMS_removed_compressed.pdf?alt=media&token=7ac267b6-4068-4910-a1f8-3f3569e2f2a2"));
        semBcaListV.add(new ModelClass(R.drawable.bca,"SOFTWARE_PROJECT_MANAGEMENT","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem5%2FDCAP304_DCAP515_SOFTWARE_PROJECT_MANAGEMENT_removed_compressed.pdf?alt=media&token=9fc717af-4dc2-43b1-9173-8e9ea6bf442c"));
        semBcaListV.add(new ModelClass(R.drawable.bca,"PRINCIPLES_OF_SOFTWARE_ENGINEERING","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem5%2FDCAP305_PRINCIPLES_OF_SOFTWARE_ENGINEERING_removed_compressed.pdf?alt=media&token=2712f177-077d-4eb5-98f3-8dd790b8ac9f"));

        semBcaListVI = new ArrayList<>();
        semBcaListVI.add(new ModelClass(R.drawable.bca,"E-COMMERCE_AND_E-BUSINESS","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem6%2FDCAP306_DCAP511_E-COMMERCE_AND_E-BUSINESS_removed_compressed.pdf?alt=media&token=97e2bbfd-43c2-46fd-b27a-665390992835"));
        semBcaListVI.add(new ModelClass(R.drawable.bca,"PLANNING_AND_MANAGING_IT_INFRASTRUCTURE","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem6%2FDCAP307_PLANNING_AND_MANAGING_IT_INFRASTRUCTURE_removed_compressed.pdf?alt=media&token=e13b8295-aff2-4660-8be5-e840adeddd51"));
        semBcaListVI.add(new ModelClass(R.drawable.bca,"OBJECT_ORIENTED_ANALYSIS_AND_DESIGN","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem6%2FDCAP308_OBJECT_ORIENTED_ANALYSIS_AND_DESIGN_removed_compressed.pdf?alt=media&token=8bf7ec0b-e9ec-47de-bb6e-45bfa2e34bfc"));
        semBcaListVI.add(new ModelClass(R.drawable.bca,"INFORMATION_SECURITY_AND_PRIVACY","Notes provided to the students through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/BCA%2Fsem6%2FDCAP309_DCAP513_INFORMATION_SECURITY_AND_PRIVACY_removed_compressed.pdf?alt=media&token=7df42021-dee4-4290-8379-74e8ed582e7c"));
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