package com.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> urls;
        JsonReader jsonReader = new JsonReader();

        urls = jsonReader.GetUrlsFromJson(this);

        //setContentView(R.layout.gridview);
        GridView gridView = (GridView) findViewById(R.id.gallery_gridview);

        gridView.setAdapter(
                new ImageAdapter(
                        this,
                        urls
                )
        );

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), FullScreenActivity.class);
                intent.putExtra("id", position);
                intent.putStringArrayListExtra("urls", urls);
                startActivity(intent);
            }
        });
    }
}




