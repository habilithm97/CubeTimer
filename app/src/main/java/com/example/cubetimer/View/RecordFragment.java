package com.example.cubetimer.View;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubetimer.ItemAdapter;
import com.example.cubetimer.Model.Model;
import com.example.cubetimer.Presenter.RecordContract;
import com.example.cubetimer.Presenter.RecordPresenter;
import com.example.cubetimer.Presenter.TimerContract;
import com.example.cubetimer.Presenter.TimerPresenter;
import com.example.cubetimer.R;

import java.util.ArrayList;
import java.util.Random;

public class RecordFragment extends Fragment implements RecordContract.View {
    RecordPresenter recordPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_record, container, false);
        init(rootView);
        return rootView;
    }

    private void init(ViewGroup rootView) {
        recordPresenter = new RecordPresenter(this);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        ItemAdapter adapter = new ItemAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        /*
        Bundle bundle = getArguments();
        String resultRecord = bundle.getString("resultRecord");
        String resultScramble = bundle.getString("resultScramble");
        Toast.makeText(getContext(), resultRecord + "\n" + resultScramble, Toast.LENGTH_SHORT).show();
        adapter.addItem(new Model(resultRecord, resultScramble));
        adapter.notifyDataSetChanged(); */
    }
}