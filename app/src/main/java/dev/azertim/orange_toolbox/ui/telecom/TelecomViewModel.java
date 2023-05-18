package dev.azertim.orange_toolbox.ui.telecom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TelecomViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TelecomViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ici je vais ajouter des outils de télécom");
    }

    public LiveData<String> getText() {
        return mText;
    }
}