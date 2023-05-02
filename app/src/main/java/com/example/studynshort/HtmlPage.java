package com.example.studynshort;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HtmlPage extends AppCompatActivity {

    ImageView img;
    TextView txt;
    TextView txt1;

    TextView getUri;

    Button btn;
    Button btn1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_page);

        img = (ImageView)findViewById(R.id.detail_img);
        txt = (TextView)findViewById(R.id.detail_txt);
        txt1 = (TextView)findViewById(R.id.detail_desp);
        getUri = (TextView)findViewById(R.id.detail_url);

        img.setImageResource(getIntent().getIntExtra("imageView", 0));
        txt.setText(getIntent().getStringExtra("textview"));
        txt1.setText(getIntent().getStringExtra("textview1"));
        getUri.setText(getIntent().getStringExtra("url"));


        btn1 = findViewById(R.id.detail_dwd);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUrl = getUri.getText().toString();
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(getUrl));
                String title = URLUtil.guessFileName(getUrl, null, null);
                request.setTitle(title);
                request.setDescription("Download");

                String cookie = CookieManager.getInstance().getCookie(getUrl);
                request.addRequestHeader("cookie", cookie);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);

                DownloadManager downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);

                Toast.makeText(HtmlPage.this, "Downloading Started..", Toast.LENGTH_SHORT).show();
            }
        });

    }

}