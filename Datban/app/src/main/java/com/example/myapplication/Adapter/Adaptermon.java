package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DTO.Ban;
import com.example.myapplication.DTO.Monan;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptermon extends RecyclerView.Adapter<Adaptermon.viewhodel> {

    private  ArrayList<Monan> listmon;
    Context context;

    public Adaptermon(ArrayList<Monan> listmon, Context context) {
        this.listmon = listmon;
        this.context = context;
    }

    @NonNull
    @Override
    public viewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =  layoutInflater.inflate(R.layout.ctmonan,parent,false);
        return new viewhodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewhodel holder, int position) {
        Monan list = listmon.get(position);
        holder.tenmon.setText(list.getTenmon());
        holder.giamon.setText(String.valueOf(list.getGia()));
        Picasso.get().load(list.getHinhanh()).placeholder(R.drawable.restaurant).into(holder.imganh);

    }

    @Override
    public int getItemCount() {
        return listmon.size();
    }

    public static class viewhodel extends RecyclerView.ViewHolder
    {
        TextView tenmon,giamon;
        ImageView imganh;


        public viewhodel(@NonNull View itemView) {
            super(itemView);
            tenmon = itemView.findViewById(R.id.tenmonan);
            giamon = itemView.findViewById(R.id.giamon);
            imganh = itemView.findViewById(R.id.imgmonan);



        }
    }


}
