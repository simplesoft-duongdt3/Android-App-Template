package io.nlopez.smartlocation.location.providers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;

import io.nlopez.smartlocation.location.LocationProvider;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

/**
 * Created by nacho on 12/23/14.
 */
public class LocationManagerProvider extends LocationProvider implements LocationListener {
    private static final String LOCATIONMANAGERPROVIDER_ID = "LMP";
    private LocationManager locationManager;

    @Override
    public void initRequestLocation() {
        this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public void startDetectLocation() {
        if (listener == null) {
            logger.d("Listener is null, you sure about this?");
        }
        start();
    }

    private void start() {
        Criteria criteria = getProvider(params);
        if (checkGpsPermission()) {
            if (singleUpdate) {
                locationManager.requestSingleUpdate(criteria, this, Looper.getMainLooper());
            } else {
                locationManager.requestLocationUpdates(params.getInterval(), params.getDistance(), criteria, this, Looper.getMainLooper());
            }
        }
    }

    @Override
    public void stopDetectLocation() {
        if (checkGpsPermission()) {
            locationManager.removeUpdates(this);
        }
    }

    @Override
    public Location getLastLocation() {
        if (locationManager != null) {
            if (checkGpsPermission()) {
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    return location;
                }
            }
        }

        return getCacheLocationFromStore(LOCATIONMANAGERPROVIDER_ID);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //do nothing
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_ID && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            start();
        }
    }

    private Criteria getProvider(LocationParams params) {
        final LocationAccuracy accuracy = params.getAccuracy();
        final Criteria criteria = new Criteria();
        switch (accuracy) {
            case HIGH:
                changeCriteria(criteria, Criteria.ACCURACY_FINE, Criteria.ACCURACY_HIGH, Criteria.POWER_HIGH);
                break;
            case MEDIUM:
                changeCriteria(criteria, Criteria.ACCURACY_COARSE, Criteria.ACCURACY_MEDIUM, Criteria.POWER_MEDIUM);
                break;
            case LOW:
            case LOWEST:
            default:
                changeCriteria(criteria, Criteria.ACCURACY_COARSE, Criteria.ACCURACY_LOW, Criteria.POWER_LOW);
        }
        return criteria;
    }

    private void changeCriteria(Criteria criteria, int accuracy, int accuracyMinor, int power) {
        criteria.setAccuracy(accuracy);
        criteria.setHorizontalAccuracy(accuracyMinor);
        criteria.setVerticalAccuracy(accuracyMinor);
        criteria.setBearingAccuracy(accuracyMinor);
        criteria.setSpeedAccuracy(accuracyMinor);
        criteria.setPowerRequirement(power);
    }

    @Override
    public void onLocationChanged(Location location) {
        publishLocationReceive(location, LOCATIONMANAGERPROVIDER_ID);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //do nothing
    }

    @Override
    public void onProviderEnabled(String provider) {
        //do nothing
    }

    @Override
    public void onProviderDisabled(String provider) {
        //do nothing
    }
}
