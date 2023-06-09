package dev.azertim.orange_toolbox.ui.memo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import dev.azertim.orange_toolbox.R;
import dev.azertim.orange_toolbox.databinding.FragmentMemosBinding;

public class MemoFragment extends Fragment {

    private FragmentMemosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MemoViewModel galleryViewModel =
                new ViewModelProvider(this).get(MemoViewModel.class);

        binding = FragmentMemosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


//      COULEURS CUIVRE
//      Récupère le layout couleurs cuivre et lui associe une action onclick
<<<<<<< HEAD
        LinearLayout couleurscuivreLayout = root.findViewById(R.id.couleurscuivreLayout);
        couleurscuivreLayout.setOnClickListener(new View.OnClickListener() {
=======
        LinearLayout attenuationfibreLayout = root.findViewById(R.id.couleurscuivreLayout);
        attenuationfibreLayout.setOnClickListener(new View.OnClickListener() {
>>>>>>> 7d9be275a5a430900132a724777e8b203447a603
            // Met a jour le fragment main avec la vue du mémo couleurs cuivre
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.cuivrecolorFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
            }
        });


<<<<<<< HEAD
//      COULEURS FIBRE
//      Récupère le layout couleurs fibre et lui associe une action onclick
        LinearLayout couleursfibreLayout = root.findViewById(R.id.couleursfibreLayout);
        couleursfibreLayout.setOnClickListener(new View.OnClickListener() {
            // Met a jour le fragment main avec la vue du mémo couleurs fibre
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.fibrecolorFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
            }
        });


=======
>>>>>>> 7d9be275a5a430900132a724777e8b203447a603



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}