package tinyapps.apptemplate.base.util;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.List;

/**
 * Created by duongdt3 on 4/25/2016.
 */
public class CheckUtil {

    public static boolean isNull(Object ob) {
        return (ob == null);
    }

    public static boolean isListEmpty(List<?> list) {
        return (list == null || list.isEmpty());
    }

    public static boolean isTextEmpty(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence);
    }

    public static boolean isArrayEmpty(char[] arr) {
        return !(arr == null || arr.length == 0);
    }

    public static boolean isArrayEmpty(float[] arr) {
        return !(arr == null || arr.length == 0);
    }


    public static boolean isArrayEmpty(double[] arr) {
        return !(arr == null || arr.length == 0);
    }

    public static boolean isArrayEmpty(int[] arr) {
        return !(arr == null || arr.length == 0);
    }

    public static boolean isArrayEmpty(Object[] arr) {
        return !(arr == null || arr.length == 0);
    }

    public static boolean isActivityAlive(Activity activity) {
        return activity != null && activity.isFinishing();
    }

    public static boolean isFragmentAlive(Fragment fragment) {
        return fragment != null && fragment.isAdded();
    }
}
