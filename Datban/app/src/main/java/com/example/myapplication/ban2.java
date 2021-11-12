package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.Adapter.Adapterban;
import com.example.myapplication.DAO.BanDAO;
import com.example.myapplication.DTO.Ban;

import java.util.ArrayList;

public class ban2 extends AppCompatActivity {

    Adapterban adapterban;
    ListView lvban2;
    ArrayList<Ban> dlieu = new ArrayList<>();
    BanDAO banDAO = new BanDAO();
    String url = "https://dsdiw.000webhostapp.com/loaiban2.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban2);
        lvban2 = findViewById(R.id.lvban2);
        adapterban = new Adapterban(ban2.this,dlieu,R.layout.custom);
        lvban2.setAdapter(adapterban);
        banDAO.getdata(url,dlieu,adapterban,ban2.this);
        load();
    }
    public void load()
    {
        lvban2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                banDAO.loadmore(dlieu,position,ban2.this);
            }
        });
    }

}