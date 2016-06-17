package tinyapps.apptemplate.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.util.Log;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesWithFallbackProvider;
import tinyapps.apptemplate.base.Constant;
import tinyapps.apptemplate.base.util.LocationUtil;

/**
 * Created by duongdt3 on 6/17/2016.
 */
public abstract class BaseGpsSupportActivity extends BaseActivity implements OnLocationUpdatedListener {
    SmartLocation.LocationControl locationControl;

    protected void checkGooglePlayServiceAvaiable() {
        LocationUtil.checkPlayServices(this, Constant.PLAY_SERVICES_RESOLUTION_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        checkResultLocationControl(requestCode, resultCode, data);
        checkResultGooglePlayService(requestCode, resultCode);
    }

    private void checkResultLocationControl(int requestCode, int resultCode, Intent data) {
        locationControl.onActivityResult(requestCode, resultCode, data);
    }

    private void checkResultGooglePlayService(int requestCode, int resultCode) {
        if (requestCode == Constant.PLAY_SERVICES_RESOLUTION_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                onGooglePlayServiceResolutionOk();
            } else {
                onGooglePlayServiceResolutionFail();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        locationControl.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void onGooglePlayServiceResolutionFail() {
        //do nothing
    }

    private void onGooglePlayServiceResolutionOk() {
        //do nothing
    }

    @Override
    public void onLocationUpdated(Location location) {
        Log.d("BaseGpsSupportActivity", "onLocationUpdated " + location);
    }

    private void initGps() {
        locationControl = new SmartLocation.Builder(this)
                .logging(true)
                .build()
                .location(new LocationGooglePlayServicesWithFallbackProvider(this));
    }

    public void requestLocationOneFix() {
        locationControl.stop();
        locationControl.config(LocationUtil.BEST_QUANLITY)
                .oneFix().start(this);
    }

    public void requestLocationContinuous() {
        locationControl.stop();
        locationControl.config(LocationUtil.BEST_QUANLITY)
                .continuous().start(this);
    }

    @Override
    protected void initBeforeSetContentView() {
        super.initBeforeSetContentView();
        initGps();
    }

    @Override
    protected void onStop() {
        super.onStop();
        locationControl.stop();
    }
}
