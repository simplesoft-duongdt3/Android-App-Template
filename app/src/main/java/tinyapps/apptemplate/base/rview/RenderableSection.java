package tinyapps.apptemplate.base.rview;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doant on 14-Jun-16.
 */
public class RenderableSection<T> {
    List<T> listData = new ArrayList<>();
    RenderableFactory renderableFactory;

    public RenderableSection(List<T> listData, RenderableFactory renderableFactory) {
        this.listData = listData;
        this.renderableFactory = renderableFactory;
    }

    public RenderViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return new RenderViewHolder(renderableFactory.createRenderable(parent, viewType));
    }

    public void onBindViewHolder(RenderViewHolder viewHolder, int position) {
        viewHolder.getRenderable().render(listData.get(position), position);
    }

    public int getItemCount() {
        return listData.size();
    }

    public T getDataAtPos(int pos) {
        return listData.get(pos);
    }

    public int getItemViewType(int position) {
        return 0;
    }

    public void removeAt(int pos) {
        listData.remove(pos);
    }
}
