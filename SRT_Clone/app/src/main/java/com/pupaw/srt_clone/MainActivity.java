package com.pupaw.srt_clone;

import static com.pupaw.srt_clone.R.id.tab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Button chatbotBtn, quickMenuBtn;
    ListView list;
    ListItemAdapter adapter;

    LinearLayout container;
    BottomNavigationView bottomNavigationView;
    ReservationFragment reservationFragment;
    ConfirmationFragment confirmationFragment;
    SeasonpassFragment seasonpassFragment;
    TravlepackageFragment travlepackageFragment;

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        return super.onNavigateUpFromChild(child);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quickMenuBtn = (Button) findViewById(R.id.quickMenuBtn);
        quickMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuickMenu.class);
                startActivity(intent);
            }
        });


        chatbotBtn = (Button) findViewById(R.id.chatbotBtn);
        chatbotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

        reservationFragment = new ReservationFragment();
        confirmationFragment = new ConfirmationFragment();
        seasonpassFragment = new SeasonpassFragment();
        travlepackageFragment = new TravlepackageFragment();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        container = (LinearLayout) findViewById(R.id.container);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, reservationFragment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab1: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, reservationFragment).commit();
                        return true;
                    }
                    case R.id.tab2: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, confirmationFragment).commit();
                        return true;
                    }
                    case R.id.tab3: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, seasonpassFragment).commit();
                        return true;
                    }
                    case R.id.tab4: {
                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setMessage("시스템 점검 중 입니다.");
                        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        dlg.show();
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container, travlepackageFragment).commit();
                        return true;
                    }
                }
                return false;
            }
        });
    }
}