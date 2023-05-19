package dev.azertim.orange_toolbox.ui.reseau;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import dev.azertim.orange_toolbox.R;
import dev.azertim.orange_toolbox.databinding.FragmentReseauBinding;
import dev.azertim.orange_toolbox.ui.reseau.calculatrice.CalculatriceFragment;
import dev.azertim.orange_toolbox.ui.reseau.convertisseur.ConvertisseurFragment;

public class ReseauFragment extends Fragment {

    private FragmentReseauBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReseauViewModel galleryViewModel =
                new ViewModelProvider(this).get(ReseauViewModel.class);

        binding = FragmentReseauBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout convertisseurLayout = root.findViewById(R.id.convertisseur);
        convertisseurLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Créer une instance du fragment
                ConvertisseurFragment convertisseurFragment = new ConvertisseurFragment();

                // Remplacer le fragment actuel par ConvertisseurFragment
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, convertisseurFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        LinearLayout calculatriceLayout = root.findViewById(R.id.calculatricecidr);
        calculatriceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Créer une instance du fragment
                CalculatriceFragment calculatriceFragment = new CalculatriceFragment();

                // Remplacer le fragment actuel par ConvertisseurFragment
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.nav_host_fragment_content_main, calculatriceFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });







        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}