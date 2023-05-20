package dev.azertim.orange_toolbox.ui.reseau;

import android.app.Activity;
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
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

import dev.azertim.orange_toolbox.MainActivity;
import dev.azertim.orange_toolbox.R;
import dev.azertim.orange_toolbox.databinding.FragmentReseauBinding;
import dev.azertim.orange_toolbox.ui.reseau.calculatrice.CalculatriceFragment;
import dev.azertim.orange_toolbox.ui.reseau.convertisseur.ConvertisseurFragment;

public class ReseauFragment extends Fragment {

    private FragmentReseauBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentReseauBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//      CONVERTISSEUR
//      Récupère le layout convertisseur et lui associe une action onclick
        LinearLayout convertisseurLayout = root.findViewById(R.id.convertisseur);
        convertisseurLayout.setOnClickListener(new View.OnClickListener() {
//          Met a jour le fragment main avec la vue du convertisseur
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.convertisseurFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
            }
        });

//      CALCULATRICE CIDR
//      Récupère le layout calculatrice et lui associe une action onclick
        LinearLayout calculatriceLayout = root.findViewById(R.id.calculatricecidr);
        calculatriceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Met a jour le fragment main avec la vue de la calculatrice
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.calculatriceFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
            }
        });

//      COMMANDES CISCO
//      Récupère le layout cisco et lui associe une action onclick
        LinearLayout ciscoLayout = root.findViewById(R.id.cisco);
        ciscoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Met a jour le fragment main avec la vue des commandes cisco
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.ciscoFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
            }
        });

//      COMMANDES ONEACCESS
//      Récupère le layout oneaccess et lui associe une action onclick
        LinearLayout oneaccessLayout = root.findViewById(R.id.oneaccess);
        oneaccessLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Met a jour le fragment main avec la vue des commandes oneaccess
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.oneAccessFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
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