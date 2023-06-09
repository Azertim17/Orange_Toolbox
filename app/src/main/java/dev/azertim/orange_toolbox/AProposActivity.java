package dev.azertim.orange_toolbox;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

public class AProposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_apropos);

        // Activer le bouton de retour dans la barre d'action
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Gérer les événements de clic sur les éléments du menu
        if (item.getItemId() == android.R.id.home) {
            // Clic sur le bouton de retour
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
