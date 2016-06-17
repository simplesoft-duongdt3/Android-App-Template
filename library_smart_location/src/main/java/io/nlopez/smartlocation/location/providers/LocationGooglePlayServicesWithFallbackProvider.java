package io.nlopez.smartlocation.location.providers;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import io.nlopez.smartlocation.location.LocationProvider;
import io.nlopez.smartlocation.utils.GooglePlayServicesListener;

/**
 * Created by mrm on 20/12/14.
 */
public class LocationGooglePlayServicesWithFallbackProvider extends LocationProvider implements GooglePlayServicesListener {
    private boolean shouldStart = false;

    private LocationProvider provider;

    public LocationGooglePlayServicesWithFallbackProvider(Context context) {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(context);
        if (resultCode != ConnectionResult.SUCCESS) {
            provider = new LocationGooglePlayServicesProvider(this);
        } else {
            provider = new LocationManagerProvider();
        }
    }

    @Override
    public void initRequestLocation() {
        logger.d("Currently selected provider = " + provider.getClass().getSimpleName());
        provider.init(context, logger);
    }

    @Override
    public void startDetectLocation() {
        shouldStart = true;
        provider.start(listener, params, singleUpdate);
    }

    @Override
    public void stopDetectLocation() {
        provider.stop();
        shouldStart = false;
    }

    @Override
    public Location getLastLocation() {
        return provider.getLastLocation();
    }

    @Override
    public void onConnected(Bundle bundle) {
        // Nothing to do here
    }

    @Override
    public void onConnectionSuspended(int i) {
        fallbackToLocationManager();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        fallbackToLocationManager();
    }

    private void fallbackToLocationManager() {
        logger.d("FusedLocationProvider not working, falling back and using LocationManager");
        provider = new LocationManagerProvider();
        provider.init(context, logger);
        if (shouldStart) {
            provider.start(listener, params, singleUpdate);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        provider.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        provider.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
