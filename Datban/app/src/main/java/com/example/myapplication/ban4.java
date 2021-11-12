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

public class ban4 extends AppCompatActivity {


    Adapterban adapterban;
    ArrayList<Ban> dulieuban = new ArrayList<>();
    ListView lvban4;
    BanDAO banDAO = new BanDAO();
    String url = "https://dsdiw.000webhostapp.com/loaiban.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban4);
        lvban4 = findViewById(R.id.lvban4);
        adapterban = new Adapterban(ban4.this,dulieuban,R.layout.custom);
        lvban4.setAdapter(adapterban);
        banDAO.getdata(url,dulieuban,adapterban,ban4.this);
        load();


    }
    public void load()
    {
        lvban4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                banDAO.loadmore(dulieuban,position,ban4.this);
            }
        });
    }
}