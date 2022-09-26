package com.example.cubetimer.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.cubetimer.Presenter.MainContract;
import com.example.cubetimer.Presenter.MainPresenter;
import com.example.cubetimer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    MainContract.Presenter presenter;

    TimerFragment timerFragment;

    BottomNavigationView bottomNavi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        init();
    }

    private void init() {
        timerFragment = new TimerFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, timerFragment).commit();

        bottomNavi = findViewById(R.id.bottomNavi);
        bottomNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        return true;

                    case R.id.tab2:
                        return true;

                    case R.id.tab3:
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onTabSelected(int position) {
        if(position == 0) {
            bottomNavi.setSelectedItemId(R.id.tab1);
        } else if(position == 1) {
            bottomNavi.setSelectedItemId(R.id.tab2);
        } else if(position == 2) {
            bottomNavi.setSelectedItemId(R.id.tab3);
        }
    }
}