package com.gallery;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonReader {

    public  ArrayList<String> GetUrlsFromJson(Context context){

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObj = (JsonObject) jsonParser.parse(getJsonString(context));
        JsonArray urls = jsonObj.getAsJsonArray("urls");

        ArrayList<String> urlsArray = gson.fromJson(urls, ArrayList.class);

        return urlsArray;
    }

    private String getJsonString(Context context){
        String json = null;
        try
        {
            InputStream is = context.getAssets().open("dog_urls.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
