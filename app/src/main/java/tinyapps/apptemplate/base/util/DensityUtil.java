package tinyapps.apptemplate.base.util;

/**
 * Created by duongdt3 on 6/4/2016.
 */
public class DensityUtil {

    private static float density = -1F;
    private static int widthPixels = -1;
    private static int heightPixels = -1;

    private DensityUtil() {
    }

    public static float getDensity() {
        if (density <= 0F) {
            density = ContextUtil.getContext().getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static int dip2px(float dpValue) {
        return (int) (dpValue * getDensity() + 0.5F);
    }

    public static int px2dip(float pxValue) {
        return (int) (pxValue / getDensity() + 0.5F);
    }

    public static int getScreenWidth() {
        if (widthPixels <= 0) {
            widthPixels = ContextUtil.getContext().getResources().getDisplayMetrics().widthPixels;
        }
        return widthPixels;
    }


    public static int getScreenHeight() {
        if (heightPixels <= 0) {
            heightPixels = ContextUtil.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        return heightPixels;
    }

}
