package tinyapps.apptemplate.demo;

import butterknife.OnClick;
import tinyapps.apptemplate.R;
import tinyapps.apptemplate.base.activity.BaseGpsSupportActivity;

public class DemoGpsActivity extends BaseGpsSupportActivity {
    @Override
    protected int getContentViewId() {
        return R.layout.activity_demo_gps;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.btRequestGPS) void onBtRequestGPSClick() {
        requestLocationOneFix();
    }

    @OnClick(R.id.btRequestGPSMulti) void onBtRequestGPSMultiClick() {
        requestLocationContinuous();
    }


    @Override
    public void onMockLocationDetect() {

    }
}
