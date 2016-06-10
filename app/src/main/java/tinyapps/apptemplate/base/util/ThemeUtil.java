package tinyapps.apptemplate.base.util;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StyleRes;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * ThemeUtil helps to manage {@link Resources.Theme} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ThemeUtil {

    public static void applyStyle(int resId, boolean force) {
        ContextUtil.getTheme().applyStyle(resId, force);
    }

    public static void dump(int priority, String tag, String prefix) {
        ContextUtil.getTheme().dump(priority, tag, prefix);
    }

    @TargetApi(23)
    public static int getChangingConfigurations() {
        return ContextUtil.getTheme().getChangingConfigurations();
    }

    public static Drawable getDrawable(@DrawableRes int drawableRes) {
        return ResourcesUtil.getDrawable(drawableRes);
    }

    public static Resources getResources() {
        return ContextUtil.getResources();
    }

    public static TypedArray obtainStyledAttributes(@StyleableRes int[] attrs) {
        return ContextUtil.getTheme().obtainStyledAttributes(attrs);
    }

    public static TypedArray obtainStyledAttributes(@StyleRes int resid, @StyleableRes int[] attrs) {
        return ContextUtil.getTheme().obtainStyledAttributes(resid, attrs);
    }

    public static TypedArray obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        return ContextUtil.getTheme().obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
    }

    public static boolean resolveAttribute(int resid, TypedValue outValue, boolean resolveRefs) {
        return ContextUtil.getTheme().resolveAttribute(resid, outValue, resolveRefs);
    }

    public static void setTo(Resources.Theme other) {
        ContextUtil.getTheme().setTo(other);
    }
}