package com.example.cubetimer.Presenter;

public interface MainContract {

    interface View {
        void onTabSelected(int position);
    }

    interface Presenter {
        void onTabItemSelectedListener();
    }
}