package com.secure.quotiva;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private ArrayList<Quote> quoteList;
    private int index = 0;
    Context context;

    MainViewModel(Context context){
        this.context = context;
    }


    void init(){
         quoteList = loadQuoteFromAssets();
    }

    private ArrayList<Quote> loadQuoteFromAssets() {
        try {
            InputStream inputStream = context.getAssets().open("quotes.json");
            int size = inputStream.available();
            //StringBuffer buffer = new ByteArrayInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
