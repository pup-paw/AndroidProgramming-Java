package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2, text3;
    RadioGroup rGroup1;
    RadioButton rdo1, rdo2, rdo3, rdo4;
    ImageView imgMe;
    Button btnNext;
    int i = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("자기 소개 앱");

        text1 = (TextView) findViewById(R.id.Text1);
        text2 = (TextView) findViewById(R.id.Text2);

        text3 = (TextView) findViewById(R.id.Text3);

        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdo1 = (RadioButton) findViewById(R.id.Rdo1);
        rdo2 = (RadioButton) findViewById(R.id.Rdo2);
        rdo3 = (RadioButton) findViewById(R.id.Rdo3);
        rdo4 = (RadioButton) findViewById(R.id.Rdo4);

        imgMe = (ImageView) findViewById(R.id.ImgMe);
        imgMe.setImageResource(R.drawable.img1);
        btnNext = (Button) findViewById(R.id.BtnNext);

        //'선택 완료' 버튼 동작 리스너
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i % 3 == 1) {
                    imgMe.setImageResource(R.drawable.img1);
                    i++;
                }
                else if (i % 3 == 2) {
                    imgMe.setImageResource(R.drawable.img2);
                    i++;
                }
                else {
                    imgMe.setImageResource(R.drawable.img3);
                    i++;
                }
            }
        });
    }
}