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

public class ban6 extends AppCompatActivity {

    ListView lvban6;
    ArrayList<Ban>  dl = new ArrayList<>();
    Adapterban adapterban;
    BanDAO banDAO;
    String url = "https://dsdiw.000webhostapp.com/loaiban6.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban6);
        lvban6 = findViewById(R.id.lvban6);
        adapterban = new Adapterban(ban6.this,dl,R.layout.custom);
        lvban6.setAdapter(adapterban);
        banDAO.getdata(url,dl,adapterban,ban6.this);
        hien();
    }
    public void hien()
    {
        lvban6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                banDAO.loadmore(dl,position,ban6.this);
            }
        });
    }
}