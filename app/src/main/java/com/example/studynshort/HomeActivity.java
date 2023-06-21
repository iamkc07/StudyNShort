package com.example.studynshort;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView webview;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FirebaseAuth mAuth;

    LinearLayoutManager layoutManager;
    List<ModelClass> webList;
    WebAdapter adapter;


    List<ModelClass> SList;
    SearchAdapter Sadapter;
    RecyclerView Sview;

    RecyclerView languageview;
    List<ModelClass> lanList;
    LanguageAdapter Ladapter;

    TextView viewAll, viewAll1;

    EditText ourEmail, subject, message;

    ImageView instaImg, fbimg, linkedinimg, signout;

    Button submit;

    RelativeLayout relativeLayoutI, relativeLayoutII, relativeLayoutIII, relativeLayoutIV, quizbox;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();
//        drawerLayout = findViewById(R.id.drawer_layout);
//        navigationView = findViewById(R.id.navigation_view);
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.dark_purple));
//        toggle.syncState();

        instaImg = findViewById(R.id.imageinsta2);
        fbimg = findViewById(R.id.imagefb);
        linkedinimg = findViewById(R.id.imagelink);

        ourEmail = findViewById(R.id.editemail);
        subject = findViewById(R.id.editsubject);
        message = findViewById(R.id.editmessage);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subJect = subject.getText().toString();
                String messAge = message.getText().toString();
                String myemail = ourEmail.getText().toString();
            }
        });

        RelativeLayout searchview;
        searchview = findViewById(R.id.search);

        EditText editTextText;
        ScrollView view;

        editTextText = findViewById(R.id.editTextText);
        view = findViewById(R.id.Scrolldata);

        editTextText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    view.setVisibility(View.GONE);
                    searchview.setVisibility(View.VISIBLE);
                } else {
                    searchview.setVisibility(View.INVISIBLE);
                    view.setVisibility(View.VISIBLE);
                }
            }
        });

        editTextText.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_BACK) {
                    editTextText.clearFocus();
                    return true;
                } else return false;
            }
        });

        editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


        initData();
        initRecycleView();



        signout = findViewById(R.id.signout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


        viewAll = findViewById(R.id.textView9);
        viewAll1 = findViewById(R.id.textView11);

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, VeiwAllActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        viewAll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, VeiwAllActivity1.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        relativeLayoutI = findViewById(R.id.linearLayout);
        relativeLayoutI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BcaNotesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        relativeLayoutII = findViewById(R.id.linearLayout3);
        relativeLayoutII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BcomNotesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        relativeLayoutIII = findViewById(R.id.linearLayout4);
        relativeLayoutIII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BscNotesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        relativeLayoutIV = findViewById(R.id.linearLayout2);
        relativeLayoutIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BbaNotesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        quizbox = findViewById(R.id.quizbox);
        quizbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, QuizGameActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.light_blue));
        }

    }

    private void filter(String txt) {
        ArrayList<ModelClass> filterlist = new ArrayList<>();

        for (ModelClass item : SList) {
            if (item.getTextview1().toLowerCase().contains(txt.toLowerCase())) {
                filterlist.add(item);
            }
        }
        Sadapter.filterlisted(filterlist);
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }


    private void initData() {
        webList = new ArrayList<>();

        webList.add(new ModelClass(R.drawable.html, "Html", "Download all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FHTML(WT)%20Lecture%20Notes_compressed.pdf?alt=media&token=b437b25e-d7db-4a27-947e-75415e7485b0"));
        webList.add(new ModelClass(R.drawable.css, "css", "Download all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2Fcss_compressed.pdf?alt=media&token=ac3b722f-9b85-4fcf-941c-3a1e1958e88e"));
        webList.add(new ModelClass(R.drawable.js, "Javascript", "Download all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FJavaScript%20Handwritten%20Notes_compressed.pdf?alt=media&token=c99d7320-4758-4cd8-888f-60e4278499c6"));
        webList.add(new ModelClass(R.drawable.php, "Php", "Download all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FPHP%20Notes%20-%20TutorialsDuniya.pdf?alt=media&token=4595bffa-5810-4559-af53-561081bff233"));

        lanList = new ArrayList<>();

        lanList.add(new ModelClass(R.drawable.java, "Java", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FBest%20Handwritten%20Java%20Notes_compressed.pdf?alt=media&token=530fffd2-213e-4678-8219-3b651b15e3c5"));
        lanList.add(new ModelClass(R.drawable.c, "C++", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FC%20language_compressed.pdf?alt=media&token=797fbdad-c860-4648-b6a4-56021d969819"));
        lanList.add(new ModelClass(R.drawable.python, "Python", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FPYTHON%20PROGRAMMING%20NOTES_compressed.pdf?alt=media&token=a94a63be-495c-4060-9c08-4d3f388c7336"));
        lanList.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FKotlinNotesForProfessionals.pdf?alt=media&token=93bccfea-b167-4838-abb4-33d3e721448f"));


        SList = new ArrayList<>();

        SList.add(new ModelClass(R.drawable.html, "Html", "Download all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FHTML(WT)%20Lecture%20Notes_compressed.pdf?alt=media&token=b437b25e-d7db-4a27-947e-75415e7485b0"));
        SList.add(new ModelClass(R.drawable.css, "css", "Download all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2Fcss_compressed.pdf?alt=media&token=ac3b722f-9b85-4fcf-941c-3a1e1958e88e"));
        SList.add(new ModelClass(R.drawable.js, "Javascript", "Download all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FJavaScript%20Handwritten%20Notes_compressed.pdf?alt=media&token=c99d7320-4758-4cd8-888f-60e4278499c6"));
        SList.add(new ModelClass(R.drawable.php, "Php", "Download all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FPHP%20Notes%20-%20TutorialsDuniya.pdf?alt=media&token=4595bffa-5810-4559-af53-561081bff233"));
        SList.add(new ModelClass(R.drawable.angularjs, "Angular Js", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2Fangular_compressed.pdf?alt=media&token=6b33467f-de5c-405e-af27-3bf08101afa0"));
        SList.add(new ModelClass(R.drawable.atom, "React Js", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FReact.js%20notes_compressed.pdf?alt=media&token=9bd1a57f-95b3-4f63-8641-ad35362ec704"));
        SList.add(new ModelClass(R.drawable.sqlserver, "SQL", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FSQL%20Handwritten%20Notes%20_compressed.pdf?alt=media&token=7af925de-38a1-4fb5-846c-32180c4e6e7b"));
        SList.add(new ModelClass(R.drawable.dwms, "DBMS", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FDBMS%20Handwritten%20Notes_compressed.pdf?alt=media&token=fba62e35-b118-4ee6-819a-d869f9487437"));
        SList.add(new ModelClass(R.drawable.mongo, "MongoDB", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FMongoDB%20Handwritten%20Notes%20_compressed.pdf?alt=media&token=d14ba3a8-7b46-4edc-bb53-7033193551fd"));
        SList.add(new ModelClass(R.drawable.dwms, "DBMS II", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FDBMS%20Notes!%20_compressed.pdf?alt=media&token=1bd69c99-cc32-434f-bd60-cf3b069569dc"));
        SList.add(new ModelClass(R.drawable.kotlin, "Kotlin", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FKotlinNotesForProfessionals.pdf?alt=media&token=d73d471a-2ab9-4c27-92a9-7abc65fc1d36"));
        SList.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FPHP%20Notes%20-%20TutorialsDuniya.pdf?alt=media&token=4595bffa-5810-4559-af53-561081bff233"));
        SList.add(new ModelClass(R.drawable.java, "Java", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FBest%20Handwritten%20Java%20Notes_compressed.pdf?alt=media&token=530fffd2-213e-4678-8219-3b651b15e3c5"));
        SList.add(new ModelClass(R.drawable.c, "C++", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FC%20language_compressed.pdf?alt=media&token=797fbdad-c860-4648-b6a4-56021d969819"));
        SList.add(new ModelClass(R.drawable.python, "Python", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FPYTHON%20PROGRAMMING%20NOTES_compressed.pdf?alt=media&token=a94a63be-495c-4060-9c08-4d3f388c7336"));
        SList.add(new ModelClass(R.drawable.bsc,"Computer Science One","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FComputerScienceOne_removed_compressed.pdf?alt=media&token=932d8f79-86f9-4f4e-b6bf-d34b42e8358e"));
        SList.add(new ModelClass(R.drawable.bsc,"Environmental Science","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FEnvironmental%20Sciences_removed_compressed.pdf?alt=media&token=fa475c05-2bb9-49c0-b153-371834cd367e"));
        SList.add(new ModelClass(R.drawable.bsc,"Foundation Course in Mathematics","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FFoundation%20Course%20in%20Mathematics_removed_compressed.pdf?alt=media&token=41c78fb1-f6d7-4aed-bb65-bccf6a9be501"));
        SList.add(new ModelClass(R.drawable.bsc,"Functional English-I","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FFunctional%20English%20-%20I_removed_compressed.pdf?alt=media&token=2425bd3e-74ab-43d1-b380-16617238c1ae"));
        SList.add(new ModelClass(R.drawable.bsc,"Introduction of Digital Electronic","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem1%2FIntroduction%20to%20Digital%20Electronic_compressed.pdf?alt=media&token=84b3d61a-f4f4-48c5-b471-fe3ea05c78d8"));
        SList.add(new ModelClass(R.drawable.bsc,"Computer Organization","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FComputer%20Organization_removed_compressed.pdf?alt=media&token=a73ae19f-ecc7-4647-a7e1-6a4e2e6fa499"));
        SList.add(new ModelClass(R.drawable.bsc,"Discrete Mathematics","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FDiscrete%20Mathematics_removed_compressed.pdf?alt=media&token=d84c62ad-21a1-4820-be6c-2a4bb8fadee6"));
        SList.add(new ModelClass(R.drawable.bsc,"Front Office Management","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FFront%20Office%20Management_removed_compressed.pdf?alt=media&token=9ced3ebf-c27f-4cf6-bd59-5cacf5404c90"));
        SList.add(new ModelClass(R.drawable.bsc,"Fundamental of Open Source Software-LINUX","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FFundamental%20of%20Open%20Source%20Software-LINUX_removed_compressed.pdf?alt=media&token=b7a94464-cfa3-4136-862f-c6338cc02bd3"));
        SList.add(new ModelClass(R.drawable.bsc,"Value and Ethics","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem2%2FValue%20and%20Ethics_removed_compressed.pdf?alt=media&token=a02c0e61-28fb-4da6-b289-4f16669cbb1c"));
        SList.add(new ModelClass(R.drawable.bsc,"Analytical Skill Development-I","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FAnalytical%20Skill%20Development-I_removed_compressed.pdf?alt=media&token=9846fea5-97cc-4e9e-8516-0533eb965b29"));
        SList.add(new ModelClass(R.drawable.bsc,"Introduction to Data Structure","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FIntroduction%20to%20Data%20Structures_removed_compressed.pdf?alt=media&token=e01a80b9-6a83-4ab7-bf97-18adc03ee776"));
        SList.add(new ModelClass(R.drawable.bsc,"Object-Oriented Programming Using C++","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FIntroduction%20to%20Data%20Structures_removed_compressed.pdf?alt=media&token=e01a80b9-6a83-4ab7-bf97-18adc03ee776"));
        SList.add(new ModelClass(R.drawable.bsc,"Operating System Concept","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FOperating%20Systems%20Concepts_removed_compressed.pdf?alt=media&token=38fb2dcc-e8a8-46fe-9ffd-2574b5104035"));
        SList.add(new ModelClass(R.drawable.bsc,"System Analysis and Design","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FSystem%20Analysis%20and%20Design_removed_compressed.pdf?alt=media&token=fa3caa4f-08a0-4bce-88e1-d53536069910"));
        SList.add(new ModelClass(R.drawable.bsc,"Technical Writing","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem3%2FTechnical%20Writing_removed_compressed.pdf?alt=media&token=dc22e76d-f046-443a-b9ec-db3031fe488f"));
        SList.add(new ModelClass(R.drawable.bsc,"Analytical Skill Development-II ","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FAnalytical%20Skill%20Development-II_removed_compressed.pdf?alt=media&token=b07724ed-030a-49bc-9d25-6a3a7d8bb334"));
        SList.add(new ModelClass(R.drawable.bsc,"Database Management System","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FDatabase%20Management%20Systems_removed_compressed.pdf?alt=media&token=0b294e33-7703-4c5f-af2f-8ee918487d7e"));
        SList.add(new ModelClass(R.drawable.bsc,"Introduction to Computer Network","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FIntroduction%20to%20Computer%20Network_removed_compressed.pdf?alt=media&token=d6f0f45d-42e3-49a0-823d-505b6553ce65"));
        SList.add(new ModelClass(R.drawable.bsc,"Numerical Analysis ","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FNumerical%20Analysis_removed_compressed.pdf?alt=media&token=b92739f6-c70a-4b99-ab36-436945c69022"));
        SList.add(new ModelClass(R.drawable.bsc,"Report Writing (Yantra)","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FReport%20Writing%20(Yantra)_removed_compressed.pdf?alt=media&token=6742354d-691d-4077-8cb6-d853ee090b78"));
        SList.add(new ModelClass(R.drawable.bsc,"System Programming","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem4%2FSystem%20Programming_removed_compressed.pdf?alt=media&token=7e5e797e-d3fe-44fd-acaf-a2064341ecf1"));
        SList.add(new ModelClass(R.drawable.bsc,"Introduction to Software Engineering","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem6%2FIntroduction%20to%20software%20Engineering_removed_compressed.pdf?alt=media&token=e7093d6f-fb93-47e0-a6a5-918258e00663"));
        SList.add(new ModelClass(R.drawable.bsc,"Mobile Application Development","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem5%2FMobile%20Application%20Development_removed_compressed.pdf?alt=media&token=d3853bc4-d10e-4355-a08c-a207e8400309"));
        SList.add(new ModelClass(R.drawable.bsc,"Python Programming","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem5%2FPython%20Programming_removed_compressed.pdf?alt=media&token=d853a5b6-d072-4dc2-9eed-5198b4aac1da"));
        SList.add(new ModelClass(R.drawable.bsc,"Introduction to Web Technology","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem5%2FIntroduction%20to%20Web%20Technology_removed_compressed.pdf?alt=media&token=e5838244-04cb-4ae5-89f3-eb8c287a524e"));
        SList.add(new ModelClass(R.drawable.bsc,"Personality Development","Notes provided to the student through this app so that they can gain information and can use this notes for preparation of exam or revision", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/bsc%20computer%20science%2Fsem5%2FPersonality%20Development%20Program_compressed.pdf?alt=media&token=5e32765e-1684-4c7b-b18b-6fa2d415b601"));



    }


    private void initRecycleView() {
        webview = findViewById(R.id.webview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        webview.setLayoutManager(layoutManager);
        adapter = new WebAdapter(webList, getApplicationContext());
        webview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        languageview = findViewById(R.id.languageview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        languageview.setLayoutManager(layoutManager);
        Ladapter = new LanguageAdapter(lanList, getApplicationContext());
        languageview.setAdapter(Ladapter);
        Ladapter.notifyDataSetChanged();


        Sview = findViewById(R.id.searchview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        Sview.setLayoutManager(layoutManager);
        Sadapter = new SearchAdapter(SList, getApplicationContext());
        Sview.setAdapter(Sadapter);
        Sadapter.notifyDataSetChanged();

    }

}

