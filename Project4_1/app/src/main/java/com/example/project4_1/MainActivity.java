package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    TextView textResult;
    String num1, num2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);
        textResult = (TextView) findViewById(R.id.TextResult);

        Toast err = Toast.makeText(MainActivity.this, "숫자를 입력해주세요.", Toast.LENGTH_SHORT);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if(num1.isEmpty() || num2.isEmpty()) {
                        err.show();
                    }
                    else {
                        result = Double.parseDouble(num1) + Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + result.toString());
                    }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.isEmpty() || num2.isEmpty()) {
                    err.show();
                }
                else {
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.isEmpty() || num2.isEmpty()) {
                    err.show();
                }
                else {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.isEmpty() || num2.isEmpty()) {
                    err.show();
                }
                else {
                    if (num1.equals("0")) {
                        Toast warn = Toast.makeText(MainActivity.this, "잘못된 입력입니다.", Toast.LENGTH_SHORT);
                        warn.show();
                    } else {

                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });
        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.isEmpty() || num2.isEmpty()) {
                    err.show();
                }
                else {
                    if (num1.equals("0")) {
                        Toast warn = Toast.makeText(MainActivity.this, "잘못된 입력입니다.", Toast.LENGTH_SHORT);
                        warn.show();
                    } else {

                        result = Double.parseDouble(num1) % Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });
    }
}