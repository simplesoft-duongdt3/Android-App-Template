package tinyapps.plugins.icontify;

import android.content.Context;
import android.util.AttributeSet;

import tinyapps.apptemplate.base.App;

/**
 * Created by doant on 08-Jun-16.
 */

public class IconToggleButton extends com.joanzapata.iconify.widget.IconToggleButton {

    static {
        App.initIcontify();
    }

    public IconToggleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public IconToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IconToggleButton(Context context) {
        super(context);
    }
}
