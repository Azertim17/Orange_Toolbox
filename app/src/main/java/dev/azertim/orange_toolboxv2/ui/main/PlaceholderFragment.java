package dev.azertim.orange_toolboxv2.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import dev.azertim.orange_toolboxv2.MegohmActivity;
import dev.azertim.orange_toolboxv2.R;
import dev.azertim.orange_toolboxv2.databinding.FragmentMainBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentMainBinding binding;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, 300); // parametre d'images : 300*300 pixels
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT); // parametre des bouttons


        /**
         * Onglet Te ecom
         */

        if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {

            /**
             * Outil Megohm
             */

            ImageView img_megohm = new ImageView(requireContext());
            img_megohm.setImageResource(R.drawable.megohm);

            Button megohm = new Button(requireContext());
            megohm.setText("interprétation mesures megohmmètre");
            megohm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), MegohmActivity.class);
                    startActivity(intent);
                }
            });
            img_megohm.setLayoutParams(params);
            megohm.setLayoutParams(params2);

            binding.horizontalView1.addView(img_megohm); //Ajoute le bouton megohm sur l'onglet telecom
            binding.horizontalView1.addView(megohm);


            /**
             * Outil paire dans un cable
             */

            ImageView img_cable = new ImageView(requireContext());
            img_cable.setImageResource(R.drawable.cuivre);

            Button cable = new Button(requireContext());
            cable.setText("retrouver une paire dans un câble");
            cable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), MegohmActivity.class);
                    startActivity(intent);
                }
            });
            img_cable.setLayoutParams(params);
            cable.setLayoutParams(params2);

            binding.horizontalView2.addView(img_cable); //Ajoute le bouton pour l'outil paire dans un cable sur l'onglet telecom
            binding.horizontalView2.addView(cable);


            /**
             * Outil paire dans Rdeg
             */

            ImageView img_rdeg = new ImageView(requireContext());
            img_rdeg.setImageResource(R.drawable.rdeg);

            Button rdeg = new Button(requireContext());
            rdeg.setText("retrouver une paire dans un Rdeg");
            rdeg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), MegohmActivity.class);
                    startActivity(intent);
                }
            });
            img_rdeg.setLayoutParams(params);
            rdeg.setLayoutParams(params2);

            binding.horizontalView3.addView(img_rdeg); //Ajoute le bouton pour l'outil paire dans un Rdeg sur l'onglet telecom
            binding.horizontalView3.addView(rdeg);


            /**
             * Outil atténuation
             */

            ImageView img_attenuation = new ImageView(requireContext());
            img_attenuation.setImageResource(R.drawable.cablecuivre);

            Button attenuation = new Button(requireContext());
            attenuation.setText("Calculer l'atténuation d'un câble cuivre");
            attenuation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), MegohmActivity.class);
                    startActivity(intent);
                }
            });
            img_attenuation.setLayoutParams(params);
            attenuation.setLayoutParams(params2);

            binding.horizontalView4.addView(img_attenuation); //Ajoute le bouton attenuation sur l'onglet telecom
            binding.horizontalView4.addView(attenuation);



        }



        /**
         * Onglet Réseaux
         */

        if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {

            Button button3 = new Button(requireContext());
            button3.setText("Lancer activity 3");
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Activity1.class);
                    startActivity(intent);
                }
            });
            binding.fragmentView.addView(button3); //Ajoute le bouton 3 sur l'onglet réseaux

            Button button4 = new Button(requireContext());
            button4.setText("Lancer activity 4");
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Activity2.class);
                    startActivity(intent);
                }
            });
            binding.fragmentView.addView(button4); //Ajoute le bouton 4 sur l'onglet réseaux
        }

        /**
         * Onglet Mémo
         */

        if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {

            Button button5 = new Button(requireContext());
            button5.setText("Lancer activity 5");
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Activity1.class);
                    startActivity(intent);
                }
            });
            binding.fragmentView.addView(button5); //Ajoute le bouton 5 sur l'onglet Mémo

            Button button6 = new Button(requireContext());
            button6.setText("Lancer activity 6");
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Activity2.class);
                    startActivity(intent);
                }
            });
            binding.fragmentView.addView(button6); //Ajoute le bouton 6 sur l'onglet Mémo
        }


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
