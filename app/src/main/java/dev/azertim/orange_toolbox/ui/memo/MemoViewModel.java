package dev.azertim.orange_toolbox.ui.memo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MemoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MemoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ici bientôt quelques mémos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}