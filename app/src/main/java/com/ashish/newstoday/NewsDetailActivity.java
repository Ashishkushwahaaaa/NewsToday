package com.ashish.newstoday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {

    String title, desc, content, imageUrl, url;
    private ImageView idIVNews;
    private TextView idTVTitle, idTVSubDesc, idTVContent;
    private AppCompatButton idBVReadMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        content = getIntent().getStringExtra("content");
        imageUrl = getIntent().getStringExtra("Image");
        url = getIntent().getStringExtra("url");

        Log.d("NewsDetailActivity_image", "onCreate:" + url);
        Log.d("NewsDetailActivity_url", "onCreate:" + imageUrl);
        Log.d("NewsDetailActivity_content", "onCreate:" + content);

        idIVNews = findViewById(R.id.idIVNews);
        idTVTitle = findViewById(R.id.idTVTitle);
        idTVSubDesc = findViewById(R.id.idTVSubDesc);
        idBVReadMore = findViewById(R.id.idBVReadMore);
        idTVContent = findViewById(R.id.idTVContent);

        idTVTitle.setText(title);
        idTVSubDesc.setText(desc);
        idTVContent.setText(content);

        if (url != null ) {
            Picasso.get().load(url).placeholder(R.drawable.baseline_autorenew_24).error(R.drawable.baseline_newspaper_24).into(idIVNews);
        } else {
            idIVNews.setImageResource(R.drawable.baseline_newspaper_24);
        }


        idBVReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(imageUrl));
                startActivity(i);
            }
        });

    }
}