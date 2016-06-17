package tinyapps.apptemplate.base.util;

import android.app.Activity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

/**
 * Created by duongdt3 on 6/17/2016.
 */
public class LocationUtil {

    public static final int ONE_SECOND_IN_MILI = 1000;
    public static final int ONE_MIN_IN_MILI = 60 * ONE_SECOND_IN_MILI;
    public static final LocationParams BEST_QUANLITY = new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(0).setFastInterval(2 * ONE_SECOND_IN_MILI).setInterval(15 * ONE_SECOND_IN_MILI).build();
    public static final LocationParams BEST_EFFORT = new LocationParams.Builder().setAccuracy(LocationAccuracy.MEDIUM).setDistance(0).setFastInterval(5 * ONE_SECOND_IN_MILI).setInterval(30 * ONE_SECOND_IN_MILI).build();

    public static boolean checkPlayServices(Activity activity, int requestCode) {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(activity);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(activity, resultCode, requestCode).show();
            } else {
                Log.i("TAG", "This device is not supported.");
            }
            return false;
        }
        return true;
    }
}
