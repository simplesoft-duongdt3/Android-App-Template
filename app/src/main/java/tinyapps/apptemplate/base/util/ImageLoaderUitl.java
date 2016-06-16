package tinyapps.apptemplate.base.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by duongdt3 on 6/16/2016.
 */
public class ImageLoaderUitl {
    public void load(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }
}
