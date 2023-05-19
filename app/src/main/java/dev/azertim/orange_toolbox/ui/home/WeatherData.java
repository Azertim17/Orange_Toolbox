package dev.azertim.orange_toolbox.ui.home;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class WeatherData {

    private static final String TAG = "WeatherData";
    private static final String API_KEY = "8518a71e450e79369b36c0ebce2a9f23";
    private static final String API_URL_FORMAT = "https://api.openweathermap.org/data/2.5/weather?lat=%.6f&lon=%.6f&appid=%s&lang=fr";
    private WeatherDataCallback callback;
    private OkHttpClient httpClient;

    private String iconUrl;
    private LocationUtil locationUtil;

    public interface WeatherDataCallback {
        void onWeatherDataFetched(double temperature, String weather, String weatherIcon, String city);
    }

    public void fetchWeatherData(WeatherDataCallback callback, Context context) {
        this.callback = callback;

        locationUtil = new LocationUtil(context);
        locationUtil.fetchLocationData(new LocationUtil.LocationDataCallback() {
            @Override
            public void onLocationDataReceived(double latitude, double longitude) {
                String apiUrl = String.format(API_URL_FORMAT, latitude, longitude, API_KEY);
                Request request = new Request.Builder().url(apiUrl).build();

        httpClient = new OkHttpClient();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Failed to fetch weather data: " + e.getMessage());
                // Handle request failure
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try (ResponseBody responseBody = response.body()) {
                        if (responseBody != null) {
                            String jsonData = responseBody.string();
                            JSONObject jsonObject = new JSONObject(jsonData);
                            double temperature = jsonObject.getJSONObject("main").getDouble("temp");
                            JSONArray weatherArray = jsonObject.getJSONArray("weather");
                            JSONObject weatherObject = weatherArray.getJSONObject(0);
                            String weather = weatherObject.getString("description");
                            String weatherIcon = weatherObject.getString("icon");
                            String cityName = jsonObject.getString("name");


                            // Run the callback on the UI thread
                            Handler handler = new Handler(Looper.getMainLooper());
                            handler.post(() -> callback.onWeatherDataFetched(temperature,weather,weatherIcon,cityName));
                        }
                    } catch (JSONException e) {
                        Log.e(TAG, "Failed to parse weather data: " + e.getMessage());
                    }
                } else {
                    Log.e(TAG, "Failed to fetch weather data: " + response.code());
                }
            }
        });
    }
});
    }
}
