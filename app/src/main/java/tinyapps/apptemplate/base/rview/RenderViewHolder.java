package tinyapps.apptemplate.base.rview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by doant on 14-Jun-16.
 */
public class RenderViewHolder extends RecyclerView.ViewHolder {
    Renderable renderable;

    public RenderViewHolder(Renderable renderable) {
        super(renderable.getViewRoot());
        this.renderable = renderable;
    }

    public Renderable getRenderable() {
        return renderable;
    }
}
