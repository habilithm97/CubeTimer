package com.example.cubetimer.Presenter;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    int position;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onTabItemSelectedListener() {
        view.onTabSelected(position);
    }
}