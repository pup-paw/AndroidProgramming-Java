package com.pupaw.srt_clone;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class QuickMenu extends AppCompatActivity {
    private ListItemAdapter adapter;
    private ListView listView;
    Button closeBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_menu);

        closeBtn = (Button) findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        adapter = new ListItemAdapter();
        listView = (ListView) findViewById(R.id.listView);

        setData();

        listView.setAdapter(adapter);
    }

    private void setData() {
        TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
        String[] text1 = getResources().getStringArray(R.array.text1);
        String[] text2 = getResources().getStringArray(R.array.text2);

        for (int i = 0; i < arrResId.length(); i++) {
            ListItem item = new ListItem();
            item.setResId(arrResId.getResourceId(i, 0));
            item.setText1(text1[i]);
            item.setText2(text2[i]);

            adapter.addItem(item);
        }
    }
}
