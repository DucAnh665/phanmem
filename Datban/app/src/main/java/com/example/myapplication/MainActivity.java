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
import com.example.myapplication.DTO.THUCDON;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    public static ArrayList<THUCDON> dulieuthucdon;
//    private EditText edttk,edmk;
//    private Button btdangnhap,btdangki;
    private ActivityMainBinding binding;
    KhachhangDAO khachhangDAO;
    String url = "https://dsdiw.000webhostapp.com/login.php";
    String sttk,stmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        khachhangDAO = new KhachhangDAO();
       binding.dangnhap.setOnClickListener(this::onClick);
       binding.dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });

    }
    public void click(String url)
    {
            sttk = binding.tk.getText().toString();
            stmk = binding.mk.getText().toString();
            khachhangDAO.dangnhap(sttk,stmk,url,MainActivity.this);

        if (dulieuthucdon !=null)
        {

        }
        else
        {
            dulieuthucdon = new ArrayList<>();
        }
    }
    public void onClick(View view)
    {
        int id = view.getId();
        if (id == R.id.dangnhap) {

            click(url);
        }

    }

}