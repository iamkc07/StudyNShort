package com.example.studynshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView webview;

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

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


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

        relativeLayout = findViewById(R.id.linearLayout);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BcaNotesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.light_blue));
        }

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