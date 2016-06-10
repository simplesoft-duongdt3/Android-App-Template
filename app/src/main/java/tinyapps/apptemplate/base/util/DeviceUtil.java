package tinyapps.apptemplate.base.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by duongdt3 on 6/4/2016.
 */
public class DeviceUtil {
    public static String getDeviceId() {
        TelephonyManager telephonyManager = (TelephonyManager) ContextUtil.getContext()
                .getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

}
