package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.Adapter.Adapterban;
import com.example.myapplication.DAO.BanDAO;
import com.example.myapplication.DTO.Ban;
import com.example.myapplication.databinding.ActivityBan6Binding;

import java.util.ArrayList;

public class ban6 extends AppCompatActivity {

    private ActivityBan6Binding binding;
    ArrayList<Ban>  dl = new ArrayList<>();
    Adapterban adapterban;
    BanDAO banDAO;
    String url = "https://dsdiw.000webhostapp.com/loaiban6.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBan6Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        banDAO = new BanDAO();
        adapterban = new Adapterban(ban6.this,dl,R.layout.custom);
        binding.lvban6.setAdapter(adapterban);
        banDAO.getdata(url,dl,adapterban,ban6.this);
        hien();
    }
    public void hien()
    {
        binding.lvban6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                banDAO.loadmore(dl,position,ban6.this);
            }
        });
    }
}