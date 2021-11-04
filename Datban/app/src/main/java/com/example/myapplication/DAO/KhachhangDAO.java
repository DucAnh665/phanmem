package com.example.myapplication.DAO;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class KhachhangDAO {


    public int dangnhap(String taikhoan, String matkhau, String url, Context context)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("thanhcong"))
                {
                    Toast.makeText(context,"Đăng nhập thành công",Toast.LENGTH_LONG).show();

                }
                else if(response.equals("thatbai"))
                {
                    Toast.makeText(context,"đăng nhập thất bại",Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("Taikhoan",taikhoan);
                param.put("gmail",matkhau);
                return param;
            }
        };
        requestQueue.add(stringRequest);

        return 0;
    }


}
