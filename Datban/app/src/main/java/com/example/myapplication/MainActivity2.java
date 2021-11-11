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

public class MainActivity2 extends AppCompatActivity {

    ListView lvban;
    Adapterban adapterban;
    ArrayList<Ban> dulieuban = new ArrayList<>();
    BanDAO banDAO = new BanDAO();
    String urlban = "https://dsdiw.000webhostapp.com/getBan.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhxa();
        adapterban = new Adapterban(MainActivity2.this,dulieuban,R.layout.custom);
        banDAO.getdata(urlban,dulieuban,adapterban,MainActivity2.this);
        lvban.setAdapter(adapterban);
    }
    public void anhxa()
    {
        lvban = findViewById(R.id.listban);
        lvban.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                banDAO.loadmore(dulieuban,position,MainActivity2.this);
                return false;

            }
        });

    }
}