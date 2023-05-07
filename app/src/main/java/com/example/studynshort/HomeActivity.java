package com.example.studynshort;

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
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

    LinearLayoutManager layoutManager;
    List<ModelClass>webList;
    WebAdapter adapter;

    RecyclerView languageview;
    List<ModelClass>lanList;
    LanguageAdapter Ladapter;

    RecyclerView databaseview;
    List<ModelClass>databaseList;
    DatabaseAdapter databaseAdapter;
    TextView viewAll, viewAll1;

    EditText  ourEmail, subject, message;

    ImageView instaImg, fbimg, linkedinimg;

    Button submit;

    RelativeLayout relativeLayoutI, relativeLayoutII, relativeLayoutIII, relativeLayoutIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView =findViewById(R.id.navigation_view);
        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.dark_purple));
        toggle.syncState();

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

        instaImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/thekaranchaurasiya");
            }
        });

        fbimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.facebook.com/thekaranchaurasiya");
            }
        });

        linkedinimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.linkedin.com/in/iamkc0710");
            }
        });


        initData();
        initRecycleView();


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



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.light_blue));
        }

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void initData() {
        webList = new ArrayList<>();

        webList.add(new ModelClass(R.drawable.html, "Html", "Download  all the high quality notes and play quiz to test your knowledge.","https://www.africau.edu/images/default/sample.pdf"));
        webList.add(new ModelClass(R.drawable.css, "css", "Download  all the high quality notes and play quiz to test your knowledge.","https://icseindia.org/document/sample.pdf"));
        webList.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        webList.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));

        lanList= new ArrayList<>();

        lanList.add(new ModelClass(R.drawable.html, "Html", "Download  all the high quality notes and play quiz to test your knowledge.","https://www.africau.edu/images/default/sample.pdf"));
        lanList.add(new ModelClass(R.drawable.css, "css", "Download  all the high quality notes and play quiz to test your knowledge.","https://icseindia.org/document/sample.pdf"));
        lanList.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        lanList.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));

        databaseList= new ArrayList<>();
        databaseList.add(new ModelClass(R.drawable.html, "Html", "Download  all the high quality notes and play quiz to test your knowledge.","https://www.africau.edu/images/default/sample.pdf"));
        databaseList.add(new ModelClass(R.drawable.css, "css", "Download  all the high quality notes and play quiz to test your knowledge.","https://icseindia.org/document/sample.pdf"));
        databaseList.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        databaseList.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));


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

        databaseview = findViewById(R.id.databaseview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        databaseview.setLayoutManager(layoutManager);
        databaseAdapter = new DatabaseAdapter(databaseList, getApplicationContext());
        databaseview.setAdapter(databaseAdapter);
        databaseAdapter.notifyDataSetChanged();
    }
}