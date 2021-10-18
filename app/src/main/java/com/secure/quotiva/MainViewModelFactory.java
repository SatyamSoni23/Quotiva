package com.secure.quotiva;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    Context context;
    MainViewModelFactory(Context context){
        this.context  = context;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(context);
    }
}
