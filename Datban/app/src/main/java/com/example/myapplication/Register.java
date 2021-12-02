package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DAO.KhachhangDAO;
import com.example.myapplication.DTO.Khachhang;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {


    String urldangky = "https://dsdiw.000webhostapp.com/dangky.php";
    private ActivityRegisterBinding binding;
    KhachhangDAO khachhangDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        khachhangDAO = new KhachhangDAO();
       binding.Dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }
//    public void anhxa()
//    {
//        ten = findViewById(R.id.txttenkhach);
//        tk = findViewById(R.id.txtusername);
//        mk = findViewById(R.id.txtpass);
//        sdt = findViewById(R.id.txtsdt);
//        dangki = findViewById(R.id.Dangky);
//
//    }
    public void click()
    {
        int id = 0;
        String name = binding.txttenkhach.getText().toString();
        String user = binding.txtusername.getText().toString();
        String pass = binding.txtpass.getText().toString();
        String phone = binding.txtsdt.getText().toString();

        if (name.equals("")&&user.equals("")&&pass.equals("")&&phone.equals(""))
        {
            Toast.makeText(Register.this,"VUI LÒNG NHẬP ĐỦ THÔNG TIN",Toast.LENGTH_LONG).show();

        }
        else
        {
            khachhangDAO.dangky(id,name,user,pass,phone,urldangky,Register.this);
        }
    }
}