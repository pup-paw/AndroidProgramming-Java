package com.example.project5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0));
        setContentView(baseLayout, params);

        Button btn1 = new Button(this);
        btn1.setText("최지연(201958053)");
        baseLayout.addView(btn1);

        Button btn2 = new Button(this);
        btn2.setText("숨김 버튼");
        btn2.setVisibility(View.INVISIBLE);
        baseLayout.addView(btn2);

        TextView text = new TextView(this);
        text.setText("파란색 글씨 텍스트뷰");
        text.setTextColor(Color.rgb(0, 0, 255));
        baseLayout.addView(text);
    }
}