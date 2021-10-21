package com.secure.quotiva;

import android.content.Context;
import android.content.res.AssetManager;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private ArrayList<Quote> quoteList;
    private int index = 0;
    Context context;

//    public MainViewModel(){
//
//    }

    MainViewModel(Context context){
        this.context = context;
        quoteList = loadQuoteFromAssets();
    }

    private ArrayList<Quote> loadQuoteFromAssets() {
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("quotes.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            ArrayList<Quote> quotes = gson.fromJson(json, new TypeToken<ArrayList<Quote>>(){}.getType());
            return quotes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    Quote getQuote(){
        int size = quoteList.size();
        return quoteList.get(index);
    }
    Quote nextQuote(){
        int size = quoteList.size();
        index = (index + 1)%size;
        return quoteList.get(index);
    }
    Quote previousQuoto(){
        int size = quoteList.size();
        index = (size + (index-1))%size;
        return quoteList.get(index);
    }
}
