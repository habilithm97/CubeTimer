package com.example.cubetimer.Presenter;

public interface TimerContract {

    interface View {
        void scrambleResult();
        void timerResult();
    }

    interface Presenter {
        void scrambleAction();
        void timerAction();
    }
}