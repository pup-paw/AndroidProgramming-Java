package com.pupaw.srt_clone;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class DepartureDate extends AppCompatActivity {
    DatePicker datePicker1;
    TimePicker timePicker1;
    Button closeBtn, selectBtn;
    String selectedDate;
    String selectedHour;

    private void setSelectedDate(String date) {
        this.selectedDate = date;
    }

    private void setSelectedHour(String hour) {
        this.selectedHour = hour;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departure_date);

        datePicker1 = (DatePicker) findViewById(R.id.datePicker1);
        datePicker1.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                setSelectedDate(i + "년 " + i1 + "월 " + i2 + "일()");
            }
        });
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                setSelectedHour(i + "시");
            }
        });
        selectBtn = (Button) findViewById(R.id.selectBtn);
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("date", selectedDate);
                intent.putExtra("hour", selectedHour);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        closeBtn = (Button) findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}