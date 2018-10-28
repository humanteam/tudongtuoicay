package com.example.thanhcong.testsocket.socket;

import android.content.Context;

import com.example.thanhcong.testsocket.common.Constans;
import com.example.thanhcong.testsocket.models.SocketEmit;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class SocketSetup {

    private final String TAG = this.getClass().getSimpleName();

    private Context context;
    private Socket socket;

    public SocketSetup(Context context){
        this.context = context;
        setupSocket();
    }

    private void setupSocket() {
        try {
            socket = IO.socket(Constans.URL.server);
            socket.on(Socket.EVENT_CONNECT,onConnect);
            socket.on(Socket.EVENT_RECONNECT,onReconnect);
            socket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void socketDisconnect(){
        socket.disconnect();
    }

    private Emitter.Listener onReconnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {

        }
    };

    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {

            socket.emit("onRevice" ,"1");
        }
    };

    public void emitControll(SocketEmit socketEmit) {
        switch (socketEmit.getSocketEmit()) {
            case Constans.SocketEmit.TURN_ON_AUTO:
                turnOnAuto();
                break;
            case Constans.SocketEmit.TURN_OFF_AUTO:
                turnOffAuto();
                break;
        }
    }

    private void turnOffAuto() {

    }

    private void turnOnAuto() {

    }
}
