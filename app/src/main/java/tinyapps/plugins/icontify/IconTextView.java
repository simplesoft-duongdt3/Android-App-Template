package tinyapps.plugins.icontify;

import android.content.Context;
import android.util.AttributeSet;

import tinyapps.apptemplate.base.App;

/**
 * Created by doant on 08-Jun-16.
 */
public class IconTextView extends com.joanzapata.iconify.widget.IconTextView {

    static {
        App.initIcontify();
    }

    public IconTextView(Context context) {
        super(context);
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
