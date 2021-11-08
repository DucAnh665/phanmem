package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.DAO.KhachhangDAO;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText edttk,edmk;
    private Button btdangnhap,btdangki;
    KhachhangDAO khachhangDAO;
    String url = "https://dsdiw.000webhostapp.com/login.php";
    String sttk,stmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edttk = findViewById(R.id.tk);
        edmk = findViewById(R.id.mk);
        btdangnhap = findViewById(R.id.dangnhap);
        btdangki = findViewById(R.id.dangki);
        khachhangDAO = new KhachhangDAO();
        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(url);
            }
        });
        btdangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });

    }
    public void click(String url)
    {
            sttk = edttk.getText().toString();
            stmk = edmk.getText().toString();
            khachhangDAO.dangnhap(sttk,stmk,url,MainActivity.this);
    }

}