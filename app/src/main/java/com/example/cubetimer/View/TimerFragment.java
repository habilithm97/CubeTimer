package com.example.cubetimer.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
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

    boolean isRunning = false;
    int btnCnt = 0;
    int i = 0;
    Thread timeThread = null;
    TextView timeTv;

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
                timerPresenter.timerAction();
            }
        });

        timeTv = rootView.findViewById(R.id.timeTv);
    }

    @Override
    public void scrambleResult() {
        for(int i = 1; i <= 25; i++) {
            int x = random.nextInt(scrambleArray.length);
            finalScramble.add(scrambleArray[x]);

            // ArrayList의 대괄호와 쉼표 제거 후 출력 -> str과 " "만 출력함
            StringBuilder sb = new StringBuilder();
            for(String str : finalScramble) {
                sb.append(str);
                sb.append(" ");
            }
            scrambleTv.setText(sb.toString());
        }
    }

    @Override
    public void timerResult() {
        if(btnCnt == 0) {
            timeThread = new Thread(new TimeThread());
            timeThread.start();
            isRunning = true;
            btnCnt++;

            if(!timeTv.getText().toString().equals("00:00.00")) {
                i = 0;
                timeTv.setText("00:00.00");
            }
        } else if(btnCnt == 1) {
            isRunning = !isRunning;
            btnCnt--;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int mSec = msg.arg1 % 100;
            int sec = (msg.arg1 / 100) % 60;
            int min = (msg.arg1 / 100) / 60;

            String result = String.format("%02d:%02d.%02d", min, sec, mSec);
            timeTv.setText(result);
        }
    };

    public class TimeThread implements Runnable {
        @Override
        public void run() {
            while(isRunning) {
                Message msg = new Message();
                msg.arg1 = i++;
                handler.sendMessage(msg);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        finalScramble.clear();
        timerPresenter.scrambleAction();
    }
}