package tinyapps.apptemplate.base.rv;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tinyapps.apptemplate.base.util.CheckUtil;

/**
 * Created by duongdt3 on 5/17/2016.
 */
public class BaseAdapter<D, E extends BaseEvent> extends RecyclerView.Adapter<BaseViewHolder<? extends D, E>> {
    List<D> dataModels = new ArrayList<>();
    private BaseViewHolderFactory<D, E> viewFactory;
    private E event;

    public BaseAdapter(Class<? extends BaseViewHolder> clazz, @LayoutRes int resId) {
        this.viewFactory = new SimpleViewHolderFactory<>(clazz, resId);
    }

    public BaseAdapter(BaseViewHolderFactory<D, E> viewFactory) {
        this.viewFactory = viewFactory;
    }

    public void setEvent(E event) {
        this.event = event;
    }

    @Override
    public BaseViewHolder<? extends D, E> onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder<? extends D, E> viewHolder = viewFactory.createViewHolder(parent, viewType);
        viewHolder.setEvent(this.event);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(dataModels.get(position), position);
    }

    @Override
    public int getItemViewType(int position) {
        return viewFactory.getItemViewType(dataModels.get(position), position);
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }


    public void replace(D newDataModel, int position) {
        if (!CheckUtil.isNull(newDataModel) && position >= 0 && this.dataModels.size() > position) {
            this.dataModels.set(position, newDataModel);
            notifyItemChanged(position);
        }
    }

    public void replaceAll(List<D> newDataModels) {
        this.dataModels.clear();
        if (!CheckUtil.isListEmpty(newDataModels)) {
            this.dataModels.addAll(newDataModels);
        }
        notifyDataSetChanged();
    }


    public void addAll(List<D> newDataModels) {
        if (!CheckUtil.isListEmpty(newDataModels)) {
            int startIndex = this.dataModels.size();
            this.dataModels.addAll(newDataModels);
            notifyItemRangeInserted(startIndex, newDataModels.size());
        }
    }

    public void addAll(D newDataModel) {
        if (!CheckUtil.isNull(newDataModel)) {
            this.dataModels.add(newDataModel);
            notifyItemInserted(this.dataModels.size() - 1);
        }
    }

    public void removeAll() {
        this.dataModels.clear();
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (position >= 0 && this.dataModels.size() > position) {
            this.dataModels.remove(position);
            notifyItemRemoved(position);
        }
    }
}
