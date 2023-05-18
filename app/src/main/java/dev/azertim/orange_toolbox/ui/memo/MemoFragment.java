package dev.azertim.orange_toolbox.ui.memo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import dev.azertim.orange_toolbox.databinding.FragmentMemosBinding;

public class MemoFragment extends Fragment {

    private FragmentMemosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MemoViewModel galleryViewModel =
                new ViewModelProvider(this).get(MemoViewModel.class);

        binding = FragmentMemosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMemo;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}