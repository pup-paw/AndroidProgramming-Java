package com.example.project6_1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer1;
    RadioButton rdoCal, rdoTime;
    DatePicker datePicker1;
    TimePicker timePicker1;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chronometer1 = (Chronometer) findViewById(R.id.chronometer1);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        datePicker1 = (DatePicker) findViewById(R.id.datePicker1);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        datePicker1.setVisibility(View.INVISIBLE);
        timePicker1.setVisibility(View.INVISIBLE);

        chronometer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
                chronometer1.setTextColor(Color.RED);
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer1.stop();
                chronometer1.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvHour.setText(Integer.toString(timePicker1.getHour()));
                tvMinute.setText(Integer.toString(timePicker1.getMinute()));

                datePicker1.setVisibility(view.INVISIBLE);
                timePicker1.setVisibility(view.INVISIBLE);
                rdoCal.setChecked(false);
                rdoTime.setChecked(false);
                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker1.setVisibility(view.VISIBLE);
                timePicker1.setVisibility(view.INVISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker1.setVisibility(view.INVISIBLE);
                timePicker1.setVisibility(view.VISIBLE);
            }
        });

        datePicker1.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                selectYear = i;
                selectMonth = i1+1;
                selectDay = i2;
            }
        });
    }
}