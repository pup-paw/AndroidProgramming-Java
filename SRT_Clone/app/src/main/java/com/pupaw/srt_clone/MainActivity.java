package com.pupaw.srt_clone;

import static com.pupaw.srt_clone.R.id.tab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
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
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, travlepackageFragment).commit();
                        return true;
                    }
                }
                return false;
            }
        });
    }
}