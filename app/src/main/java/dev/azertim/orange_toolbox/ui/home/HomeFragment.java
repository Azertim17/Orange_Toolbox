package dev.azertim.orange_toolbox.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import dev.azertim.orange_toolbox.R;
import dev.azertim.orange_toolbox.databinding.FragmentHomeBinding;

import java.text.DecimalFormat;

public class
HomeFragment extends Fragment implements WeatherData.WeatherDataCallback {

    private FragmentHomeBinding binding;
    private TextView temperatureTextView;
    private TextView weatherConditionTextView;
    private TextView cityTextView;
    private ImageView weatherIconImageView;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageView image1 = root.findViewById(R.id.image1);
        ImageView image2 = root.findViewById(R.id.image2);
        ImageView image3 = root.findViewById(R.id.image3);
        ImageView image4 = root.findViewById(R.id.image4);
        ImageView image5 = root.findViewById(R.id.image5);

        // Set the images for the ImageView objects
//        image1.setImageResource(R.drawable.home);
//        image2.setImageResource(R.drawable.home);
//        image3.setImageResource(R.drawable.home);
//        image4.setImageResource(R.drawable.home);
//        image5.setImageResource(R.drawable.home);

        WeatherData weatherData = new WeatherData();
        temperatureTextView = root.findViewById(R.id.temperatureTextView);
        weatherConditionTextView = root.findViewById(R.id.weatherConditionTextView);
        weatherIconImageView = root.findViewById(R.id.weatherIconImageView);
        cityTextView = root.findViewById(R.id.cityTextView);

        // Fetch the weather data and update the UI
        weatherData.fetchWeatherData(this, requireContext());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onWeatherDataFetched(double temperature, String weather, String weatherIcon, String city) {
        // Convert temperature from Kelvin to Celsius
        double temperatureCelsius = temperature - 273.15;

        // Round the temperature to 1 decimal place
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String roundedTemperature = decimalFormat.format(temperatureCelsius);

        // Update the UI with the rounded temperature in Celsius
        temperatureTextView.setText(roundedTemperature + "°C");
        weatherConditionTextView.setText(weather);
        cityTextView.setText(city);
        loadWeatherIcon(weatherIcon);
    }


    private void loadWeatherIcon(String weatherIcon) {
        String iconUrl = "https://openweathermap.org/img/w/" + weatherIcon + ".png";

        Glide.with(requireContext())
                .load(iconUrl)
                .into(weatherIconImageView);
    }
}
