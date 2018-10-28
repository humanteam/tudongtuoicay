package com.example.thanhcong.testsocket.common;

import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

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
}
