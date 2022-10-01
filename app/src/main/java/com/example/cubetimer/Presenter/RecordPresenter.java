package com.example.cubetimer.Presenter;

public class RecordPresenter implements RecordContract.Presenter {
    RecordContract.View view;

    public RecordPresenter(RecordContract.View view) {
        this.view = view;
    }
}