package tinyapps.apptemplate.base.rview;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import tinyapps.apptemplate.base.rv.BaseEvent;

/**
 * Created by doant on 14-Jun-16.
 */
public abstract class Renderable<T, E extends BaseEvent> {
    private int resId;
    private E event;
    protected View viewRoot;
    protected T data;
    protected int position;

    public Renderable(@LayoutRes int resId) {
        this.resId = resId;
    }

    public void create(ViewGroup parentView) {
        this.viewRoot = getInflateView(parentView, this.resId);
        ButterKnife.bind(this, this.viewRoot);
        onInitView();
    }

    public View getViewRoot() {
        return viewRoot;
    }

    public void render(T data, int position){
        this.data = data;
        this.position = position;
        onRender();
    }

    public void onInitView() {
        //nothing to do
    }

    public abstract void onRender();


    public E getEvent() {
        return event;
    }

    public void setEvent(E event) {
        this.event = event;
    }

    protected boolean isEventAlive() {
        return event != null;
    }

    public static View getInflateView(ViewGroup parentView, @LayoutRes int resId) {
        return LayoutInflater.from(parentView.getContext()).inflate(resId, parentView, false);
    }
}
