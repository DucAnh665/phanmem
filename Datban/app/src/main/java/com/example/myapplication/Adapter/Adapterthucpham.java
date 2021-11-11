package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.DTO.Monan;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapterthucpham extends BaseAdapter {
    ArrayList<Monan> listmonan;
    Context context;
    int layout;

    public Adapterthucpham(ArrayList<Monan> listmonan, Context context, int layout) {
        this.listmonan = listmonan;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return listmonan.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    class Viewhodel
    {
        TextView ten,mota,gia;
        ImageView imgmon;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewhodel viewhodel;
        if (convertView==null)
        {
            viewhodel = new Viewhodel();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewhodel.ten = (TextView)convertView.findViewById(R.id.tenmonan);
            viewhodel.mota = (TextView) convertView.findViewById(R.id.motamonan);
            viewhodel.gia = (TextView) convertView.findViewById(R.id.giamon);
            viewhodel.imgmon = (ImageView) convertView.findViewById(R.id.imgmonan);
            convertView.setTag(viewhodel);

        }
        else
        {
            viewhodel = (Viewhodel)convertView.getTag();
        }

        Monan list = listmonan.get(position);
        viewhodel.ten.setText(list.getTenmon());
        viewhodel.mota.setText(list.getMota());
        viewhodel.gia.setText(String.valueOf(list.getGia()));
        Picasso.get().load(list.getHinhanh()).placeholder(R.drawable.restaurant).into(viewhodel.imgmon);
        return convertView;

    }
}
