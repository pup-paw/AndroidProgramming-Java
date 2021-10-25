package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.TabStopSpan;
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
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends TabActivity {//AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();
        ImageView dog, cat, rabbit, bear;

        TabHost.TabSpec tabSpecDog = tabHost.newTabSpec("DOG").setIndicator("강아지");
        tabSpecDog.setContent(R.id.dog);
        tabHost.addTab(tabSpecDog);
        dog = (ImageView) findViewById(R.id.dog);
        dog.setImageResource(R.drawable.dog);

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("CAT").setIndicator("고양이");
        tabSpecCat.setContent(R.id.cat);
        tabHost.addTab(tabSpecCat);
        cat = (ImageView) findViewById(R.id.cat);
        cat.setImageResource(R.drawable.cat);

        TabHost.TabSpec tabSpecRabbit = tabHost.newTabSpec("RABBIT").setIndicator("토끼");
        tabSpecRabbit.setContent(R.id.rabbit);
        tabHost.addTab(tabSpecRabbit);
        rabbit = (ImageView) findViewById(R.id.rabbit);
        rabbit.setImageResource(R.drawable.rabbit);

        TabHost.TabSpec tabSpecBear = tabHost.newTabSpec("BEAR").setIndicator("곰");
        tabSpecBear.setContent(R.id.bear);
        tabHost.addTab(tabSpecBear);
        bear = (ImageView) findViewById(R.id.bear);
        bear.setImageResource(R.drawable.bear);

        tabHost.setCurrentTab(0);
    }
}