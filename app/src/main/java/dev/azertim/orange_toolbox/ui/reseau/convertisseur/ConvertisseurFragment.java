package dev.azertim.orange_toolbox.ui.reseau.convertisseur;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dev.azertim.orange_toolbox.R;

public class ConvertisseurFragment extends Fragment {

    private EditText editTextBits;
    private Button buttonConvert1;
    private TextView textViewBytes;
    private EditText editTextBytes;
    private Button buttonConvert2;
    private TextView textViewBits;

    public ConvertisseurFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_convertisseur, container, false);

        editTextBits = view.findViewById(R.id.editTextBits);
        buttonConvert1 = view.findViewById(R.id.buttonConvert1);
        textViewBytes = view.findViewById(R.id.textViewBytes);
        editTextBytes = view.findViewById(R.id.editTextBytes);
        buttonConvert2 = view.findViewById(R.id.buttonConvert2);
        textViewBits = view.findViewById(R.id.textViewBits);


        buttonConvert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertBitsToBytes();
            }
        });

        buttonConvert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertBytesToBits();
            }
        });

        return view;
    }

    private void convertBitsToBytes() {
        String bitsStr = editTextBits.getText().toString();
        if (!bitsStr.isEmpty()) {
            int bits = Integer.parseInt(bitsStr);
            int bytes = bits / 8;
            int bits_restants = bits % 8;
            String resultat = bits + "bits  =  " + bytes + " bytes and " + bits_restants + " bits";
            textViewBytes.setText(resultat);
        }
    }

    private void convertBytesToBits() {
        String bitsStr = editTextBytes.getText().toString();
        if (!bitsStr.isEmpty()) {
            int bytes = Integer.parseInt(bitsStr);
            int bits = bytes * 8;

            String resultat = bytes + " bytes  =  " + bits + " bits";
            textViewBits.setText(resultat);
        }
    }
}

