package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DTO.Ban;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapterban extends RecyclerView.Adapter<Adapterban.Banviewhodel> {
    private  ArrayList<Ban> listban;
    private  Context context;

    public Adapterban(ArrayList<Ban> listban, Context context)
    {
        this.listban = listban;
        this.context = context;
    }

    @NonNull
    @Override
    public Banviewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.custom,parent,false);
        return new Banviewhodel(itemview);

    }

    @Override
    public void onBindViewHolder(@NonNull Banviewhodel holder, int position) {
        Ban list = listban.get(position);
        holder.txtmota.setText(list.getMota());
        holder.txtsoban.setText(String.valueOf(list.getSoban()));
        Picasso.get().load(list.getHinhanh()).placeholder(R.drawable.googleg_standard_color_18).error(R.drawable.common_full_open_on_phone).into(holder.imganh);

    }

    @Override
    public int getItemCount() {
        return listban.size();
    }

    public static class Banviewhodel extends RecyclerView.ViewHolder
    {
        TextView txtsoban,txtmota;
        ImageView imganh;


        public Banviewhodel(@NonNull View itemView) {
            super(itemView);
            txtsoban = itemView.findViewById(R.id.textviewsoban);
            txtmota = itemView.findViewById(R.id.textviewmota);
            imganh = itemView.findViewById(R.id.imageviewban);
        }
    }

}
