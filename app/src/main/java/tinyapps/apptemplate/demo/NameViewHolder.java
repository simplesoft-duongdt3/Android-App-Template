package tinyapps.apptemplate.demo;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import tinyapps.apptemplate.R;
import tinyapps.apptemplate.base.rv.BaseViewHolder;

/**
 * Created by doant on 07-Jun-16.
 */
public class NameViewHolder extends BaseViewHolder<NameModel, NameEvent> {
    public static final int LAYOUT_DEFAULT = R.layout.item_name;

    public NameViewHolder(ViewGroup parentView, @LayoutRes int resId) {
        super(parentView, resId);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void renderData(NameModel data, int position) {

    }
}
