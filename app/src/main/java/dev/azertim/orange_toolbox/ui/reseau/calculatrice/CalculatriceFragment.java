package dev.azertim.orange_toolbox.ui.reseau.calculatrice;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.net.InetAddress;
import java.net.UnknownHostException;

import dev.azertim.orange_toolbox.R;

public class CalculatriceFragment extends Fragment {

    private EditText etNetworkAddress;
    private Button btnCalculate;
    private TextView tvSubnetMask, tvInvertedMask, tvFirstAddress, tvLastAddress, tvHostCount;

    public CalculatriceFragment() {
        // Constructeur par défaut requis pour les fragments
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflater le layout pour ce fragment
        return inflater.inflate(R.layout.fragment_calculatrice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialisation des vues (EditText, Button, TextView)
        etNetworkAddress = view.findViewById(R.id.networkAddressEditText);
        btnCalculate = view.findViewById(R.id.calculateButton);
        tvSubnetMask = view.findViewById(R.id.subnetMaskTextView);
        tvInvertedMask = view.findViewById(R.id.invertedMaskTextView);
        tvFirstAddress = view.findViewById(R.id.firstAddressTextView);
        tvLastAddress = view.findViewById(R.id.lastAddressTextView);
        tvHostCount = view.findViewById(R.id.hostCountTextView);

        // Définition de l'action à effectuer lors du clic sur le bouton "Calculer"
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateNetworkInfo();
            }
        });
    }

    private void calculateNetworkInfo() {
        // Récupération de l'adresse réseau avec le masque saisie par l'utilisateur
        String networkAddressWithMask = etNetworkAddress.getText().toString().trim();

        if (networkAddressWithMask.isEmpty()) {
            etNetworkAddress.setError("Enter a network address with mask");
            return;
        }

        try {
            // Séparation de l'adresse IP et du masque
            String[] parts = networkAddressWithMask.split("/");
            String ipAddress = parts[0];
            int maskBits = Integer.parseInt(parts[1]);

            // Conversion de l'adresse IP en objet InetAddress
            InetAddress networkAddress = InetAddress.getByName(ipAddress);
            int address = byteArrayToInt(networkAddress.getAddress());

            // Calcul du masque et du masque inversé
            int mask = (0xFFFFFFFF << (32 - maskBits)) & 0xFFFFFFFF;
            int invertedMask = ~mask & 0xFFFFFFFF;

            // Calcul de la première adresse utilisable pour un hôte
            int firstAddress = (address & mask) + 1;

            // Calcul de la dernière adresse utilisable pour un hôte (adresse de diffusion)
            int lastAddress = (address | ~mask) - 1;

            // Calcul du nombre d'hôtes
            int hostCount = lastAddress - firstAddress + 1;

            // Affichage des résultats dans les TextView correspondants
            tvSubnetMask.setText(intToIpAddress(mask));
            tvInvertedMask.setText(intToIpAddress(invertedMask));
            tvFirstAddress.setText(intToIpAddress(firstAddress));
            tvLastAddress.setText(intToIpAddress(lastAddress));
            tvHostCount.setText(String.valueOf(hostCount));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            etNetworkAddress.setError("Invalid network address format");
        } catch (ArrayIndexOutOfBoundsException e){
            etNetworkAddress.setError("Invalid network address format");
        } catch (NetworkOnMainThreadException e) {
            etNetworkAddress.setError("Invalid network address format");
        }
    }

    // Conversion d'un tableau de bytes en entier
    private int byteArrayToInt(byte[] bytes) {
        int value = 0;
        for (int i = 0; i < bytes.length; i++) {
            value = (value << 8) | (bytes[i] & 0xFF);
        }
        return value;
    }

    // Conversion d'un entier en adresse IP au format String
    private String intToIpAddress(int value) {
        return ((value >> 24) & 0xFF) + "." +
                ((value >> 16) & 0xFF) + "." +
                ((value >> 8) & 0xFF) + "." +
                (value & 0xFF);
    }
}
