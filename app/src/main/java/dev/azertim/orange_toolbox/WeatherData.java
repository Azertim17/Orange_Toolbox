package dev.azertim.orange_toolbox;

import static dev.azertim.orange_toolbox.ui.home.HomeFragment.REQUEST_LOCATION_PERMISSION;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.text.BreakIterator;

public class WeatherData extends Fragment implements LocationListener {

    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private LocationManager locationManager;
    private OkHttpClient httpClient;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        httpClient = new OkHttpClient();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        } else {
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        // Effectuer la requête à l'API OpenWeatherMap
        String apiKey = "8518a71e450e79369b36c0ebce2a9f23";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + apiKey;

        Log.i("myTag", apiUrl);

        Request request = new Request.Builder()
                .url(apiUrl)
                .build();


        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                // Gérer l'échec de la requête
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    if (responseBody != null) {
                        String responseData = responseBody.string();

                        try {
                            JSONObject jsonObject = new JSONObject(responseData);

                            // Récupérer les données météo spécifiques de l'objet JSON
                            JSONObject mainObject = jsonObject.getJSONObject("main");
                            double temperature = mainObject.getDouble("temp");

                            JSONObject weatherObject = jsonObject.getJSONArray("weather").getJSONObject(0);
                            String weatherDescription = weatherObject.getString("description");

                            JSONObject coordObject = jsonObject.getJSONObject("coord");
                            double latitude = coordObject.getDouble("lat");
                            double longitude = coordObject.getDouble("lon");

                            // Utiliser les valeurs récupérées comme nécessaire
                            // Par exemple, vous pouvez les afficher dans un TextView
                            BreakIterator temperatureTextView = null;
                            BreakIterator weatherDescriptionTextView = null;
                            BreakIterator latitudeTextView = null;
                            BreakIterator longitudeTextView = null;

                            temperatureTextView.setText("Temperature: " + temperature + "°C");
                            weatherDescriptionTextView.setText("Weather: " + weatherDescription);
                            latitudeTextView.setText("Latitude: " + latitude);
                            longitudeTextView.setText("Longitude: " + longitude);

                            temperatureTextView.setText("Temperature: " + temperature + "°C");
                            weatherDescriptionTextView.setText("Weather: " + weatherDescription);
                            latitudeTextView.setText("Latitude: " + latitude);
                            longitudeTextView.setText("Longitude: " + longitude);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });
    }

    // Autres méthodes de l'interface LocationListener (onStatusChanged, onProviderEnabled, onProviderDisabled)
    // ...

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
                }
            } else {
                // La permission de localisation a été refusée
            }
        }
    }
}
