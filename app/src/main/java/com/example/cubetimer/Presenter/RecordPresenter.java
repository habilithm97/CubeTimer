package com.example.cubetimer.Presenter;

import com.example.cubetimer.Model.Model;

public class RecordPresenter implements RecordContract.Presenter {
    RecordContract.View view;
    Model model;
    String resultRecord, resultScramble;

    public RecordPresenter(RecordContract.View view) {
        this.view = view;
        model = new Model(resultRecord, resultScramble); // Model과 연결
    }

    @Override
    public void addAction() {
        view.addResult();
    }
}