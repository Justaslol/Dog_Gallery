package com.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> urls;

    public ImageAdapter(@NonNull Context context, @NonNull ArrayList<String> urls) {

        this.context = context;
        this.urls = urls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent){
        final ImageView myImageView;
        if (null == convertView) {
            myImageView = (ImageView) inflater.inflate(R.layout.gridview_item_image, parent, false);
        } else {
            myImageView = (ImageView) convertView;
        }

        Picasso.get()
                .load(urls.get(position))
                .resize(200, 200)
                .centerCrop()
                .into(myImageView);

        return myImageView;
    }
}
