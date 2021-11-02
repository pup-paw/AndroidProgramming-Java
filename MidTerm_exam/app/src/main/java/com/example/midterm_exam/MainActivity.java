package com.example.midterm_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnName, btnNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("중간고사 실기");

        btnName = (Button) findViewById(R.id.btnName);
        btnNum = (Button) findViewById(R.id.btnNum);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nameRed:
                btnName.setBackgroundColor(Color.RED);
            case R.id.nameBlue:
                btnName.setBackgroundColor(Color.BLUE);
            case R.id.numRed:
                btnNum.setBackgroundColor(Color.RED);
            case R.id.numGreen:
                btnNum.setBackgroundColor(Color.GREEN);
        }
        return false;
    }
}