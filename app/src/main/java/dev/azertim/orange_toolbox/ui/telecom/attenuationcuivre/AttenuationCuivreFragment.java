package dev.azertim.orange_toolbox.ui.telecom.attenuationcuivre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.azertim.orange_toolbox.R;

public class AttenuationCuivreFragment extends Fragment {

    private EditText etLength0_4mm;
    private EditText etLength0_5mm;
    private EditText etLength0_6mm;
    private EditText etLength0_8mm;
    private TextView tvResult;
    private Button btnCalculate;

    public AttenuationCuivreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attenuation_cuivre, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etLength0_4mm = view.findViewById(R.id.etLength0_4mm);
        etLength0_5mm = view.findViewById(R.id.etLength0_5mm);
        etLength0_6mm = view.findViewById(R.id.etLength0_6mm);
        etLength0_8mm = view.findViewById(R.id.etLength0_8mm);
        tvResult = view.findViewById(R.id.tvResult);
        btnCalculate = view.findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAttenuation();
            }
        });
    }

    private void calculateAttenuation() {
        String length0_4mmStr = etLength0_4mm.getText().toString().trim();
        String length0_5mmStr = etLength0_5mm.getText().toString().trim();
        String length0_6mmStr = etLength0_6mm.getText().toString().trim();
        String length0_8mmStr = etLength0_8mm.getText().toString().trim();

        if (length0_4mmStr.isEmpty() || length0_5mmStr.isEmpty() || length0_6mmStr.isEmpty() || length0_8mmStr.isEmpty()) {
            tvResult.setText("Veuillez renseigner toutes les longueurs de câbles");
            return;
        }

        double length0_4mm = Double.parseDouble(length0_4mmStr);
        double length0_5mm = Double.parseDouble(length0_5mmStr);
        double length0_6mm = Double.parseDouble(length0_6mmStr);
        double length0_8mm = Double.parseDouble(length0_8mmStr);

        double attenuation = calculateTotalAttenuation(length0_4mm, length0_5mm, length0_6mm, length0_8mm);

        if (attenuation >= 0) {
            // Display the calculated attenuation in your UI or perform any other necessary actions
            String attenuationText = "Attenuation totale : " + String.format("%.2f", attenuation) + " dB";
            tvResult.setText(attenuationText);
        } else {
            // Show an error toast message indicating an invalid input or calculation error
            Toast.makeText(requireContext(), "Invalid input or calculation error", Toast.LENGTH_SHORT).show();
            tvResult.setText("");
        }
    }

    private double calculateTotalAttenuation(double length0_4mm, double length0_5mm, double length0_6mm, double length0_8mm) {
        double attenuation0_4mm = length0_4mm * 15;
        double attenuation0_5mm = length0_5mm * 12.4;
        double attenuation0_6mm = length0_6mm * 10.3;
        double attenuation0_8mm = length0_8mm * 7.9;
        double totalAttenuation = attenuation0_4mm + attenuation0_5mm + attenuation0_6mm + attenuation0_8mm + 1.5;
        return totalAttenuation;
    }
}
