package com.lamvuon.common;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class Utils {

    private static final String TAG = Utils.class.getSimpleName();


    public static void registerEventBuss(Context context){
        try {
            EventBus.getDefault().register(context);
        } catch (Throwable e){
            Log.e(TAG, "registerEventBuss: ",e);
        }
    }

    public static void unRegisterEventBuss(Context context){
        try {
            EventBus.getDefault().unregister(context);
        } catch (Throwable e){
            Log.e(TAG, "registerEventBuss: ",e);
        }
    }

    public static boolean isServiceRunning(Class<?> serviceClassName,Context context){
        final ActivityManager activityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);

        for (ActivityManager.RunningServiceInfo runningServiceInfo : services) {
            if (runningServiceInfo.service.getClassName().equals(serviceClassName.getSimpleName())){
                return true;
            }
        }
        return false;
    }
}
