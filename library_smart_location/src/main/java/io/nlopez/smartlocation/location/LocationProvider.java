package io.nlopez.smartlocation.location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.location.config.LocationParams;
import io.nlopez.smartlocation.utils.Logger;

/**
 * Created by mrm on 20/12/14.
 */
public abstract class LocationProvider {
    public static int REQUEST_START_LOCATION_FIX = 9000001;
    public static int REQUEST_CHECK_SETTINGS = 9000002;
    public static int LOCATION_PERMISSION_ID = 9000003;

    public abstract void init(Context context, Logger logger);

    public abstract void start(OnLocationUpdatedListener listener, LocationParams params, boolean singleUpdate);

    public abstract void stop();

    public abstract Location getLastLocation();

    public abstract void onActivityResult(int requestCode, int resultCode, Intent data);

    public abstract void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);

    protected boolean checkGpsPermision(Context context) {
        boolean isPass = true;
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            isPass = false;
            if (context instanceof Activity) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_ID);
            }
        }
        return isPass;
    }
}
