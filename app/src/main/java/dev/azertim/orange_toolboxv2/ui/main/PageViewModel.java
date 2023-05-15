package dev.azertim.orange_toolboxv2.ui.main;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            if (input == 1) {


            } else if (input == 2) {
                return "Contenu du deuxième onglet";
            } else if (input == 3 ) {
                return "Contne du 3e onglet";
            } else {
                return "Hello world from section: " + input;
            }
            return null;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}