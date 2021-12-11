package com.pupaw.srt_clone;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ReservationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup reservationView = (ViewGroup) inflater.inflate(R.layout.fragment_reservation, container, false);
        TextView[] tvCounts = new TextView[6];
        int[] tvCountsId = {R.id.tvCount1, R.id.tvCount2, R.id.tvCount3, R.id.tvCount4, R.id.tvCount5, R.id.tvCount6};
        for (int i = 0; i < 6; i++) {
            tvCounts[i] = (TextView) reservationView.findViewById(tvCountsId[i]);
        }
        Button[] minusBtns = new Button[6];
        int[] minusBtnId = {R.id.minusBtn1, R.id.minusBtn2, R.id.minusBtn3, R.id.minusBtn4, R.id.minusBtn5, R.id.minusBtn6};
        for (int i = 0; i < 6; i++) {
            minusBtns[i] = (Button) reservationView.findViewById(minusBtnId[i]);
            int finalI = i;
            minusBtns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int count = Integer.parseInt((String) tvCounts[finalI].getText()) - 1;
                    count = Math.max(count, 0);
                    tvCounts[finalI].setText(Integer.toString(count));
                }
            });
        }
        Button[] plusBtns = new Button[6];
        int[] plusBtnId = {R.id.plusBtn1, R.id.plusBtn2, R.id.plusBtn3, R.id.plusBtn4, R.id.plusBtn5, R.id.plusBtn6};
        for (int i = 0; i < 6; i++) {
            plusBtns[i] = (Button) reservationView.findViewById(plusBtnId[i]);
            int finalI = i;
            plusBtns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int count = Integer.parseInt((String) tvCounts[finalI].getText()) + 1;
                    tvCounts[finalI].setText(Integer.toString(count));
                }
            });
        }


        return reservationView;
    }
}