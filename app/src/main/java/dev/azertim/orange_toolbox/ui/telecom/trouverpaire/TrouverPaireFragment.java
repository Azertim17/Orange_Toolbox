package dev.azertim.orange_toolbox.ui.telecom.trouverpaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import dev.azertim.orange_toolbox.R;

public class TrouverPaireFragment extends Fragment {

    // Map contenant les informations des paires
    private Map<Integer, String[]> pairsMap;

    private EditText pairNumberEditText;
    private Button getColorButton;
    private TextView toronColorTextView;
    private TextView pairColorTextView;
    private TextView accompagantColorTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trouverpaire, container, false);

        // Initialisation des vues
        pairNumberEditText = view.findViewById(R.id.pairNumberEditText);
        getColorButton = view.findViewById(R.id.getColorButton);
        toronColorTextView = view.findViewById(R.id.toronColorTextView);
        pairColorTextView = view.findViewById(R.id.pairColorTextView);
        accompagantColorTextView = view.findViewById(R.id.accompagantColorTextView);

        // Initialisation de la map des paires
        initializePairsMap();

        getColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Réinitialisation des valeurs des TextView
                toronColorTextView.setText("");
                pairColorTextView.setText("");
                accompagantColorTextView.setText("");

                // Récupération du numéro de paire entré par l'utilisateur
                int pairNumber = Integer.parseInt(pairNumberEditText.getText().toString());

                // Vérification si la paire existe dans la map
                if (pairsMap.containsKey(pairNumber)) {
                    // Récupération des informations de la paire
                    String[] pairInfo = pairsMap.get(pairNumber);

                    // Affichage des couleurs dans les TextView correspondants
                    toronColorTextView.setText(pairInfo[0]);
                    pairColorTextView.setText(pairInfo[1]);
                    accompagantColorTextView.setText(pairInfo[2]);
                } else {
                    // Si la paire n'existe pas, afficher un message d'erreur
                    toronColorTextView.setText("Paire non trouvée");
                }
            }
        });

        return view;
    }

    // Méthode pour initialiser la map des paires
    private void initializePairsMap() {
        pairsMap = new HashMap<>();

        // Lire le fichier contenant les informations des paires
        InputStream inputStream = getResources().openRawResource(R.raw.pairs_info);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                // Diviser chaque ligne en quatre parties : numéro de paire, couleur du toron, couleur de la paire, couleur de l'accompagnant
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int pairNumber = Integer.parseInt(parts[0].trim());
                    String toronColor = parts[1].trim();
                    String pairColor = parts[2].trim();
                    String accompagantColor = parts[3].trim();

                    pairsMap.put(pairNumber, new String[]{toronColor, pairColor, accompagantColor});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Fermer le lecteur de fichier
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
