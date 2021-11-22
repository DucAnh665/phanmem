package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.Adapter.Adapterban;
import com.example.myapplication.DAO.BanDAO;
import com.example.myapplication.DTO.Ban;
import com.example.myapplication.databinding.ActivityMain2Binding;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    //ListView lvban;
    private ActivityMain2Binding binding;
    Adapterban adapterban;
    ArrayList<Ban> dulieuban = new ArrayList<>();
    BanDAO banDAO = new BanDAO();
    String urlban = "https://dsdiw.000webhostapp.com/getBan.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        load();
        adapterban = new Adapterban(MainActivity2.this,dulieuban,R.layout.custom);
        banDAO.getdata(urlban,dulieuban,adapterban,MainActivity2.this);
        binding.listban.setAdapter(adapterban);
    }
    public void load()
    {
        binding.listban.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                banDAO.loadmore(dulieuban,position,MainActivity2.this);
                return false;

            }
        });

    }
}