package tinyapps.apptemplate.base.util;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.TextView;

/**
 * Created by duongdt3 on 6/4/2016.
 */
public class ViewRenderUtil {

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

    public void renderText(TextView textView, CharSequence text) {
        if (CheckViewUtil.isViewAlive(textView)) {
            textView.setText(text);
        }
    }

/*    public void renderNumber(TextView textView, long number) {
        if (CheckViewUtil.isViewAlive(textView)) {
            textView.setText(text);
        }
    }

    public void renderNumberDouble(TextView textView, double numberDouble) {
        if (CheckViewUtil.isViewAlive(textView)) {
            textView.setText(text);
        }
    }*/
}
