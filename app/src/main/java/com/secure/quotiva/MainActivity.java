package com.secure.quotiva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;
    TextView quoteText, quoteAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(getApplication())).get(MainViewModel.class);
        setQuote(mainViewModel.getQuote());
    }

    public void init(){
        quoteText = findViewById(R.id.quoteText);
        quoteAuthor = findViewById(R.id.quoteAuthor);
    }

    public void setQuote(Quote quote){
        quoteText.setText(quote.text);
        quoteAuthor.setText(quote.author);
    }

    public void onNext(View v){
        setQuote(mainViewModel.nextQuote());
    }

    public void onPrevious(View v){
        setQuote(mainViewModel.previousQuoto());
    }

    public void onShare(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text);
        startActivity(intent);
    }
}