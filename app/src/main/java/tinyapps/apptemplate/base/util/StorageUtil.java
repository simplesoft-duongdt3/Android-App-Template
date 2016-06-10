package tinyapps.apptemplate.base.util;

import android.os.Environment;

/**
 * Created by duongdt3 on 6/4/2016.
 */
public class StorageUtil {
    public static boolean hasSDCard() {

        String status = Environment.getExternalStorageState();
        return status.equals(Environment.MEDIA_MOUNTED);
    }

    public static long getMaxMemory() {
        return Runtime.getRuntime().maxMemory() / 1024;
    }
}
