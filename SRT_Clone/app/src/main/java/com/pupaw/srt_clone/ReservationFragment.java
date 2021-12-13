package com.pupaw.srt_clone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ReservationFragment extends Fragment {
    TextView tvDepartureName, tvArrivalName, dateInfoText, timeInfoText;
    RelativeLayout calenderTitle;
    Button chatbotBtn, quickMenuBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, String> weekDayConvert = new HashMap<String, String>();
        weekDayConvert.put("Sun", "월");
        weekDayConvert.put("Mon", "화");
        weekDayConvert.put("Tue", "수");
        weekDayConvert.put("Wed", "목");
        weekDayConvert.put("Thu", "금");
        weekDayConvert.put("Fri", "토");
        weekDayConvert.put("Sat", "일");

        ViewGroup reservationView = (ViewGroup) inflater.inflate(R.layout.fragment_reservation, container, false);

        dateInfoText = (TextView) reservationView.findViewById(R.id.dateInfoText);
        timeInfoText = (TextView) reservationView.findViewById(R.id.timeInfoText);
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat weekdayFormat = new SimpleDateFormat("EE", Locale.getDefault());
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
        SimpleDateFormat hourFormat = new SimpleDateFormat("hh", Locale.getDefault());

        String weekDay = weekDayConvert.get(weekdayFormat.format(currentTime));
        String year = yearFormat.format(currentTime);
        String month = monthFormat.format(currentTime);
        String day = dayFormat.format(currentTime);
        int dayInt = Integer.parseInt(day) + 1;
        day = Integer.toString(dayInt);
        String hour = hourFormat.format(currentTime);
        int hourInt = Integer.parseInt(hour) + 17;
        hour = Integer.toString(hourInt);
        dateInfoText.setText(year + "년 " + month + "월 " + day + "일(" + weekDay + ")");
        timeInfoText.setText(hour+"시");


        quickMenuBtn = (Button) reservationView.findViewById(R.id.quickMenuBtn);
        quickMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(reservationView.getContext().getApplicationContext(), QuickMenu.class);
                startActivity(intent);
            }
        });


        chatbotBtn = (Button) reservationView.findViewById(R.id.chatbotBtn);
        chatbotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(reservationView.getContext());
                builder.setMessage("SRT 챗봇은 카카오톡 기반의 고객 안내 서비스입니다. \n" +
                        "상담원 연결이 필요한 고객님께서는 SR 고객센터(1800-1472)를 이용해주십시오.\n" +
                        "SRT 챗봇으로 이동하시겠습니까?");
                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

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
            try {
                String departureArea = data.getStringExtra("departureArea");
                tvDepartureName.setText(departureArea);
                String arrivalArea = data.getStringExtra("arrivalArea");
                tvArrivalName.setText(arrivalArea);
            } catch (NullPointerException e) {
                tvDepartureName.setText("수서");
                tvArrivalName.setText("광주송정");
            }

        } else if(requestCode == 102) {
            try {
                String date = data.getStringExtra("date");
                dateInfoText.setText(date);
                String hour = data.getStringExtra("hour");
                timeInfoText.setText(hour);
            } catch (NullPointerException e) {

                dateInfoText.setText(dateInfoText.getText());
                timeInfoText.setText(timeInfoText.getText());
            }
        }
    }
}