package tinyapps.apptemplate.base.util;

import android.annotation.TargetApi;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.annotation.StyleableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by duongdt3 on 4/25/2016.
 */
public class ContextUtil {
    private static Context context;

    public static void init(Context context) {
        ContextUtil.context = context;
    }

    public static Context getContext() {
        return context;
    }

    public static Configuration getConfiguration() {
        return getResources().getConfiguration();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public static LayoutInflater getLayoutInflater() {
        return getLayoutInflater(getContext());
    }

    public static LayoutInflater getLayoutInflater(Context context) {
        return LayoutInflater.from(context);
    }

    public static boolean checkPermission(@NonNull String permission) {
        return ContextCompat.checkSelfPermission(getContext(), permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return ContextUtil.getContext().bindService(service, conn, flags);
    }

    public static int checkCallingOrSelfPermission(String permission) {
        return ContextUtil.getContext().checkCallingOrSelfPermission(permission);
    }

    public static int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return ContextUtil.getContext().checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    public static int checkCallingPermission(String permission) {
        return ContextUtil.getContext().checkCallingPermission(permission);
    }

    public static int checkCallingUriPermission(Uri uri, int modeFlags) {
        return ContextUtil.getContext().checkCallingUriPermission(uri, modeFlags);
    }

    public static int checkPermission(String permission, int pid, int uid) {
        return ContextUtil.getContext().checkPermission(permission, pid, uid);
    }

    public static int checkSelfPermission(@NonNull String permission) {
        return ContextCompat.checkSelfPermission(ContextUtil.getContext(), permission);
    }

    public static int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return ContextUtil.getContext().checkUriPermission(uri, pid, uid, modeFlags);
    }

    public static int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return ContextUtil.getContext().checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }

    public static Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return ContextUtil.getContext().createPackageContext(packageName, flags);
    }

    public static String[] databaseList() {
        return ContextUtil.getContext().databaseList();
    }

    public static boolean deleteDatabase(String name) {
        return ContextUtil.getContext().deleteDatabase(name);
    }

    public static boolean deleteFile(String name) {
        return ContextUtil.getContext().deleteFile(name);
    }

    public static void enforceCallingOrSelfPermission(String permission, String message) {
        ContextUtil.getContext().enforceCallingOrSelfPermission(permission, message);
    }

    public static void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        ContextUtil.getContext().enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    public static void enforceCallingPermission(String permission, String message) {
        ContextUtil.getContext().enforceCallingPermission(permission, message);
    }

    public static void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        ContextUtil.getContext().enforceCallingUriPermission(uri, modeFlags, message);
    }

    public static void enforcePermission(String permission, int pid, int uid, String message) {
        ContextUtil.getContext().enforcePermission(permission, pid, uid, message);
    }

    public static void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        ContextUtil.getContext().enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    public static void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        ContextUtil.getContext().enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    public static String[] fileList() {
        return ContextUtil.getContext().fileList();
    }

    public static Context getApplicationContext() {
        return ContextUtil.getContext().getApplicationContext();
    }

    public static ApplicationInfo getApplicationInfo() {
        return ContextUtil.getContext().getApplicationInfo();
    }

    public static AssetManager getAssets() {
        return ContextUtil.getContext().getAssets();
    }

    public static File getCacheDir() {
        return ContextUtil.getContext().getCacheDir();
    }

    public static ClassLoader getClassLoader() {
        return ContextUtil.getContext().getClassLoader();
    }

    public static File getCodeCacheDir() {
        return new ContextCompat().getCodeCacheDir(ContextUtil.getContext());
    }

    @ColorInt
    public static int getColor(@ColorRes int colorRes) {
        return ContextCompat.getColor(ContextUtil.getContext(), colorRes);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes) {
        return ContextCompat.getColorStateList(ContextUtil.getContext(), colorRes);
    }

    public static ContentResolver getContentResolver() {
        return ContextUtil.getContext().getContentResolver();
    }

    public static File getDatabasePath(String name) {
        return ContextUtil.getContext().getDatabasePath(name);
    }

    public static File getDir(String name, int mode) {
        return ContextUtil.getContext().getDir(name, mode);
    }

    public static Drawable getDrawable(@DrawableRes int drawableRes) {
        return ContextCompat.getDrawable(ContextUtil.getContext(), drawableRes);
    }

    @Nullable
    @TargetApi(8)
    public static File getExternalCacheDir() {
        return ContextUtil.getContext().getExternalCacheDir();
    }

    public static File[] getExternalCacheDirs() {
        return ContextCompat.getExternalCacheDirs(ContextUtil.getContext());
    }

    @Nullable
    @TargetApi(8)
    public static File getExternalFilesDir(String type) {
        return ContextUtil.getContext().getExternalFilesDir(type);
    }

    public static File[] getExternalFilesDirs(String type) {
        return ContextCompat.getExternalFilesDirs(ContextUtil.getContext(), type);
    }

    @TargetApi(21)
    public static File[] getExternalMediaDirs() {
        return ContextUtil.getContext().getExternalMediaDirs();
    }

    public static File getFileStreamPath(String name) {
        return ContextUtil.getContext().getFileStreamPath(name);
    }

    public static File getFilesDir() {
        return ContextUtil.getContext().getFilesDir();
    }

    public static Looper getMainLooper() {
        return ContextUtil.getContext().getMainLooper();
    }

    public static File getNoBackupFilesDir() {
        return new ContextCompat().getNoBackupFilesDir(ContextUtil.getContext());
    }

    @TargetApi(11)
    public static File getObbDir() {
        return ContextUtil.getContext().getObbDir();
    }

    public static File[] getObbDirs() {
        return ContextCompat.getObbDirs(ContextUtil.getContext());
    }

    @TargetApi(8)
    public static String getPackageCodePath() {
        return ContextUtil.getContext().getPackageCodePath();
    }

    public static PackageManager getPackageManager() {
        return ContextUtil.getContext().getPackageManager();
    }

    public static String getPackageName() {
        return ContextUtil.getContext().getPackageName();
    }

    @TargetApi(8)
    public static String getPackageResourcePath() {
        return ContextUtil.getContext().getPackageResourcePath();
    }

    public static Resources getResources() {
        return ContextUtil.getContext().getResources();
    }

    public static SharedPreferences getSharedPreferences(String name, int mode) {
        return ContextUtil.getContext().getSharedPreferences(name, mode);
    }

    public static String getString(@StringRes int stringRes) {
        return ContextUtil.getContext().getString(stringRes);
    }

    public static String getString(@StringRes int stringRes, Object... formatArgs) {
        return ContextUtil.getContext().getString(stringRes, formatArgs);
    }

    @TargetApi(23)
    public static <T> T getSystemService(Class<T> serviceClass) {
        return ContextUtil.getContext().getSystemService(serviceClass);
    }

    public static Object getSystemService(String name) {
        return ContextUtil.getContext().getSystemService(name);
    }

    @TargetApi(23)
    public static String getSystemServiceName(Class<?> serviceClass) {
        return ContextUtil.getContext().getSystemServiceName(serviceClass);
    }

    public static CharSequence getText(@StringRes int stringRes) {
        return ContextUtil.getContext().getText(stringRes);
    }

    public static Resources.Theme getTheme() {
        return ContextUtil.getContext().getTheme();
    }

    public static void setTheme(@StyleRes int styleRes) {
        ContextUtil.getContext().setTheme(styleRes);
    }

    public static Drawable getWallpaper() {
        return WallpaperManager.getInstance(ContextUtil.getContext()).getDrawable();
    }

    public static void setWallpaper(Bitmap bitmap) throws IOException {
        WallpaperManager.getInstance(ContextUtil.getContext()).setBitmap(bitmap);
    }

    public static void setWallpaper(InputStream data) throws IOException {
        WallpaperManager.getInstance(ContextUtil.getContext()).setStream(data);
    }

    public static int getWallpaperDesiredMinimumHeight() {
        return WallpaperManager.getInstance(ContextUtil.getContext()).getDesiredMinimumHeight();
    }

    public static int getWallpaperDesiredMinimumWidth() {
        return WallpaperManager.getInstance(ContextUtil.getContext()).getDesiredMinimumWidth();
    }

    public static void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        ContextUtil.getContext().grantUriPermission(toPackage, uri, modeFlags);
    }

    public static boolean isRestricted() {
        return ContextUtil.getContext().isRestricted();
    }

    public static TypedArray obtainStyledAttributes(@StyleableRes int[] attrs) {
        return ContextUtil.getContext().obtainStyledAttributes(attrs);
    }

    public static TypedArray obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        return ContextUtil.getContext().obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
    }

    public static TypedArray obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs) {
        return ContextUtil.getContext().obtainStyledAttributes(set, attrs);
    }

    public static TypedArray obtainStyledAttributes(@StyleRes int resid, @StyleableRes int[] attrs) {
        return ContextUtil.getContext().obtainStyledAttributes(resid, attrs);
    }

    public static FileInputStream openFileInput(String name) throws FileNotFoundException {
        return ContextUtil.getContext().openFileInput(name);
    }

    public static FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return ContextUtil.getContext().openFileOutput(name, mode);
    }

    public static SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return ContextUtil.getContext().openOrCreateDatabase(name, mode, factory);
    }

    @TargetApi(11)
    public static SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return ContextUtil.getContext().openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    public static Drawable peekWallpaper() {
        return WallpaperManager.getInstance(ContextUtil.getContext()).peekDrawable();
    }

//    public static void removeStickyBroadcast(Intent intent) {
//        ContextUtil.getContext().removeStickyBroadcast(intent);
//    }
//
//    @TargetApi(17)
//    public static void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
//        ContextUtil.getContext().removeStickyBroadcastAsUser(intent, user);
//    }

    @TargetApi(14)
    public static void registerComponentCallbacks(ComponentCallbacks callback) {
        ContextUtil.getContext().registerComponentCallbacks(callback);
    }

    public static Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return ContextUtil.getContext().registerReceiver(receiver, filter);
    }

    public static Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return ContextUtil.getContext().registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }

    public static void revokeUriPermission(Uri uri, int modeFlags) {
        ContextUtil.getContext().revokeUriPermission(uri, modeFlags);
    }

    public static void sendBroadcast(Intent intent, String receiverPermission) {
        ContextUtil.getContext().sendBroadcast(intent, receiverPermission);
    }

    public static void sendBroadcast(Intent intent) {
        ContextUtil.getContext().sendBroadcast(intent);
    }

    @TargetApi(17)
    public static void sendBroadcastAsUser(Intent intent, UserHandle user) {
        ContextUtil.getContext().sendBroadcastAsUser(intent, user);
    }

    @TargetApi(17)
    public static void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission) {
        ContextUtil.getContext().sendBroadcastAsUser(intent, user, receiverPermission);
    }

//    public static void sendStickyBroadcast(Intent intent) {
//        ContextUtil.getContext().sendStickyBroadcast(intent);
//    }
//
//    @TargetApi(17)
//    public static void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
//        ContextUtil.getContext().sendStickyBroadcastAsUser(intent, user);
//    }
//
//    public static void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
//        ContextUtil.getContext().sendStickyOrderedBroadcast(intent, resultReceiver, scheduler, initialCode, initialData, initialExtras);
//    }
//
//    @TargetApi(17)
//    public static void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
//        ContextUtil.getContext().sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver, scheduler, initialCode, initialData, initialExtras);
//    }

    public static void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        ContextUtil.getContext().sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    public static void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        ContextUtil.getContext().sendOrderedBroadcast(intent, receiverPermission);
    }

    @TargetApi(17)
    public static void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        ContextUtil.getContext().sendOrderedBroadcastAsUser(intent, user, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    public static boolean startActivities(Intent[] intents, Bundle options) {
        for (Intent intent : intents)
            if (intent != null)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return ContextCompat.startActivities(ContextUtil.getContext(), intents, options);
    }

    public static boolean startActivities(Intent[] intents) {
        for (Intent intent : intents)
            if (intent != null)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return ContextCompat.startActivities(ContextUtil.getContext(), intents);
    }

    public static void startActivity(@NonNull Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ContextUtil.getContext().startActivity(intent);
    }

    @TargetApi(16)
    public static void startActivity(Intent intent, Bundle options) {
        ContextUtil.getContext().startActivity(intent, options);
    }

    public static boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return ContextUtil.getContext().startInstrumentation(className, profileFile, arguments);
    }

    @TargetApi(16)
    public static void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        ContextUtil.getContext().startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    public static void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        ContextUtil.getContext().startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    public static ComponentName startService(Intent service) {
        return ContextUtil.getContext().startService(service);
    }

    public static boolean stopService(Intent service) {
        return ContextUtil.getContext().stopService(service);
    }

    public static void unbindService(ServiceConnection conn) {
        ContextUtil.getContext().unbindService(conn);
    }

    @TargetApi(14)
    public static void unregisterComponentCallbacks(ComponentCallbacks callback) {
        ContextUtil.getContext().unregisterComponentCallbacks(callback);
    }

    public static void unregisterReceiver(BroadcastReceiver receiver) {
        ContextUtil.getContext().unregisterReceiver(receiver);
    }
}
