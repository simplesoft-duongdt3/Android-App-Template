package tinyapps.apptemplate.base.rview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by doant on 14-Jun-16.
 */
public class RenderableSectionAdapter extends RecyclerView.Adapter<RenderViewHolder> {
    int keySection = 0;
    static final int KEY_NUMBER = 10000;
    SparseArray<RenderableSection> sectionArray = new SparseArray<>();
    List<RenderableSection> sections;

    static class SectionChooseInfo {
        public RenderableSection section;
        public int relativePos;
    }

    @Override
    public RenderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RenderableSection section = getSectionByType(viewType);
        return section.createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RenderViewHolder holder, int position) {
        SectionChooseInfo sectionChooseInfo = getSectionAtPos(position);
        Object dataAtPos = sectionChooseInfo.section.getDataAtPos(sectionChooseInfo.relativePos);
        holder.getRenderable().render(dataAtPos, sectionChooseInfo.relativePos);
    }

    private RenderableSection getSectionByType(int viewType) {
        int key = viewType - KEY_NUMBER;
        return sectionArray.get(key);
    }

    private SectionChooseInfo getSectionAtPos(int position) {
        SectionChooseInfo sectionChooseInfo = new SectionChooseInfo();
        int size = 0;
        for (int i = 0; i < sectionArray.size(); i++) {
            RenderableSection section = sectionArray.valueAt(i);
            int preSize = size;
            size += section.getItemCount();
            if (position < size) {
                sectionChooseInfo.section = section;
                sectionChooseInfo.relativePos = position - preSize;
                break;
            }
        }
        return sectionChooseInfo;
    }

    @Override
    public int getItemCount() {
        int size = 0;
        for (int i = 0; i < sectionArray.size(); i++) {
            RenderableSection section = sectionArray.valueAt(i);
            size += section.getItemCount();
        }
        return size;
    }

    @Override
    public int getItemViewType(int position) {
        SectionChooseInfo sectionAtPos = getSectionAtPos(position);
        int itewType = sectionAtPos.section.getItemViewType(position);
        return itewType + KEY_NUMBER;
    }

    public int addSection(RenderableSection section) {
        sectionArray.append(keySection, section);
        return keySection ++;
    }
}