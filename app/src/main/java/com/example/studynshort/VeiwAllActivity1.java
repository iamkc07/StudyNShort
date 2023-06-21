package com.example.studynshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class VeiwAllActivity1 extends AppCompatActivity {

    RecyclerView language_card;

    LinearLayoutManager layoutManager;
    List<ModelClass> languageListAll;
   LanguageAdapterAll LadapterAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiw_all1);

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
        language_card = findViewById(R.id.view_all1);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        language_card.setLayoutManager(layoutManager);
        LadapterAll = new LanguageAdapterAll(languageListAll, getApplicationContext());
        language_card.setAdapter(LadapterAll);
        LadapterAll.notifyDataSetChanged();
    }

    private void initData() {
        languageListAll = new ArrayList<>();

        languageListAll.add(new ModelClass(R.drawable.kotlin, "Kotlin", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FKotlinNotesForProfessionals.pdf?alt=media&token=d73d471a-2ab9-4c27-92a9-7abc65fc1d36"));
        languageListAll.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FJavaScript%20Notes%20_compressed.pdf?alt=media&token=e7a7a6b5-4d3f-4d2e-8d11-11b4ebcea22a"));
        languageListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FPHP%20Notes%20-%20TutorialsDuniya.pdf?alt=media&token=4595bffa-5810-4559-af53-561081bff233"));
        languageListAll.add(new ModelClass(R.drawable.java, "Java", "Download  all the high quality notes and play quiz to test your knowledge.","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FBest%20Handwritten%20Java%20Notes_compressed.pdf?alt=media&token=530fffd2-213e-4678-8219-3b651b15e3c5"));
        languageListAll.add(new ModelClass(R.drawable.c, "C++", "Download  all the high quality notes and play quiz to test your knowledge.","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FC%20language_compressed.pdf?alt=media&token=797fbdad-c860-4648-b6a4-56021d969819"));
        languageListAll.add(new ModelClass(R.drawable.python, "Python", "Download  all the high quality notes and play quiz to test your knowledge.","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FPYTHON%20PROGRAMMING%20NOTES_compressed.pdf?alt=media&token=a94a63be-495c-4060-9c08-4d3f388c7336"));
        languageListAll.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.","https://firebasestorage.googleapis.com/v0/b/studynshortcomplete.appspot.com/o/Programming%20Language%2FKotlinNotesForProfessionals.pdf?alt=media&token=93bccfea-b167-4838-abb4-33d3e721448f"));

    }
}