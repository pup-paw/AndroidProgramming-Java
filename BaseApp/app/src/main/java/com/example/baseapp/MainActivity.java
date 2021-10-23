package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch startSwitch;

    RadioGroup rg;
    RadioButton radioBtn1;
    RadioButton radioBtn2;
    RadioButton radioBtn3;

    ImageView img;

    Button finishBtn;
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startSwitch = (Switch) findViewById(R.id.startSwitch);

        rg = (RadioGroup) findViewById(R.id.rg);
        radioBtn1 = (RadioButton) findViewById(R.id.radioBtn1);
        radioBtn2 = (RadioButton) findViewById(R.id.radioBtn2);
        radioBtn3 = (RadioButton) findViewById(R.id.radioBtn3);

        img = (ImageView) findViewById(R.id.img);

        finishBtn = (Button) findViewById(R.id.finishBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);

        startSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(startSwitch.isChecked()) {
                    rg.setVisibility(View.VISIBLE);
                }
                else {
                    rg.setVisibility(View.INVISIBLE);
                }
            }
        });

        radioBtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(radioBtn1.isChecked()) {
                    img.setVisibility(View.VISIBLE);
                    img.setImageResource(R.drawable.androidpie);
                }
            }
        });
        radioBtn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(radioBtn2.isChecked()) {
                    img.setImageResource(R.drawable.androidq);
                    img.setVisibility(View.VISIBLE);
                }
            }
        });
        radioBtn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(radioBtn3.isChecked()) {
                    img.setImageResource(R.drawable.androidr);
                    img.setVisibility(View.VISIBLE);
                }
            }
        });

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startSwitch.setChecked(false);
                radioBtn1.setChecked(false);
                radioBtn2.setChecked(false);
                radioBtn3.setChecked(false);
                img.setVisibility(View.INVISIBLE);
            }
        });
    }
}