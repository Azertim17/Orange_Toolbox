package dev.azertim.orange_toolbox.ui.telecom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import dev.azertim.orange_toolbox.databinding.FragmentTelecomBinding;

public class TelecomFragment extends Fragment {

    private FragmentTelecomBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TelecomViewModel slideshowViewModel =
                new ViewModelProvider(this).get(TelecomViewModel.class);

        binding = FragmentTelecomBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}