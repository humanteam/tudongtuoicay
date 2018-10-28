package com.example.thanhcong.testsocket.activity.HomeActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.thanhcong.testsocket.R;
import com.example.thanhcong.testsocket.activity.CommonActivity;

public class ViewHomeActivity extends CommonActivity implements View.OnClickListener {

    private final String TAG = ViewHomeActivity.class.getSimpleName();
    private final String server = "http://192.168.43.193:3000";

    private ModelHomeActivity modelHomeActivity;
    private TextView btAutomaticOn,btAutomaticOff,tv_information,tv_level,tvMore1,tvMore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        modelHomeActivity = new ModelHomeActivity(this);
        initView();
        initEvent();
    }

    @Override
    protected void onStart() {
        super.onStart();
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

    private void initEvent() {
     btAutomaticOn.setOnClickListener(this);
     btAutomaticOff.setOnClickListener(this);
     tvMore1.setOnClickListener(this);
     tvMore2.setOnClickListener(this);
     createToolbar(getResources().getString(R.string.MS015));
    }

    private void initView() {
        tvMore1 = findViewById(R.id.tvMore1);
        tvMore2 = findViewById(R.id.tvMore2);
        tv_level = findViewById(R.id.tv_level);
        tv_information = findViewById(R.id.tv_information);
        btAutomaticOff = findViewById(R.id.btAutomaticOff);
        btAutomaticOn = findViewById(R.id.btAutomaticOn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btAutomaticOn:
               modelHomeActivity.turnOn(tv_level,tv_information);break;
            case R.id.btAutomaticOff:
                modelHomeActivity.turnOff(tv_level,tv_information);break;
            case R.id.tvMore1:
                tvMore1.setBackgroundColor(getResources().getColor(R.color.choose));
                tvMore2.setBackgroundColor(Color.TRANSPARENT);
                modelHomeActivity.more1(tv_level,tv_information);break;
            case R.id.tvMore2:
                tvMore1.setBackgroundColor(Color.TRANSPARENT);
                tvMore2.setBackgroundColor(getResources().getColor(R.color.choose));
                modelHomeActivity.more2(tv_level,tv_information);break;
        }
    }
}
