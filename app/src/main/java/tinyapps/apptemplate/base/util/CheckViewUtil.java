package tinyapps.apptemplate.base.util;

import android.view.View;
import android.widget.TextView;

/**
 * Created by duongdt3 on 6/4/2016.
 */
public class CheckViewUtil {
    public static boolean isViewAlive(View view) {
        return view != null;
    }

    public static boolean isTextViewEmpty(TextView textView) {
        boolean tvEmpty = true;
        if (isViewAlive(textView)) {
            tvEmpty = CheckUtil.isTextEmpty(textView.getText());
        }
        return tvEmpty;
    }
}
