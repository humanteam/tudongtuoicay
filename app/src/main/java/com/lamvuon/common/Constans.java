package com.lamvuon.common;

public interface Constans {
    interface JSON {
        String json = "{";
    }

    interface URL {
//        String server = "http://192.168.43.193";
        String server = "http://192.168.1.35:3000";
    }

    interface SocketEmit {
        int TURN_ON_AUTO = 1;
        int TURN_OFF_AUTO = 2;
    }
}
