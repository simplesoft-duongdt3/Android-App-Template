package io.nlopez.smartlocation.location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.location.config.LocationParams;
import io.nlopez.smartlocation.utils.Logger;

/**
 * Created by mrm on 20/12/14.
 */
public abstract class LocationProvider {
    public static final int REQUEST_START_LOCATION_FIX = 9000001;
    public static final int REQUEST_CHECK_SETTINGS = 9000002;
    public static final int LOCATION_PERMISSION_ID = 9000003;

    protected Logger logger;
    protected Context context;
    protected OnLocationUpdatedListener listener;
    protected LocationParams params;
    protected boolean singleUpdate;
    protected LocationStore locationStore;

    private boolean isMockSettingOnStartRequest = false;
    private Location mockLocation;
    private Location mockLocationPre;

    public final void init(Context context, Logger logger) {
        this.logger = logger;
        this.context = context;
        locationStore = new LocationStore(context);
        initRequestLocation();
    }

    protected abstract void initRequestLocation();

    public final void start(OnLocationUpdatedListener listener, LocationParams params, boolean singleUpdate) {
        this.listener = listener;
        this.params = params;
        this.singleUpdate = singleUpdate;
        isMockSettingOnStartRequest = isSettingMockLocation();
        startDetectLocation();
    }

    protected abstract void startDetectLocation();

    public final void stop() {
        stopDetectLocation();
    }

    protected abstract void stopDetectLocation();

    public abstract Location getLastLocation();

    public abstract void onActivityResult(int requestCode, int resultCode, Intent data);

    public abstract void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);

    protected boolean checkGpsPermission() {
        boolean isPass = true;
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            isPass = false;
            if (context instanceof Activity) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_ID);
            } else {
                //show notification
                //or show dialog
                //show activity
            }
        }
        return isPass;
    }

    protected boolean checkMockLocation(Location location) {
        boolean isMockLocation = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 && location.isFromMockProvider();
        boolean isMockSettingNow = isSettingMockLocation();
        boolean isMockLocationDetect = true;
        if (isMockLocation || isMockSettingNow || this.isMockSettingOnStartRequest) {
            this.mockLocation = location;
        } else {
            //avoid 1 location (because it can mock location cache)
            if (this.mockLocation != null) {
                this.mockLocationPre = this.mockLocation;
                this.mockLocation = null;
            } else if (this.mockLocationPre != null) {
                this.mockLocationPre = null;
            } else {
                isMockLocationDetect = false;
            }
        }

        return isMockLocationDetect;
    }

    protected void publishLocationReceive(Location location, String keyCache) {
        logger.d("onLocationChanged", location);
        if (location != null) {
            if (checkMockLocation(location)) {
                logger.d("onLocationChanged", "is mock " + location);
                if (listener != null) {
                    listener.onMockLocationDetect();
                }
            } else {
                if (listener != null) {
                    listener.onLocationUpdated(location);
                }
                if (locationStore != null) {
                    logger.d("Stored in SharedPreferences");
                    locationStore.put(keyCache, location);
                }
            }
        }
    }

    protected Location getCacheLocationFromStore(String key) {
        Location location = null;
        if (locationStore != null) {
            location = locationStore.get(key);
        }
        return location;
    }

    private boolean isSettingMockLocation() {
        return !"0".equals(Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ALLOW_MOCK_LOCATION));
    }
}
