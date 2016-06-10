package tinyapps.apptemplate.base.rv;

import android.view.ViewGroup;

/**
 * Created by duongdt3 on 5/17/2016.
 */
public abstract class BaseViewHolderFactory<D, E extends BaseEvent> {

    public abstract int getItemViewType(D dataModel, int position);

    public abstract BaseViewHolder<? extends D, E> createViewHolder(ViewGroup parent, int type);
}