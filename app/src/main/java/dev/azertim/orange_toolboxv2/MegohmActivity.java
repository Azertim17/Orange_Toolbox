package dev.azertim.orange_toolboxv2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import dev.azertim.orange_toolboxv2.databinding.ActivityMegohmBinding;

public class MegohmActivity extends Activity {
    private ActivityMegohmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMegohmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}

