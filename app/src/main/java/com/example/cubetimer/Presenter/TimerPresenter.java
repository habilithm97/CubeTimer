package com.example.cubetimer.Presenter;

public class TimerPresenter implements TimerContract.Presenter {
    TimerContract.View view;

    public TimerPresenter(TimerContract.View view) {
        this.view = view;
    }
}