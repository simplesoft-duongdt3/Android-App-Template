package tinyapps.apptemplate.base.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBeforeSetContentView();
        if (getContentViewId() > 0) {
            setContentView(getContentViewId());
        }
        initAfterSetContentView();

        ButterKnife.bind(this);
        initView();
        //initFragment();
    }

    //protected abstract void initFragment();

    protected void initAfterSetContentView() {

    }

    protected void initBeforeSetContentView() {

    }

    protected abstract int getContentViewId();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    void replaceFragment(int contentId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(contentId, fragment).commit();
    }

}
