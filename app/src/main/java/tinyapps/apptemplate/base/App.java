package tinyapps.apptemplate.base;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialModule;

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
        initIcontify();
    }
}
