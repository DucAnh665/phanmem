package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.Adapter.Adapterthucpham;
import com.example.myapplication.DAO.MonanDTO;
import com.example.myapplication.DTO.Monan;
import com.example.myapplication.databinding.ActivityListthucphamBinding;

import java.util.ArrayList;

public class Listthucpham extends AppCompatActivity {

    ActivityListthucphamBinding binding;
  //  ListView lvthucpham;
    ArrayList<Monan> dulieumonan = new ArrayList<>();
    Adapterthucpham adapterthucpham;
    MonanDTO monanDTO;
    String urlmon = "https://dsdiw.000webhostapp.com/getthucan.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_listthucpham);
        binding = ActivityListthucphamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        monanDTO = new MonanDTO();
      //  lvthucpham = findViewById(R.id.listviewthucpham);
        adapterthucpham = new Adapterthucpham(dulieumonan,Listthucpham.this,R.layout.ctthucpham);
        monanDTO.getdulieuthucpham(urlmon,adapterthucpham,dulieumonan,Listthucpham.this);
        binding.listviewthucpham.setAdapter(adapterthucpham);
        binding.listviewthucpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                monanDTO.chuyenman(Listthucpham.this,dulieumonan,position);
            }
        });

    }
}