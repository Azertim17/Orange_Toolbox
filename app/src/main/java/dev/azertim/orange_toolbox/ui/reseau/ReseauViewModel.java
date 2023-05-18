package dev.azertim.orange_toolbox.ui.reseau;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReseauViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ReseauViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ici prochainement des outils Réseaux");
    }

    public LiveData<String> getText() {
        return mText;
    }
}