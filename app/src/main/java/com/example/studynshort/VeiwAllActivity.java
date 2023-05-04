package com.example.studynshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

        webListAll.add(new ModelClass(R.drawable.html, "Html", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.africau.edu/images/default/sample.pdf"));
        webListAll.add(new ModelClass(R.drawable.css, "css", "Download  all the high quality notes and play quiz to test your knowledge.", "https://icseindia.org/document/sample.pdf"));
        webListAll.add(new ModelClass(R.drawable.js, "Javascript", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        webListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        webListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        webListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        webListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        webListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        webListAll.add(new ModelClass(R.drawable.php, "Php", "Download  all the high quality notes and play quiz to test your knowledge.", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));

    }
}