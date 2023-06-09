package dev.azertim.orange_toolbox.ui.memo.couleursfibre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import dev.azertim.orange_toolbox.databinding.FragmentCouleursCuivreBinding;
<<<<<<< HEAD
import dev.azertim.orange_toolbox.databinding.FragmentCouleursFibreBinding;
=======
>>>>>>> 7d9be275a5a430900132a724777e8b203447a603
import dev.azertim.orange_toolbox.ui.telecom.TelecomViewModel;

public class CouleursFibreMemoFragment extends Fragment {

<<<<<<< HEAD
    private FragmentCouleursFibreBinding binding;
=======
    private FragmentCouleursCuivreBinding binding;
>>>>>>> 7d9be275a5a430900132a724777e8b203447a603

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TelecomViewModel slideshowViewModel =
                new ViewModelProvider(this).get(TelecomViewModel.class);

<<<<<<< HEAD
        binding = FragmentCouleursFibreBinding.inflate(inflater, container, false);
=======
        binding = FragmentCouleursCuivreBinding.inflate(inflater, container, false);
>>>>>>> 7d9be275a5a430900132a724777e8b203447a603
        View root = binding.getRoot();




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
