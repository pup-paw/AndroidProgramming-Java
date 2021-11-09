package com.pupaw.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    TextView textView1;
    myPictureView myPicture;
    int curNum=1;
    File[] imageFiles;
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        textView1 = (TextView) findViewById(R.id.textView1);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        imageFname = imageFiles[1].toString();
        myPicture.imagePath = imageFname;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum <= 1) {
                    curNum = imageFiles.length;
                }
                curNum--;
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath=imageFname;
                myPicture.invalidate();
                textView1.setText(String.valueOf(curNum)+"/5");
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum >= imageFiles.length-1) {
                    curNum = 0;
                }
                curNum++;
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath=imageFname;
                myPicture.invalidate();
                textView1.setText(String.valueOf(curNum)+"/5");
            }
        });
    }
}