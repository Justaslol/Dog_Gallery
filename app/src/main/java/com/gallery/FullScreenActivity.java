package com.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FullScreenActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        imageView = (ImageView) findViewById(R.id.image_view);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ArrayList<String> urls = i.getExtras().getStringArrayList("urls");

        ImageAdapter fullImageAdapter = new ImageAdapter(this, urls);

        Picasso.get()
                .load(urls.get(position))
                .into(imageView);
    }
}
