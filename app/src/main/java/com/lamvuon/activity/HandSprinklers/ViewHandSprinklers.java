package com.lamvuon.activity.HandSprinklers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lamvuon.R;
import com.lamvuon.activity.CommonActivity;
import com.lamvuon.adapter.HandSprinklersAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewHandSprinklers extends CommonActivity implements View.OnClickListener ,HandSprinklersAdapter.DeleteItemListener{

    private final String TAG = this.getClass().getSimpleName();

    private ModelHandSprinklers modelHandSprinklers;
    private HandSprinklersAdapter handSprinklersAdapter;
    private RecyclerView mViews;
    private List<String>mData;
    private String []dayOfMonth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_sprinklers);
        modelHandSprinklers = new ModelHandSprinklers(this);
        dayOfMonth = getResources().getStringArray(R.array.dayOfMonth);
        initView();
        initEvent();
    }

    private void initView(){
        createToolbar(getResources().getString(R.string.MS016));
        mViews = findViewById(R.id.list_timer);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mViews.setLayoutManager(manager);
        mData = new ArrayList<>();
        handSprinklersAdapter = new HandSprinklersAdapter(this,mData,this,dayOfMonth);
        mViews.setAdapter(handSprinklersAdapter);
    }
    private void initEvent(){
     btBackToolBar.setOnClickListener(this);
     btAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btBack:
                finish();break;
            case R.id.imgAdd:
                addData();
                break;
        }
    }
    private void addData(){
        mData.add("");
        handSprinklersAdapter.notifyItemInserted(mData.size() - 1);
    }

    @Override
    public void onDeletel(int position) {
        Log.d(TAG, "onDeletel: " + position);
        mData.remove(position);
        handSprinklersAdapter.notifyDataSetChanged();

    }
}
