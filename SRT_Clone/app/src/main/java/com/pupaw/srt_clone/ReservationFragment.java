package com.pupaw.srt_clone;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ReservationFragment extends Fragment {
    TextView tvDepartureName, tvArrivalName;
    RelativeLayout calenderTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup reservationView = (ViewGroup) inflater.inflate(R.layout.fragment_reservation, container, false);

        calenderTitle = (RelativeLayout) reservationView.findViewById(R.id.calenderTitle);
        calenderTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(reservationView.getContext().getApplicationContext(), DepartureDate.class);
                startActivityForResult(intent, 102);
            }
        });

        tvDepartureName = (TextView) reservationView.findViewById(R.id.tvDepartureName);
        tvArrivalName = (TextView) reservationView.findViewById(R.id.tvArrivalName);

                TextView[] tvDepartureArrival = new TextView[4];
        int[] tvDepartureArrivalId = {R.id.tvDeparture, R.id.tvDepartureName, R.id.tvArrival, R.id.tvArrivalName};
        for (int i = 0; i < 4; i++) {
            tvDepartureArrival[i] = (TextView) reservationView.findViewById(tvDepartureArrivalId[i]);
            tvDepartureArrival[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(reservationView.getContext().getApplicationContext(), StationSelect.class);
                    startActivityForResult(intent, 101);
                }
            });
        }


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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101) {
            String departureArea = data.getStringExtra("departureArea");
            tvDepartureName.setText(departureArea);
            String arrivalArea = data.getStringExtra("arrivalArea");
            tvArrivalName.setText(arrivalArea);
        } else if(requestCode == 102) {

        }
    }
}