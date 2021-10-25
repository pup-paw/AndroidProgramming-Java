package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart, btnStop;
        final ViewFlipper viewFlipper;

        ImageView image1, image2, image3;

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        image1 = (ImageView) findViewById(R.id.image1);
        image1.setImageResource(R.drawable.androidpie);
        image2 = (ImageView) findViewById(R.id.image2);
        image2.setImageResource(R.drawable.androidq);
        image3 = (ImageView) findViewById(R.id.image3);
        image3.setImageResource(R.drawable.androidr);

        viewFlipper.setFlipInterval(1000);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.stopFlipping();
            }
        });
    }
}