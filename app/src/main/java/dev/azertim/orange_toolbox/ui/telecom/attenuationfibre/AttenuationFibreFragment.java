package dev.azertim.orange_toolbox.ui.telecom.attenuationfibre;

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

public class AttenuationFibreFragment extends Fragment {

    private EditText etLength;
    private TextView tvResult;
    private Button btnCalculate;

    public AttenuationFibreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attenuation_fibre, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etLength = view.findViewById(R.id.etLength);
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
        String lengthStr = etLength.getText().toString().trim();

        if (lengthStr.isEmpty()) {
            tvResult.setText("Veuillez renseigner une longueur de fibre");
            return;
        }

        double length = Double.parseDouble(lengthStr);

        String attenuationresult = calculateAttenuationFormula(length);
        tvResult.setText(attenuationresult);
    }

    private String calculateAttenuationFormula(double length) {
        double attenuationConstant = 0.2; // Atténuation linéique fibre Orange 1550nm
        double attenuation = attenuationConstant * length;

        if (attenuation >= 0) {
            // Display the calculated attenuation in your UI or perform any other necessary actions
            String attenuationText = "Attenuation: " + String.format("%.2f", attenuation) + " dB  pour " + length + " km";

            return attenuationText;
        } else {
            // Show an error toast message indicating an invalid input or calculation error
            Toast.makeText(requireContext(), "Invalid input or calculation error", Toast.LENGTH_SHORT).show();
            return "";
        }
    }


}
