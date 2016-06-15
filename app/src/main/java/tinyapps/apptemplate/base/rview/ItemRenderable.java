package tinyapps.apptemplate.base.rview;

import android.support.annotation.LayoutRes;
import android.widget.TextView;

import butterknife.Bind;
import tinyapps.apptemplate.R;
import tinyapps.apptemplate.base.rv.BaseEvent;
import tinyapps.apptemplate.demo.NameModel;

/**
 * Created by doant on 14-Jun-16.
 */
public class ItemRenderable extends Renderable<NameModel, BaseEvent> {
    @Bind(R.id.txtName)
    TextView txtName;

    public ItemRenderable(@LayoutRes int resId) {
        super(resId);
    }

    @Override
    public void onRender() {
        txtName.setText(data.name);
    }
}
