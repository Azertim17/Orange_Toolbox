package dev.azertim.orange_toolbox.ui.telecom;

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
import dev.azertim.orange_toolbox.databinding.FragmentTelecomBinding;

public class TelecomFragment extends Fragment {

    private FragmentTelecomBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TelecomViewModel slideshowViewModel =
                new ViewModelProvider(this).get(TelecomViewModel.class);

        binding = FragmentTelecomBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


//      ATTENUATION FIBRE
//      Récupère le layout fibre et lui associe une action onclick
        LinearLayout attenuationfibreLayout = root.findViewById(R.id.attenuationfibreLayout);
        attenuationfibreLayout.setOnClickListener(new View.OnClickListener() {
            // Met a jour le fragment main avec la vue de la page atténuation fibre
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.attenuationfibreFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
            }
        });

//      ATTENUATION CUIVRE
//      Récupère le layout cuivre et lui associe une action onclick
        LinearLayout attenuationcuivreLayout = root.findViewById(R.id.attenuationcuivreLayout);
        attenuationcuivreLayout.setOnClickListener(new View.OnClickListener() {
            // Met a jour le fragment main avec la vue de la page atténuation cuivre
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.attenuationcuivreFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
            }
        });

//        MESURES MEGOHM
//        Récupère le layout megohm et lui associe une action onclick
        LinearLayout megohmLayout = root.findViewById(R.id.megohmLayout);
        megohmLayout.setOnClickListener(new View.OnClickListener() {
            // Met a jour le fragment main avec la vue de la page mesures megohm
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.megohmFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
            }
        });

//        RETROUVER PAIRE CABLE
//        Récupère le layout retrouver paire et lui associe une action onclick
        LinearLayout paireLayout = root.findViewById(R.id.trouverpaireLayout);
        paireLayout.setOnClickListener(new View.OnClickListener() {
            // Met a jour le fragment main avec la vue de la page trouver paires
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.trouverpaireFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
            }
        });


//        RETROUVER PAIRE RDEG
//        Récupère le layout rdeg et lui associe une action onclick
        LinearLayout rdegLayout = root.findViewById(R.id.rdegLayout);
        rdegLayout.setOnClickListener(new View.OnClickListener() {
            // Met a jour le fragment main avec la vue de la page rdegFragment
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.rdegFragment, null, new NavOptions.Builder().setLaunchSingleTop(true).build());
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