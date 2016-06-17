package tinyapps.apptemplate.base;

import android.app.Application;
import android.content.Intent;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialModule;
import com.squareup.leakcanary.LeakCanary;

import tinyapps.apptemplate.base.service.LocationService;
import tinyapps.apptemplate.base.util.ContextUtil;

/**
 * Created by duongdt3 on 4/25/2016.
 */
public class App extends Application {
    public static void initIcontify() {
        Iconify.with(new FontAwesomeModule())
                .with(new MaterialCommunityModule())
                .with(new MaterialModule());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ContextUtil.init(this);
        LeakCanary.install(this);
        initIcontify();

        startLocationService();
    }

    private void startLocationService() {
        Intent intent = new Intent(this, LocationService.class);
        startService(intent);
    }
}
