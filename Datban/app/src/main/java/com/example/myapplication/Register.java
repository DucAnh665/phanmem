package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DAO.KhachhangDAO;

public class Register extends AppCompatActivity {

    EditText ten,tk,mk,sdt;
    Button dangki;
    String urldangky = "https://dsdiw.000webhostapp.com/dangky.php";
    KhachhangDAO khachhangDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        anhxa();
        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }
    public void anhxa()
    {
        ten = findViewById(R.id.txttenkhach);
        tk = findViewById(R.id.txtusername);
        mk = findViewById(R.id.txtpass);
        sdt = findViewById(R.id.txtsdt);
        dangki = findViewById(R.id.Dangky);
        khachhangDAO = new KhachhangDAO();
    }
    public void click()
    {
        String name = ten.getText().toString();
        String user = tk.getText().toString();
        String pass = mk.getText().toString();
        String phone = sdt.getText().toString();
        if (name.equals("")&&user.equals("")&&pass.equals("")&&phone.equals(""))
        {
            Toast.makeText(Register.this,"VUI LÒNG NHẬP ĐỦ THÔNG TIN",Toast.LENGTH_LONG).show();

        }
        else
        {
            khachhangDAO.dangky(name,user,pass,phone,urldangky,Register.this);
        }
    }
}