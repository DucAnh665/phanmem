package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DTO.Ban;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapterban extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Ban> mangban;

    public Adapterban(Context context, int layout, ArrayList<Ban> mangban) {
        this.context = context;
        this.layout = layout;
        this.mangban = mangban;
    }

    @Override
    public int getCount() {
        return mangban.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    class Viewhodel {
        TextView txtmota;
        TextView txtsoban;
        ImageView anhban;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Viewhodel viewhodel;

        if (view==null)
        {
            viewhodel = new Viewhodel();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);

            viewhodel.txtmota = (TextView) view.findViewById(R.id.textviewmota);
            viewhodel.txtsoban = (TextView) view.findViewById(R.id.textviewsoban);
            viewhodel.anhban = (ImageView) view.findViewById(R.id.imageviewban);
            view.setTag(viewhodel);
        }
        else {
            viewhodel = (Viewhodel) view.getTag();
        }
        Ban ban = mangban.get(position);
        Picasso.get().load(ban.getHinhanh()).placeholder(R.drawable.backgroud2).error(R.drawable.common_google_signin_btn_icon_dark).into(viewhodel.anhban);
        viewhodel.txtmota.setText(ban.getMota());
        viewhodel.txtsoban.setText(String.valueOf(ban.getSoban()));
        return view;
    }
}
