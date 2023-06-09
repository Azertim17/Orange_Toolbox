package dev.azertim.orange_toolbox.ui.home;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LocationUtil implements LocationListener {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private LocationDataCallback callback;
    private Context context;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 123;

    public interface LocationDataCallback {
        void onLocationDataReceived(double latitude, double longitude);
    }

    public LocationUtil(Context context) {
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public void fetchLocationData(LocationDataCallback callback) {
        this.callback = callback;

        // Vérifier si l'autorisation d'accès à la localisation est accordée
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Si les autorisations ne sont pas accordées, demander la permission
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);

            // Sortir de la méthode et attendre que l'utilisateur accorde les autorisations
            return;
        }

        try {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        if (callback != null) {
            callback.onLocationDataReceived(latitude, longitude);
        }
        locationManager.removeUpdates(this);
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}
