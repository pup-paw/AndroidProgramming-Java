package com.pupaw.srt_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class DepartureDate extends AppCompatActivity {
    MaterialCalendarView calendar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departure_date);
    }

    class MyAdapter extends BaseAdapter {
        Context context;
        int layout;
        int img[];
        LayoutInflater inf;

        public MyAdapter(Context context, int layout, int[] img) {
            this.context = context;
            this.layout = layout;
            this.img = img;
            inf = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() { // 보여줄 데이터의 총 개수 - 꼭 작성해야 함
            return img.length;
        }

        @Override
        public Object getItem(int position) { // 해당행의 데이터- 안해도 됨
            return null;
        }

        @Override
        public long getItemId(int position) { // 해당행의 유니크한 id - 안해도 됨
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}