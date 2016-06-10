package tinyapps.apptemplate.base.util.converters;

import tinyapps.apptemplate.base.util.ContextUtil;

/**
 * UnitConverter helps to convert dp or sp size into pixel.
 *
 * @author Leonardo Taehwan Kim
 */
public class UnitConverter {

    public static float dpToPx(float dp) {
        return dp * ContextUtil.getDisplayMetrics().density;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * ContextUtil.getDisplayMetrics().density + 0.5f);
    }

    public static float pxToDp(float px) {
        return px / ContextUtil.getDisplayMetrics().density;
    }

    public static int pxToDp(int px) {
        return (int) (px / ContextUtil.getDisplayMetrics().density + 0.5f);
    }

    public static float spToPx(float sp) {
        return sp * ContextUtil.getDisplayMetrics().scaledDensity;
    }

    public static int spToPx(int sp) {
        return (int) (sp * ContextUtil.getDisplayMetrics().scaledDensity + 0.5f);
    }

    public static float pxToSp(float px) {
        return px / ContextUtil.getDisplayMetrics().scaledDensity;
    }

    public static int pxToSp(int px) {
        return (int) (px / ContextUtil.getDisplayMetrics().scaledDensity + 0.5f);
    }
}