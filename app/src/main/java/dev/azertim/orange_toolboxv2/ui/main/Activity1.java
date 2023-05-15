package dev.azertim.orange_toolboxv2.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Créer une nouvelle vue avec un fond jaune
        View view = new View(this);
        view.setBackgroundColor(Color.YELLOW);

        // Définir la vue comme vue de contenu de l'activité
        setContentView(view);
    }

}
