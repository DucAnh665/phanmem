package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Adapter.AdapterThucdon;
import com.example.myapplication.DAO.ThucdonDAO;
import com.example.myapplication.DTO.THUCDON;
import com.example.myapplication.databinding.ActivityThucdonBinding;

import java.util.ArrayList;

public class Thucdon extends AppCompatActivity {

//    ListView listThucdon;
    AdapterThucdon dathucdon;
//    TextView thucdon;

    private ActivityThucdonBinding binding;
    public static TextView Giatri;
    Button datmon,trangchu;
   public static ThucdonDAO thucdonDAO = new ThucdonDAO();
   String  url = "https://dsdiw.000webhostapp.com/thongtin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThucdonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        anhxa();
        dathucdon = new AdapterThucdon(MainActivity.dulieuthucdon,Thucdon.this,R.layout.ctthucdon);
        binding.lvthucdon.setAdapter(dathucdon);

        thucdonDAO.checkdata(dathucdon,binding.textthucdon,binding.lvthucdon);
        nhangia();

    }
    public void anhxa()
    {

        Giatri = findViewById(R.id.giatri);
        datmon = findViewById(R.id.btndatmon);
        trangchu = findViewById(R.id.btnTrangchu);
        binding.lvthucdon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                thucdonDAO.delete(Thucdon.this,binding.textthucdon,position,dathucdon,Giatri);
                return true;
            }
        });
        datmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Thucdon.this);
                dialog.setTitle("Nhập thông tin");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.ctchitiethoadon);
                EditText thoigian = (EditText) dialog.findViewById(R.id.thoigian);
                Button dat = (Button) dialog.findViewById(R.id.dat);
                dat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String time = thoigian.getText().toString().trim();
                        thucdonDAO.themhoadon(url,Thucdon.this,time);
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
        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thucdonDAO.trangchu(Thucdon.this);
            }
        });


    }
    public static void  nhangia()
    {
        thucdonDAO.even(Giatri);
    }

}