package tinyapps.apptemplate.base.util;

import android.util.TypedValue;

/**
 * TypedValueUtil helps to manage {@link TypedValue} class conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class TypedValueUtil {

    public static float applyDimension(int unit, float value) {
        return TypedValue.applyDimension(unit, value, ContextUtil.getDisplayMetrics());
    }

    public static float complexToDimension(int data) {
        return TypedValue.complexToDimension(data, ContextUtil.getDisplayMetrics());
    }

    public static int complexToDimensionPixelOffset(int data) {
        return TypedValue.complexToDimensionPixelOffset(data, ContextUtil.getDisplayMetrics());
    }

    public static int complexToDimensionPixelSize(int data) {
        return TypedValue.complexToDimensionPixelSize(data, ContextUtil.getDisplayMetrics());
    }
}