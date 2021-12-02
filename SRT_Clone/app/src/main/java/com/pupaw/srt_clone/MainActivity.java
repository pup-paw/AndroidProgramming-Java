package com.pupaw.srt_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageButton exchangeBtn, reservationBtn, confirmationBtn, seasonPassBtn, travelPackageBtn;
    ImageView infoImg, noticeImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exchangeBtn = (ImageButton) findViewById(R.id.exchangeBtn);
        exchangeBtn.setImageResource(R.drawable.btn_exchange);

        infoImg = (ImageView) findViewById(R.id.infoImg);
        noticeImg = (ImageView) findViewById(R.id.noticeImg);
        infoImg.setImageResource(R.drawable.banner_info);
        noticeImg.setImageResource(R.drawable.banner_notice);

        reservationBtn = (ImageButton) findViewById(R.id.reservationBtn);
        confirmationBtn = (ImageButton) findViewById(R.id.confirmationBtn);
        seasonPassBtn = (ImageButton) findViewById(R.id.seasonPassBtn);
        travelPackageBtn = (ImageButton) findViewById(R.id.travelPackageBtn);
        reservationBtn.setImageResource(R.drawable.btn_clicked_reservation);
        confirmationBtn.setImageResource(R.drawable.btn_unclicked_confirmation);
        seasonPassBtn.setImageResource(R.drawable.btn_unclicked_seasonpass);
        travelPackageBtn.setImageResource(R.drawable.btn_clicked_travelpackage);
    }
}