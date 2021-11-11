package com.example.myapplication.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.myapplication.DTO.Ban;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapterban extends BaseAdapter {
    Context context;
    ArrayList<Ban> listban;
    int layout;

    public Adapterban(Context context, ArrayList<Ban> listban, int layout) {
        this.context = context;
        this.listban = listban;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return listban.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class Viewhodel
    {
        ImageView img;
        TextView mota,soban;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewhodel viewhodel;
        if (convertView == null)
        {
            viewhodel = new Viewhodel();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewhodel.img = (ImageView)convertView.findViewById(R.id.imageviewban);
            viewhodel.mota = (TextView) convertView.findViewById(R.id.textviewmota);
            viewhodel.soban = (TextView) convertView.findViewById(R.id.textviewsoban);
            convertView.setTag(viewhodel);

        }
        else
        {
            viewhodel = (Viewhodel) convertView.getTag();
        }
        Ban list = listban.get(position);
        Picasso.get().load(list.getHinhanh()).placeholder(R.drawable.restaurant).into(viewhodel.img);
        viewhodel.mota.setText(list.getMota());
        viewhodel.soban.setText(String.valueOf(list.getSoban()));
        return convertView;
    }


}
