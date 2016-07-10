package tinyapps.apptemplate.base.service;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesWithFallbackProvider;
import tinyapps.apptemplate.base.util.LocationUtil;

/**
 * Created by duongdt3 on 6/17/2016.
 */
public class LocationService extends Service implements OnLocationUpdatedListener {

    private SmartLocation.LocationControl locationControl;

    @Override
    public void onCreate() {
        super.onCreate();
        initGps();
    }

    private void initGps() {
        locationControl = new SmartLocation.Builder(this)
                .logging(true)
                .build()
                .location(new LocationGooglePlayServicesWithFallbackProvider(this));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        locationControl.stop();
        locationControl.config(LocationUtil.BEST_EFFORT).continuous().start(this);
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationControl != null) {
            locationControl.stop();
        }
    }

    @Override
    public void onLocationUpdated(Location location) {
        Log.d("LocationService", "onLocationUpdated " + location);
    }

    @Override
    public void onMockLocationDetect() {

    }
}
