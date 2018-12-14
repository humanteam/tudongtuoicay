package com.lamvuon.activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.ApplicationErrorReport;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lamvuon.R;
import com.lamvuon.activity.HomeActivity.ViewHomeActivity;
import com.lamvuon.common.Utils;
import com.lamvuon.socket.ServiceCustom;

import java.util.List;


public class CommonActivity extends AppCompatActivity {
    protected ImageView btBackToolBar,btAdd,btDeleteAll;
    protected TextView tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startServiceSocket();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    protected void createToolbar(String title){
        btBackToolBar = findViewById(R.id.btBack);
        btAdd = findViewById(R.id.imgAdd);
        btDeleteAll = findViewById(R.id.btDeleteAll);

        tvTitle = findViewById(R.id.tvTitle);
        if(this instanceof ViewHomeActivity){
            btBackToolBar.setVisibility(View.GONE);
            btAdd.setVisibility(View.GONE);
            btDeleteAll.setVisibility(View.GONE);
        }
        tvTitle.setText(title);
    }

    protected void startServiceSocket(){
        if(!Utils.isServiceRunning(ServiceCustom.class,this)) {
            Intent intent = new Intent(this, ServiceCustom.class);
            startService(intent);
        }
    }
}
