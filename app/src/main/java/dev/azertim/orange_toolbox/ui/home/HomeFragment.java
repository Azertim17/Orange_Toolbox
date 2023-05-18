package dev.azertim.orange_toolbox.ui.home;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import dev.azertim.orange_toolbox.R;
import dev.azertim.orange_toolbox.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    public static final int REQUEST_LOCATION_PERMISSION = 1;
    private FragmentHomeBinding binding;
    private TextView temperatureTextView;
    private TextView weatherDescriptionTextView;
    private TextView latitudeTextView;
    private TextView longitudeTextView;
    private TextView weather;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageView image1 = root.findViewById(R.id.image1);
        ImageView image2 = root.findViewById(R.id.image2);
        ImageView image3 = root.findViewById(R.id.image3);
        ImageView image4 = root.findViewById(R.id.image4);
        ImageView image5 = root.findViewById(R.id.image5);

        // Set the images for the ImageView objects
        image1.setImageResource(R.drawable.home);
        image2.setImageResource(R.drawable.home);
        image3.setImageResource(R.drawable.home);
        image4.setImageResource(R.drawable.home);
        image5.setImageResource(R.drawable.home);

        return root;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        temperatureTextView = view.findViewById(R.id.temperatureTextView);
        weatherDescriptionTextView = view.findViewById(R.id.weatherDescriptionTextView);
        latitudeTextView = view.findViewById(R.id.latitudeTextView);
        longitudeTextView = view.findViewById(R.id.longitudeTextView);
        weather = view.findViewById(R.id.weather_text);

        weather.setText(R.id.temperatureTextView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
