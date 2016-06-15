package tinyapps.apptemplate.demo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import tinyapps.apptemplate.R;
import tinyapps.apptemplate.base.activity.BaseActivity;
import tinyapps.apptemplate.base.rview.RenderableFactory;
import tinyapps.apptemplate.base.rview.RenderableSection;
import tinyapps.apptemplate.base.rview.RenderableSectionAdapter;

public class DemoRenderableAdapterActivity extends BaseActivity {

    @Bind(R.id.rvContent)
    RecyclerView rvContent;
    private RenderableSectionAdapter renderableSectionAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_demo_renderable_adapter;
    }

    @Override
    protected void initView() {
        renderableSectionAdapter = new RenderableSectionAdapter();
        List<NameModel> listData = new ArrayList<>();
        NameModel exModel = new NameExModel();
        exModel.name = "1";
        listData.add(exModel);
        exModel = new NameExModel();
        exModel.name = "2";
        listData.add(exModel);
        exModel = new NameExModel();
        exModel.name = "3";
        listData.add(exModel);
        exModel = new NameModel();
        exModel.name = "4";
        listData.add(exModel);

        RenderableFactory renderableFactory = new RenderableFactory();
        RenderableSection<NameModel> section1 = new RenderableSection<>(listData, renderableFactory);
        renderableSectionAdapter.addSection(section1);
        RenderableSection<NameModel> section2 = new RenderableSection<>(new ArrayList<>(listData), renderableFactory);
        renderableSectionAdapter.addSection(section2);
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setHasFixedSize(true);
        rvContent.setAdapter(renderableSectionAdapter);
        section2.removeAt(1);
        renderableSectionAdapter.notifyDataSetChanged();
    }
}
