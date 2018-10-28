package com.example.thanhcong.testsocket.activity.HomeActivity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.example.thanhcong.testsocket.R;
import com.example.thanhcong.testsocket.activity.HandSprinklers.ViewHandSprinklers;
import com.example.thanhcong.testsocket.common.Constans;
import com.example.thanhcong.testsocket.models.SocketEmit;

import org.greenrobot.eventbus.EventBus;

public class ModelHomeActivity {

    private final String TAG  = ModelHomeActivity.class.getSimpleName();

    private Context context;

    public ModelHomeActivity(Context context){
        this.context = context;
    }

    public void turnOff(TextView tv_level,TextView tv_information) {
        tv_information.setText(context.getResources().getString(R.string.information_auto_off));
        Intent intent = new Intent(context, ViewHandSprinklers.class);
        context.startActivity(intent);
    }

    public void turnOn(TextView tv_level,TextView tv_information) {
        tv_information.setText(context.getResources().getString(R.string.information_auto_on));
    }

    public void more1(TextView tv_level,TextView tv_information){
        tv_information.setText(context.getResources().getString(R.string.information_auto_off));
    }

    public void more2(TextView tv_level,TextView tv_information){
        tv_information.setText(context.getResources().getString(R.string.information_auto_on));
    }
}
