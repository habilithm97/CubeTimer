package com.example.cubetimer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubetimer.Model.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    public static ArrayList<Model> items = new ArrayList<>();

    Context context;

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);

        context = viewGroup.getContext();

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        Model item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Model item) {
        items.add(item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView record, scramble;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            record = (TextView)itemView.findViewById(R.id.record);
            scramble = (TextView)itemView.findViewById(R.id.scramble);
        }

        public void setItem(Model item) {
            record.setText(item.getRecord());
            scramble.setText(item.getScramble());
        }
    }
}
