package com.lamvuon.adapter;

import android.app.TimePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.lamvuon.R;

import java.util.List;

public class HandSprinklersAdapter extends RecyclerView.Adapter<HandSprinklersAdapter.ModelHandSprinklers> {

    private final String TAG = this.getClass().getSimpleName();


    private BaseAdapter baseAdapter;
    private DeleteItemListener deleteItemListener;
    private Context context;
    private List<String>mData;
    private String []dayOfMonth;

    public HandSprinklersAdapter(Context context,List<String>mData,DeleteItemListener deleteItemListener,String []dayOfMonth){
        this.context = context;
        this.mData = mData;
        this.deleteItemListener = deleteItemListener;
        this.dayOfMonth = dayOfMonth;
        baseAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, dayOfMonth);
    }

    @NonNull
    @Override
    public ModelHandSprinklers onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_add_time,viewGroup,false);
        return new ModelHandSprinklers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ModelHandSprinklers models, final int postion) {
         Log.d(TAG, "onDeletel: binview:" + postion);
         try {
             models.spnDayOfMonth.setAdapter(baseAdapter);
         } catch (Throwable e){
             Log.e(TAG, "onBindViewHolder: ",e);
         }

         models.tvTimeStart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
               setupTimePicker(models.tvTimeStart);
             }
         });

        models.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItemListener.onDeletel(postion);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ModelHandSprinklers extends RecyclerView.ViewHolder {

        TextView tvTimeStart;
        EditText tvTimeOver;
        ImageView btDelete;
        Spinner spnDayOfMonth;
         ModelHandSprinklers(@NonNull View itemView) {
            super(itemView);
            tvTimeOver = itemView.findViewById(R.id.tvTimeOver);
            tvTimeStart = itemView.findViewById(R.id.tvTimeStart);
            btDelete = itemView.findViewById(R.id.btDelete);
            spnDayOfMonth = itemView.findViewById(R.id.spnDayOfMonth);
        }
    }

    private void setupTimePicker(final TextView view){
       TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
           @Override
           public void onTimeSet(TimePicker timePicker, int hourse, int minute) {
               view.setText(hourse + ":" + minute);
           }
       },0,0,true);
       timePicker.setTitle("Chọn giờ");
       timePicker.show();
    }

    public interface DeleteItemListener{
        public void onDeletel(int postion);
    }

}
