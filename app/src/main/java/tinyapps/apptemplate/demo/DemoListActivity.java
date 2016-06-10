package tinyapps.apptemplate.demo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import tinyapps.apptemplate.R;
import tinyapps.apptemplate.base.activity.BaseActivity;
import tinyapps.apptemplate.base.rv.BaseAdapter;

public class DemoListActivity extends BaseActivity {
    @Bind(R.id.rvContent)
    RecyclerView rvContent;
    BaseAdapter<NameModel, NameEvent> adapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_demo_list;
    }

    @Override
    protected void initView() {
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setHasFixedSize(true);

        List<NameModel> names = new ArrayList<>();
//        names.add(new NameModel());
        names.add(new NameExModel());
        //multi type
/*        adapter = new BaseAdapter<>(new BaseViewHolderFactory<NameModel, NameEvent>() {
            @Override
            public int getItemViewType(NameModel dataModel, int position) {
                int type = 1;
                if (dataModel instanceof NameExModel) {
                    type = 2;
                }
                return type;
            }

            @Override
            public BaseViewHolder<? extends NameModel, NameEvent> createViewHolder(ViewGroup parent, int type) {
                BaseViewHolder<? extends NameModel, NameEvent> viewHolder;
                if (type == 1) {
                    viewHolder = new NameViewHolder(parent, NameViewHolder.LAYOUT_DEFAULT);
                } else {
                    viewHolder = new NameExViewHolder(parent, NameExViewHolder.LAYOUT_DEFAULT);
                }
                return viewHolder;
            }
        });*/

        adapter = new BaseAdapter<>(NameExViewHolder.class, NameExViewHolder.LAYOUT_DEFAULT);
        rvContent.setAdapter(adapter);

        adapter.replaceAll(names);
    }
}
