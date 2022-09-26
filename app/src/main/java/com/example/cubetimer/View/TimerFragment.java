package com.example.cubetimer.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cubetimer.Presenter.TimerContract;
import com.example.cubetimer.Presenter.TimerPresenter;
import com.example.cubetimer.R;

public class TimerFragment extends Fragment implements TimerContract.View {
    TimerPresenter timerPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_timer, container, false);
        init(rootView);
        return rootView;
    }

    private void init(ViewGroup rootView) {
        timerPresenter = new TimerPresenter(this);
    }
}