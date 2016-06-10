package tinyapps.apptemplate.base.rv;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MonkeyD on 2/18/2016.
 */
public abstract class BaseViewHolder<D, E extends BaseEvent> extends RecyclerView.ViewHolder {
    private E event;

    public BaseViewHolder(ViewGroup parentView, @LayoutRes int resId) {
        super(getInflateView(parentView, resId));
        initView();
    }

    private static View getInflateView(ViewGroup parentView, @LayoutRes int resId) {
        return LayoutInflater.from(parentView.getContext()).inflate(resId, parentView, false);
    }

    public E getEvent() {
        return event;
    }

    public void setEvent(E event) {
        this.event = event;
    }

    protected boolean isEventAlive() {
        return event != null;
    }

    public final void bind(D data, int position) {
        //do something else
        renderData(data, position);
    }

    protected abstract void initView();

    protected abstract void renderData(D data, int position);
}
