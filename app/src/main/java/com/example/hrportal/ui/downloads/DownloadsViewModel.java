package com.example.hrportal.ui.downloads;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DownloadsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DownloadsViewModel() {
        mText = new MutableLiveData<>();
 //       mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}