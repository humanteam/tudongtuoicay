package com.example.thanhcong.testsocket.socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.thanhcong.testsocket.common.Utils;
import com.example.thanhcong.testsocket.models.SocketEmit;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ServiceCustom extends Service {

    private final String TAG = ServiceCustom.class.getSimpleName();

    private SocketSetup socketSetup;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        socketSetup = new SocketSetup(this);
        Utils.registerEventBuss(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(socketSetup != null){
            socketSetup.socketDisconnect();
        }
        Utils.unRegisterEventBuss(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventEmit(SocketEmit event){
        if(socketSetup != null){
            socketSetup.emitControll(event);
        }
    }
}
