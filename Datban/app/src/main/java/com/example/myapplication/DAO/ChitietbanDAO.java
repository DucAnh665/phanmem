package com.example.myapplication.DAO;

import android.content.Context;
import android.content.Intent;

import com.example.myapplication.DTO.Ban;
import com.example.myapplication.Listthucpham;

public class ChitietbanDAO {


    public void chuyenman(Context context)
    {
        context.startActivity(new Intent(context, Listthucpham.class));
    }




}
