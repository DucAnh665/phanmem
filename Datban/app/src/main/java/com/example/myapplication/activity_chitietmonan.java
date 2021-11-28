package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.Adapterthucpham;
import com.example.myapplication.DAO.MonanDTO;
import com.example.myapplication.DTO.Khachhang;
import com.example.myapplication.DTO.Monan;
import com.example.myapplication.DTO.THUCDON;
import com.example.myapplication.databinding.ActivityBan6Binding;
import com.example.myapplication.databinding.ActivityChitietmonanBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class activity_chitietmonan extends AppCompatActivity {

//    TextView tenmonan,gia,chatluong;
//    ImageView anhmon;
//    Spinner soluong;
//    ImageButton datmon;

    private ActivityChitietmonanBinding binding;

    String tenmon = " ";
    int id = 0;
    int chatluong1 = 0;
    String hinhanh = " ";
    MonanDTO monanDTO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChitietmonanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        anhxa();
        nhandulieu();
        monanDTO = new MonanDTO();
        monanDTO.ex(activity_chitietmonan.this,binding.spiner);

    }
    public void anhxa()
    {

        binding.buttondatmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.dulieuthucdon.size()>0)
                {
                    int s1 = Integer.parseInt(binding.spiner.getSelectedItem().toString());
                    boolean ex = false;
                    for (int i=0;i<MainActivity.dulieuthucdon.size();i++)
                    {
                        if (MainActivity.dulieuthucdon.get(i).getId() == id)
                        {
                            MainActivity.dulieuthucdon.get(i).setSoluongsp(MainActivity.dulieuthucdon.get(i).getSoluongsp()+s1);
                            if (MainActivity.dulieuthucdon.get(i).getSoluongsp()>=10)
                            {
                                MainActivity.dulieuthucdon.get(i).setSoluongsp(10);
                            }
                            MainActivity.dulieuthucdon.get(i).setGiasp(chatluong1*MainActivity.dulieuthucdon.get(i).getGiasp());
                            ex = true;
                        }
                    }
                    if (ex==false)
                    {
                        int soluongnew = Integer.parseInt(binding.spiner.getSelectedItem().toString());
                        long gianew = soluongnew*chatluong1;
                        MainActivity.dulieuthucdon.add(new THUCDON(id,tenmon,hinhanh,gianew,soluongnew,Chitietban.soban1,home.ten));
                    }
                }
                else
                {
                    int soluongnew = Integer.parseInt(binding.spiner.getSelectedItem().toString());
                    long gianew = soluongnew*chatluong1;
                    MainActivity.dulieuthucdon.add(new THUCDON(id,tenmon,hinhanh,gianew,soluongnew,Chitietban.soban1,home.ten));
                }

                Intent intent = new Intent(activity_chitietmonan.this, Thucdon.class);
                Toast.makeText(activity_chitietmonan.this,tenmon+"\t"+Chitietban.soban1+"\t"+home.ten,Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });


    }
    public void nhandulieu()
    {
        Monan monan = (Monan)getIntent().getSerializableExtra("thongtinmon") ;
        id = monan.getID();
        hinhanh = monan.getHinhanh();
        Picasso.get().load(hinhanh).into(binding.imagechitietmon);
        chatluong1 = monan.getGia();
        tenmon = monan.getTenmon();
        binding.tenmon1.setText(tenmon);
        binding.giatien.setText(String.valueOf(chatluong1));
        if (chatluong1>=1000000)
        {
            binding.chatluong.setText("Loại 1");
        }
        else
        {
            binding.chatluong.setText("Loại 2");
        }


    }


}