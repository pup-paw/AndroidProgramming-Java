package com.pupaw.srt_clone;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StationSelect extends AppCompatActivity {
    Button closeBtn, departureBtn, arrivalBtn, reloadBtn, selectBtn;
    ImageButton exchangeBtn, srtBtn, korailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_select);

        selectBtn = (Button) findViewById(R.id.selectBtn);
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departureArea = (String) departureBtn.getText();
                String arrivalArea = (String) arrivalBtn.getText();
            }
        });

        reloadBtn = (Button) findViewById(R.id.reloadBtn);
        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                departureBtn.setTextColor(rgb(145,145,145));
                departureBtn.setText("수서");
                arrivalBtn.setTextColor(rgb(145,145,145));
                arrivalBtn.setText("광주송성");
                srtBtn.setImageResource(R.drawable.btn_srt);
                korailBtn.setImageResource(R.drawable.btn_korail_unclicked);
            }
        });

        srtBtn = (ImageButton) findViewById(R.id.srtBtn);
        srtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                srtBtn.setImageResource(R.drawable.btn_srt);
                korailBtn.setImageResource(R.drawable.btn_korail_unclicked);
            }
        });
        korailBtn = (ImageButton) findViewById(R.id.korailBtn);
        korailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                srtBtn.setImageResource(R.drawable.btn_srt_unclicked);
                korailBtn.setImageResource(R.drawable.btn_korail);
            }
        });

        Button[] areaBtn = new Button[17];
        int[] areaBtnId = {R.id.area1, R.id.area2, R.id.area3, R.id.area4, R.id.area5, R.id.area6, R.id.area7, R.id.area8, R.id.area9, R.id.area10, R.id.area11, R.id.area12, R.id.area13, R.id.area14, R.id.area15, R.id.area16, R.id.area17};
        for(int i = 0 ; i < 17; i++) {
            areaBtn[i] = (Button) findViewById(areaBtnId[i]);
        }

        departureBtn = (Button) findViewById(R.id.departureBtn);
        departureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrivalBtn.setTextColor(rgb(145,145,145));
                departureBtn.setTextColor(rgb(151,69,129));
                for(Button btn : areaBtn) {
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            departureBtn.setText(btn.getText());
                        }
                    });
                }
            }
        });

        arrivalBtn = (Button) findViewById(R.id.arrivalBtn);
        arrivalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                departureBtn.setTextColor(rgb(145,145,145));
                arrivalBtn.setTextColor(rgb(151,69,129));
                for(Button btn : areaBtn) {
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            arrivalBtn.setText(btn.getText());
                        }
                    });
                }
            }
        });

        exchangeBtn = (ImageButton) findViewById(R.id.exchangeBtn);
        exchangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = (String) departureBtn.getText();
                departureBtn.setText(arrivalBtn.getText());
                arrivalBtn.setText(tmp);
            }
        });


        closeBtn = (Button) findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("departureArea", departureBtn.getText());
                intent.putExtra("arrivalArea", arrivalBtn.getText());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}