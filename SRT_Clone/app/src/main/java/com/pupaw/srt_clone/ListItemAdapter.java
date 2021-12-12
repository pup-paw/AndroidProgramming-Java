package com.pupaw.srt_clone;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItemAdapter extends BaseAdapter {
    ArrayList<ListItem> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CustomViewHolder holder;
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_item, null, false);

            holder = new CustomViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            holder.textView1 = (TextView) view.findViewById(R.id.text1);
            holder.textView2 = (TextView) view.findViewById(R.id.text2);

            view.setTag(holder);
        } else {
            holder = (CustomViewHolder) view.getTag();
        }

        ListItem listItem = items.get(i);

        holder.imageView.setImageResource(listItem.getResId());
        holder.textView1.setText(listItem.getText1());
        holder.textView2.setText(listItem.getText2());

        return view;
    }

    class CustomViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }

    public void addItem(ListItem item) {
        items.add(item);
    }
}
