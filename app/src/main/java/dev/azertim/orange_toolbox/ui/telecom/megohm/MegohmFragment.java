package dev.azertim.orange_toolbox.ui.telecom.megohm;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import dev.azertim.orange_toolbox.R;

public class MegohmFragment extends Fragment {

    private String[] procedurePages;
    private int currentPageIndex;
    private TextView tvProcedure;
    private Button btnPreviousProcedure;
    private Button btnNextProcedure;
    private WebView webViewProcedure;

    public MegohmFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_megohm, container, false);

        webViewProcedure = view.findViewById(R.id.webViewProcedure);

        Button buttonEntrefils = view.findViewById(R.id.buttonEntrefils);
        buttonEntrefils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseProcedureFileEntrefils();
            }
        });

        Button buttonfilterre = view.findViewById(R.id.buttonFilTerre);
        buttonfilterre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseProcedureFileFilTerre();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button entrefilsButton = view.findViewById(R.id.buttonEntrefils);
        Button filterreButton = view.findViewById(R.id.buttonFilTerre);
        webViewProcedure = view.findViewById(R.id.webViewProcedure);
        btnPreviousProcedure = view.findViewById(R.id.btnPreviousProcedure);
        btnNextProcedure = view.findViewById(R.id.btnNextProcedure);


        btnPreviousProcedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToPreviousPage();
            }
        });

        btnNextProcedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToNextPage();
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void parseProcedureFileEntrefils() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.entrefils_procedure);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            inputStream.close();
            String rawProcedure = stringBuilder.toString();
            procedurePages = rawProcedure.split("-----");
            currentPageIndex = 0; // Réinitialiser currentPageIndex avant de charger la nouvelle procédure
            String currentProcedure = procedurePages[currentPageIndex];

            // Charger le contenu HTML dans le WebView
            String htmlContent = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/styles.css\"></head><body>" + currentProcedure + "</body></html>";
            webViewProcedure.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null);


            webViewProcedure.setBackgroundColor(android.R.color.transparent);





            updateProcedurePage(); // Mettre à jour l'affichage de la page de procédure
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressLint("ResourceAsColor")
    private void parseProcedureFileFilTerre() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.filterre_procedure);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            inputStream.close();
            String rawProcedure = stringBuilder.toString();
            procedurePages = rawProcedure.split("-----");
            currentPageIndex = 0; // Réinitialiser currentPageIndex avant de charger la nouvelle procédure
            String currentProcedure = procedurePages[currentPageIndex];

            // Charger le contenu HTML dans le WebView
            String htmlContent = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/styles.css\"></head><body>" + currentProcedure + "</body></html>";
            webViewProcedure.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null);


            webViewProcedure.setBackgroundColor(android.R.color.transparent);

            updateProcedurePage(); // Mettre à jour l'affichage de la page de procédure
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProcedurePage() {
        if (procedurePages != null && currentPageIndex >= 0 && currentPageIndex < procedurePages.length) {
            String currentProcedure = procedurePages[currentPageIndex];

            // Charger le contenu HTML dans le WebView
            webViewProcedure.loadDataWithBaseURL(null, currentProcedure, "text/html", "UTF-8", null);

            boolean hasText = !TextUtils.isEmpty(currentProcedure);
            btnPreviousProcedure.setVisibility(hasText ? View.VISIBLE : View.GONE);
            btnNextProcedure.setVisibility(hasText ? View.VISIBLE : View.GONE);

            btnPreviousProcedure.setEnabled(currentPageIndex > 0);
            btnNextProcedure.setEnabled(currentPageIndex < procedurePages.length - 1);
        }
    }


    private void navigateToPreviousPage() {
        if (currentPageIndex > 0) {
            currentPageIndex--;
            updateProcedurePage();
        }
    }

    private void navigateToNextPage() {
        if (currentPageIndex < procedurePages.length - 1) {
            currentPageIndex++;
            updateProcedurePage();
        }
    }


}
