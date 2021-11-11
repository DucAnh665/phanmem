package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.DTO.Monan;
import com.example.myapplication.DTO.THUCDON;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Thucdon;
import com.example.myapplication.home;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterThucdon extends BaseAdapter {
    ArrayList<THUCDON> dulieumonan;
    Context context;
    int Layout;

    public AdapterThucdon(ArrayList<THUCDON> dulieumonan, Context context, int layout) {
        this.dulieumonan = dulieumonan;
        this.context = context;
        Layout = layout;
    }

    @Override
    public int getCount() {
        return dulieumonan.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    class  Viewhodel
    {
        TextView tenmonan,gia,soban;
        ImageView anh;
        Button cong,tru,soluong;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewhodel viewhodel;
        if (convertView==null)
        {
            viewhodel = new Viewhodel();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(Layout,null);
            viewhodel.anh =(ImageView) convertView.findViewById(R.id.iconTD);
            viewhodel.tenmonan = (TextView) convertView.findViewById(R.id.tenmonantd);
            viewhodel.gia = (TextView) convertView.findViewById(R.id.giaGH);
            viewhodel.cong = (Button) convertView.findViewById(R.id.cong);
            viewhodel.tru = (Button)convertView.findViewById(R.id.tru);
            viewhodel.soluong = (Button) convertView.findViewById(R.id.giatritd);
            viewhodel.cong = (Button) convertView.findViewById(R.id.cong);
            viewhodel.tru= (Button) convertView.findViewById(R.id.tru);
            viewhodel.soban = (TextView)convertView.findViewById(R.id.soban);
            convertView.setTag(viewhodel);
        }
        else
        {
            viewhodel = (Viewhodel)convertView.getTag();
        }
        THUCDON monan = dulieumonan.get(position);
        viewhodel.tenmonan.setText(monan.getTensanpham());
        viewhodel.gia.setText(String.valueOf(monan.getGiasp()));
        Picasso.get().load(monan.getHinhanh()).placeholder(R.drawable.restaurant).into(viewhodel.anh);
        viewhodel.soluong.setText(String.valueOf(monan.getSoluongsp()));
        viewhodel.soban.setText(String.valueOf(monan.getSoban()));
        if (MainActivity.dulieuthucdon.get(position).getSoluongsp()<2)
        {
            viewhodel.tru.setVisibility(View.INVISIBLE);
            viewhodel.cong.setVisibility(View.VISIBLE);
        }
        if (MainActivity.dulieuthucdon.get(position).getSoluongsp()>9)
        {
            viewhodel.tru.setVisibility(View.VISIBLE);
            viewhodel.cong.setVisibility(View.INVISIBLE);
        }
        viewhodel.cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slew = Integer.parseInt(viewhodel.soluong.getText().toString())+1;
                int slht = MainActivity.dulieuthucdon.get(position).getSoluongsp();
                long giaht = MainActivity.dulieuthucdon.get(position).getGiasp();
                MainActivity.dulieuthucdon.get(position).setSoluongsp(slew);
                long gianew = (giaht*slew)/slht;
                MainActivity.dulieuthucdon.get(position).setGiasp(gianew);
                viewhodel.gia.setText(String.valueOf(gianew)+"Đ");
                Thucdon.nhangia();
                if (slew>=10)
                {
                    viewhodel.tru.setVisibility(View.VISIBLE);
                    viewhodel.cong.setVisibility(View.INVISIBLE);
                    viewhodel.soluong.setText(String.valueOf(slew));
                }
                else
                {
                    viewhodel.tru.setVisibility(View.VISIBLE);
                    viewhodel.cong.setVisibility(View.VISIBLE);
                    viewhodel.soluong.setText(String.valueOf(slew));
                }
            }
        });

        viewhodel.tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int slew = Integer.parseInt(viewhodel.soluong.getText().toString())-1;
                int slht = MainActivity.dulieuthucdon.get(position).getSoluongsp();
                long giaht = MainActivity.dulieuthucdon.get(position).getGiasp();
                MainActivity.dulieuthucdon.get(position).setSoluongsp(slew);
                long gianew = (giaht*slew)/slht;
                MainActivity.dulieuthucdon.get(position).setGiasp(gianew);
                viewhodel.gia.setText(String.valueOf(gianew)+"Đ");
                Thucdon.nhangia();
                if (slew<2)
                {
                    viewhodel.tru.setVisibility(View.INVISIBLE);
                    viewhodel.cong.setVisibility(View.VISIBLE);
                    viewhodel.soluong.setText(String.valueOf(slew));
                }
                else
                {
                    viewhodel.tru.setVisibility(View.VISIBLE);
                    viewhodel.cong.setVisibility(View.VISIBLE);
                    viewhodel.soluong.setText(String.valueOf(slew));
                }

            }
        });
        return convertView;
    }
}
