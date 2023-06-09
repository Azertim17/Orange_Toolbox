package dev.azertim.orange_toolbox.ui.memo.couleurscuivre;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import dev.azertim.orange_toolbox.R;
import dev.azertim.orange_toolbox.databinding.FragmentCouleursCuivreBinding;
import dev.azertim.orange_toolbox.databinding.FragmentMemosBinding;
import dev.azertim.orange_toolbox.ui.telecom.TelecomViewModel;

public class CouleursCuivreMemoFragment extends Fragment {
    private FragmentCouleursCuivreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TelecomViewModel slideshowViewModel =
                new ViewModelProvider(this).get(TelecomViewModel.class);

        binding = FragmentCouleursCuivreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
