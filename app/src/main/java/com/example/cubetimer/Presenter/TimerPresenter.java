package com.example.cubetimer.Presenter;

public class TimerPresenter implements TimerContract.Presenter {
    TimerContract.View view;

    public TimerPresenter(TimerContract.View view) {
        this.view = view;
    }

    @Override
    public void scrambleAction() {
        view.scrambleResult();
    }

    @Override
    public void timerAction() {
        view.timerResult();
    }
}