package com.example.cubetimer.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cubetimer.Presenter.TimerContract;
import com.example.cubetimer.Presenter.TimerPresenter;
import com.example.cubetimer.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class TimerFragment extends Fragment implements TimerContract.View {
    TimerPresenter timerPresenter;

    TextView scrambleTv;

    String[] scrambleArray = {"U", "U'", "R", "R'", "L", "L'", "D", "D'", "F", "F'", "B", "B'", "U2", "R2", "L2", "D2", "F2", "B2"};
    ArrayList<String> finalScramble = new ArrayList<>();
    Random random = new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_timer, container, false);
        init(rootView);
        return rootView;
    }

    private void init(ViewGroup rootView) {
        timerPresenter = new TimerPresenter(this);

        scrambleTv = rootView.findViewById(R.id.scrambleTv);

        Button btn = rootView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalScramble.clear();
                timerPresenter.scrambleAction();
            }
        });
    }

    @Override
    public void scrambleResult() {
        for(int i = 1; i <= 25; i++) {
            int x = random.nextInt(scrambleArray.length);
            finalScramble.add(scrambleArray[x]);
            scrambleTv.setText(finalScramble + "");
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        finalScramble.clear();
        timerPresenter.scrambleAction();
    }
}