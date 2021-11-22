package com.example.myapplication;

import static com.example.myapplication.home.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.DAO.ChitietbanDAO;
import com.example.myapplication.DAO.ThucdonDAO;
import com.example.myapplication.DTO.Ban;
import com.example.myapplication.DTO.THUCDON;
import com.example.myapplication.databinding.ActivityChitietbanBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Chitietban extends AppCompatActivity {
    int id = 0;
    int Idloaiban = 0;
   public static int soban1;

    private ActivityChitietbanBinding binding;
    ChitietbanDAO chitietbanDAO = new ChitietbanDAO() ;
    ThucdonDAO thucdonDAO = new ThucdonDAO();
    String url = "https://dsdiw.000webhostapp.com/thongtin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChitietbanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttondatmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chitietbanDAO.chuyenman(Chitietban.this);
            }
        });
        nhan();
        datban();
    }
    public  void nhan()
    {
        Ban ban = (Ban) getIntent().getSerializableExtra("thongtin");
        id = ban.getId();
        Idloaiban = ban.getIdloaiban();
        soban1 = ban.getSoban();
        if (Idloaiban == 1) {
            binding.chitietloaiban.setText("Bàn 4 người");
        }
        if (Idloaiban == 2)
        {
            binding.chitietloaiban.setText("Bàn 2 người");
        }
        if (Idloaiban == 3)
        {
            binding.chitietloaiban.setText("Bàn 6 người");
        }
        binding.chitietsoban.setText(String.valueOf(soban1));


    }
    public  void datban()
    {
        binding.buttondatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Chitietban.this);
                dialog.setTitle("Nhập thông tin");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.ctchitiethoadon);
                EditText thoigian = (EditText) dialog.findViewById(R.id.thoigian);
                Button dat = (Button) dialog.findViewById(R.id.dat);
                dat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String time = thoigian.getText().toString().trim();
                        thucdonDAO.themhoadon(url,Chitietban.this,time);
                        MainActivity.dulieuthucdon.add(new THUCDON(id,"Chưa đặt","Chưa có",0,0,soban1, ten));
                        dialog.cancel();
                    }
                });
                ImageButton xoa = (ImageButton) dialog.findViewById(R.id.xoa);
                xoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();

            }
        });
    }
}