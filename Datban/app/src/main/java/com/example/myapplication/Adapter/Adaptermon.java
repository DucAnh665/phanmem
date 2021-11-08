package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DTO.Monan;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptermon extends RecyclerView.Adapter<Adaptermon.viewhodel> {

    private ArrayList<Monan> listmon;
    private Context context;

    public Adaptermon(ArrayList<Monan> listmon, Context context) {
        this.listmon = listmon;
        this.context = context;
    }

    @NonNull
    @Override
    public viewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.ctmonan,parent,false);
        return new viewhodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewhodel holder, int position) {
        Monan list = listmon.get(position);
       // holder.txtmota.setText(list.getMota());
        holder.txtten.setText(list.getTenmon());
        holder.txtgia.setText(String.valueOf(list.getGia()));
        Picasso.get().load(list.getHinhanh()).placeholder(R.drawable.restaurant).error(R.drawable.white_radius).into(holder.imgmonan);

    }

    @Override
    public int getItemCount() {
        return listmon.size();
    }

    public  static class viewhodel extends RecyclerView.ViewHolder
    {
        ImageView imgmonan;
        TextView txtten,txtmota,txtgia;
        public viewhodel(@NonNull View itemView) {
            super(itemView);
            imgmonan = itemView.findViewById(R.id.imgmonan);
            txtten = itemView.findViewById(R.id.tenmonan);
            txtgia =itemView.findViewById(R.id.giamon);
        }
    }
}
