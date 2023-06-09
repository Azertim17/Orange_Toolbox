package dev.azertim.orange_toolbox.ui.memo.couleursfibre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import dev.azertim.orange_toolbox.databinding.FragmentCouleursCuivreBinding;
import dev.azertim.orange_toolbox.databinding.FragmentCouleursFibreBinding;
import dev.azertim.orange_toolbox.ui.telecom.TelecomViewModel;

public class CouleursFibreMemoFragment extends Fragment {

    private FragmentCouleursFibreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TelecomViewModel slideshowViewModel =
                new ViewModelProvider(this).get(TelecomViewModel.class);

        binding = FragmentCouleursFibreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
