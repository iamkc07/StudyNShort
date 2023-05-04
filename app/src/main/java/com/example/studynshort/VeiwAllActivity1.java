package com.example.studynshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

        languageListAll.add(new ModelClass(R.drawable.html, "Hl", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.africau.edu/images/default/sample.pdf"));
        languageListAll.add(new ModelClass(R.drawable.css, "css", "Download  all the high quality notes and play quiz to test your knowledge.", "https://icseindia.org/document/sample.pdf"));
        languageListAll.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        languageListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        languageListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        languageListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        languageListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        languageListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        languageListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));

    }
}