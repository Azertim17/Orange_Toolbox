package dev.azertim.orange_toolbox.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import dev.azertim.orange_toolbox.WeatherData;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    private MutableLiveData<WeatherData> weatherData = new MutableLiveData<>();

    public LiveData<WeatherData> getWeatherData() {
        return weatherData;
    }

    public void fetchWeatherData(double latitude, double longitude) {
        // Appel à l'API de météo pour récupérer les données en fonction de la latitude et de la longitude
        // Vous pouvez utiliser une bibliothèque comme Retrofit pour effectuer l'appel API

        // Une fois que vous avez récupéré les données de météo, vous pouvez les mettre à jour dans le LiveData
        WeatherData data = new WeatherData(); // Créez une classe WeatherData pour stocker les informations de météo
        weatherData.setValue(data);
    }
}