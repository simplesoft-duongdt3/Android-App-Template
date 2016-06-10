package tinyapps.apptemplate.base.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

public class ActivityIntentBuilder {

    final Intent intent;

    public <C extends Activity> ActivityIntentBuilder(@NonNull Class<C> clazz) {
        intent = new Intent(ContextUtil.getContext(), clazz);
    }

    public <T extends Serializable> ActivityIntentBuilder set(@NonNull String key, T value) {
        intent.putExtra(key, value);
        return this;
    }

    public ActivityIntentBuilder set(@NonNull String key, Parcelable value) {
        intent.putExtra(key, value);
        return this;
    }

    public ActivityIntentBuilder set(@NonNull String key, Parcelable[] value) {
        intent.putExtra(key, value);
        return this;
    }

    public <T extends Parcelable> ActivityIntentBuilder set(@NonNull String key, ArrayList<T> value) {
        intent.putExtra(key, value);
        return this;
    }

    public ActivityIntentBuilder remove(@NonNull String key) {
        intent.removeExtra(key);
        return this;
    }

    public ActivityIntentBuilder setFlags(int flags) {
        intent.setFlags(flags);
        return this;
    }

    public ActivityIntentBuilder addFlags(int flags) {
        intent.addFlags(flags);
        return this;
    }

    public Intent buildIntent() {
        return intent;
    }

    public void start() {
        ContextUtil.getContext().startActivity(intent);
    }

    public void startForResult(@NonNull Activity activity, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
    }

    @TargetApi(16)
    public void startForResult(@NonNull Activity activity, int requestCode, @Nullable Bundle options) {
        activity.startActivityForResult(intent, requestCode, options);
    }
}
