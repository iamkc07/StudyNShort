package com.example.studynshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class VeiwAllActivity extends AppCompatActivity {

    RecyclerView webviewAll;

    LinearLayoutManager layoutManager;
    List<ModelClass> webListAll;
    WebAdapterAll Wadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiw_all);

        initData();
        initRecycleView();

        ImageView back;
        back = findViewById(R.id.imageView2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initRecycleView() {
        webviewAll = findViewById(R.id.view_all);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        webviewAll.setLayoutManager(layoutManager);
        Wadapter = new WebAdapterAll(webListAll, getApplicationContext());
        webviewAll.setAdapter(Wadapter);
        Wadapter.notifyDataSetChanged();
    }

    private void initData() {
        webListAll = new ArrayList<>();

        webListAll.add(new ModelClass(R.drawable.html, "Html", "Download all the high quality notes and play quiz to test your knowledge.","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FHTML(WT)%20Lecture%20Notes_compressed.pdf?alt=media&token=b437b25e-d7db-4a27-947e-75415e7485b0"));
        webListAll.add(new ModelClass(R.drawable.css, "css", "Download all the high quality notes and play quiz to test your knowledge.","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2Fcss_compressed.pdf?alt=media&token=ac3b722f-9b85-4fcf-941c-3a1e1958e88e"));
        webListAll.add(new ModelClass(R.drawable.js, "Javascript", "Download all the high quality notes and play quiz to test your knowledge.","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FJavaScript%20Handwritten%20Notes_compressed.pdf?alt=media&token=c99d7320-4758-4cd8-888f-60e4278499c6"));
        webListAll.add(new ModelClass(R.drawable.php, "Php", "Download all the high quality notes and play quiz to test your knowledge.","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FPHP%20Notes%20-%20TutorialsDuniya.pdf?alt=media&token=4595bffa-5810-4559-af53-561081bff233"));
        webListAll.add(new ModelClass(R.drawable.angularjs, "Angular Js", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2Fangular_compressed.pdf?alt=media&token=6b33467f-de5c-405e-af27-3bf08101afa0"));
        webListAll.add(new ModelClass(R.drawable.atom, "React Js", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FReact.js%20notes_compressed.pdf?alt=media&token=9bd1a57f-95b3-4f63-8641-ad35362ec704"));
        webListAll.add(new ModelClass(R.drawable.sqlserver, "SQL", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FSQL%20Handwritten%20Notes%20_compressed.pdf?alt=media&token=7af925de-38a1-4fb5-846c-32180c4e6e7b"));
        webListAll.add(new ModelClass(R.drawable.dwms, "DBMS", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FDBMS%20Handwritten%20Notes_compressed.pdf?alt=media&token=fba62e35-b118-4ee6-819a-d869f9487437"));
        webListAll.add(new ModelClass(R.drawable.mongo, "MongoDB", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FMongoDB%20Handwritten%20Notes%20_compressed.pdf?alt=media&token=d14ba3a8-7b46-4edc-bb53-7033193551fd"));
        webListAll.add(new ModelClass(R.drawable.dwms, "DBMS II", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Web%20Dev%2FDBMS%20Notes!%20_compressed.pdf?alt=media&token=1bd69c99-cc32-434f-bd60-cf3b069569dc"));

    }
}