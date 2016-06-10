package tinyapps.apptemplate.base.rv;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import tinyapps.plugins.org.joor.Reflect;

/**
 * Created by doant on 07-Jun-16.
 */
public class SimpleViewHolderFactory<D, E extends BaseEvent> extends BaseViewHolderFactory<D, E> {

    private Class<? extends BaseViewHolder> clazz;
    private int resId;

    public SimpleViewHolderFactory(Class<? extends BaseViewHolder> clazz, @LayoutRes int resId) {
        this.clazz = clazz;
        this.resId = resId;
    }

    @Override
    public int getItemViewType(D dataModel, int position) {
        return ViewHolderType.TYPE_DEFAULT;
    }

    @Override
    public BaseViewHolder<? extends D, E> createViewHolder(ViewGroup parent, int type) {
        return Reflect.on(clazz).create(parent, resId).get();
    }

}
