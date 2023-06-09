package dev.azertim.orange_toolbox.ui.telecom.rdeg;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.azertim.orange_toolbox.R;

public class RdegFragment extends Fragment {

    private EditText pairNumberEditText;
    private Button findPositionButton;
    private TextView resultTextView;
    private ViewGroup rdegLayout;

    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rdeg, container, false);

        // Initialisation des vues
        pairNumberEditText = view.findViewById(R.id.pairNumberEditText);
        findPositionButton = view.findViewById(R.id.findPositionButton);
        resultTextView = view.findViewById(R.id.resultTextView);
        rdegLayout = view.findViewById(R.id.rdegLayout);

        findPositionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pairNumber = Integer.parseInt(pairNumberEditText.getText().toString());

                if (pairNumber >= 1 && pairNumber <= 98) {
                    int row = (pairNumber - 1) / 7 + 1;
                    int column = (pairNumber - 1) % 7 + 1;

                    resultTextView.setText("Ligne : " + row + ", Colonne : " + column);




                    // Mettre en couleur la case correspondante dans le Rdeg
                    clearRdegHighlights();
                    highlightRdegCell(row, column);
                } else {
                    resultTextView.setText("Numéro de paire invalide");
                    clearRdegHighlights();
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Générer les vues du Rdeg
        int rows = 14;
        int columns = 7;

        for (int i = 1; i <= rows; i++) {
            LinearLayout rowLayout = new LinearLayout(getContext());
            rowLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);

            for (int j = 1; j <= columns; j++) {
                View cellView = new View(getContext());
                int cellSize = getResources().getDimensionPixelSize(R.dimen.rdeg_cell_size);
                int cellMargin = getResources().getDimensionPixelSize(R.dimen.rdeg_cell_margin);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(cellSize, cellSize);
                params.setMargins(cellMargin, cellMargin, cellMargin, cellMargin);
                cellView.setLayoutParams(params);
                cellView.setBackgroundColor(getResources().getColor(R.color.Color_cell_rdeg));

                // Attribuer un ID unique basé sur les coordonnées de la cellule
                String cellId = i + "_" + j;
                cellView.setTag(cellId);
                Log.d("RdegFragment", "Cell ID: " + cellId);

                // Ajouter la vue de la cellule au LinearLayout de la ligne
                rowLayout.addView(cellView);
            }

            // Ajouter le LinearLayout de la ligne au LinearLayout du Rdeg
            rdegLayout.addView(rowLayout);
        }
    }

    private void highlightRdegCell(int row, int column) {
        String cellId = row + "_" + column;
        View cellView = rdegLayout.findViewWithTag(cellId);
        if (cellView != null) {
            cellView.setBackgroundColor(getResources().getColor(R.color.Orange));
        }
    }

    private void clearRdegHighlights() {
        int rows = 14;
        int columns = 7;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                String cellId = i + "_" + j;
                View cellView = rdegLayout.findViewWithTag(cellId);
                if (cellView != null) {
                    cellView.setBackgroundColor(getResources().getColor(R.color.Color_cell_rdeg));
                }
            }
        }
    }


}
