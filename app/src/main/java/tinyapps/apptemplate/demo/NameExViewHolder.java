package tinyapps.apptemplate.demo;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import tinyapps.apptemplate.R;
import tinyapps.apptemplate.base.rv.BaseViewHolder;

/**
 * Created by doant on 07-Jun-16.
 */
public class NameExViewHolder extends BaseViewHolder<NameExModel, NameEvent> {
    public static final int LAYOUT_DEFAULT = R.layout.item_name_ex;

    public NameExViewHolder(ViewGroup parentView, @LayoutRes int resId) {
        super(parentView, resId);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void renderData(NameExModel data, int position) {

    }
}
