package com.example.cubetimer.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.cubetimer.Presenter.MainContract;
import com.example.cubetimer.Presenter.MainPresenter;
import com.example.cubetimer.R;
import com.example.cubetimer.SendDataListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MainContract.View, SendDataListener {
    MainContract.Presenter presenter;

    //GragphFragment graphFragment;
    TimerFragment timerFragment;
    RecordFragment recordFragment;

    BottomNavigationView bottomNavi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        init();
    }

    private void init() {
        //graphFragment = new GraphFragment();
        timerFragment = new TimerFragment();
        recordFragment = new RecordFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, timerFragment).commit();

        bottomNavi = findViewById(R.id.bottomNavi);
        bottomNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container, graphFragment).commit();
                        return true;

                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, timerFragment).commit();
                        return true;

                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, recordFragment).commit();
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

    @Override
    public void sendData(Bundle bundle) {
        // TimeFragment에서 번들을 받아서 RecordFragment에 전달
        Bundle bundle1 = bundle;
        recordFragment.setArguments(bundle1);
    }
}