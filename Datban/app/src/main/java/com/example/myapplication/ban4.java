package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.Adapter.Adapterban;
import com.example.myapplication.DAO.BanDAO;
import com.example.myapplication.DTO.Ban;
import com.example.myapplication.databinding.ActivityBan4Binding;
import com.example.myapplication.databinding.ActivityBan6Binding;

import java.util.ArrayList;

public class ban4 extends AppCompatActivity {


    Adapterban adapterban;
    ArrayList<Ban> dulieuban = new ArrayList<>();
    private ActivityBan4Binding binding;
    BanDAO banDAO = new BanDAO();
    String url = "https://dsdiw.000webhostapp.com/loaiban.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBan4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapterban = new Adapterban(ban4.this,dulieuban,R.layout.custom);
        binding.lvban4.setAdapter(adapterban);
        banDAO.getdata(url,dulieuban,adapterban,ban4.this);
        load();


    }
    public void load()
    {
        binding.lvban4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                banDAO.loadmore(dulieuban,position,ban4.this);
            }
        });
    }
}