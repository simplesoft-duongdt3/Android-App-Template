package tinyapps.apptemplate.base.util;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.View;

public class ViewUtil {
    @SuppressWarnings("unchecked")
    public static <T> T findViewById(int viewId, View view) {
        return (T) view.findViewById(viewId);
    }

    public static void setBackground(View view, Drawable drawable) {
        if (view == null)
            return;

        if (APILevel.require(16)) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void setBackground(View view, @DrawableRes int drawableRes) {
        if (view == null)
            return;

        if (APILevel.require(16)) {
            view.setBackground(ContextUtil.getDrawable(drawableRes));
        } else {
            view.setBackgroundDrawable(ContextUtil.getDrawable(drawableRes));
        }
    }
}
