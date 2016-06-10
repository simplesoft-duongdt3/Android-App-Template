package tinyapps.apptemplate.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.Surface;

/**
 * Created by duongdt3 on 6/4/2016.
 */
public class WindowUtils {

    private WindowUtils() {
        throw new Error("Do not need instantiate!");
    }

    public static int getDisplayRotation(Activity activity) {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case Surface.ROTATION_0:
                return 0;
            case Surface.ROTATION_90:
                return 90;
            case Surface.ROTATION_180:
                return 180;
            case Surface.ROTATION_270:
                return 270;
            default:
                return 0;
        }
    }

    public static boolean isLandscape() {
        return ContextUtil.getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static boolean isPortrait(Context context) {
        return ContextUtil.getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
