package tinyapps.apptemplate.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import tinyapps.apptemplate.base.rv.BaseEvent;
import tinyapps.apptemplate.base.util.CheckUtil;

/**
 * Created by duongdt3 on 4/17/2016.
 */
public abstract class BaseFragment<E extends BaseEvent> extends Fragment {

    E event;

    public E getEvent() {
        return event;
    }

    public void setEvent(E event) {
        this.event = event;
    }

    protected boolean isEventAlive() {
        return event != null;
    }

    protected boolean isActivityAlive() {
        return CheckUtil.isActivityAlive(getActivity());
    }

    public boolean isFragmentAlive() {
        return CheckUtil.isFragmentAlive(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayoutId(), container, false);
    }

    protected abstract int getFragmentLayoutId();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
