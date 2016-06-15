package tinyapps.apptemplate.base.rview;

import android.view.ViewGroup;

import tinyapps.apptemplate.R;

/**
 * Created by doant on 14-Jun-16.
 */
public class RenderableFactory {
    Renderable createRenderable(ViewGroup parent, int viewType){
        //// TODO: 14-Jun-16 use view type create renderable
        ItemRenderable itemRenderable = new ItemRenderable(R.layout.item_name_ex);
        itemRenderable.create(parent);
        return itemRenderable;
    }


}
