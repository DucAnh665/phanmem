package com.example.myapplication.DAO;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.AdapterThucdon;
import com.example.myapplication.Listthucpham;
import com.example.myapplication.MainActivity;
import com.example.myapplication.MainActivity2;
import com.example.myapplication.home;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ThucdonDAO {
    public void checkdata(AdapterThucdon adapterThucdon, TextView thongbao, ListView lv)
    {
        if (MainActivity.dulieuthucdon.size()<=0)
        {
            adapterThucdon.notifyDataSetChanged();
            thongbao.setVisibility(View.VISIBLE);
            lv.setVisibility(View.INVISIBLE);
        }
        else
        {
            adapterThucdon.notifyDataSetChanged();;
            thongbao.setVisibility(View.INVISIBLE);
            lv.setVisibility(View.VISIBLE);
        }
    }
    public static void even(TextView giatri)
    {
        long tongtien = 0;
        for (int i=0;i<MainActivity.dulieuthucdon.size();i++)
        {
            tongtien +=MainActivity.dulieuthucdon.get(i).getGiasp();
        }
        giatri.setText(tongtien+"Đ");
    }
    public  void delete(Context context,TextView thongbao,int i,AdapterThucdon dathucdon,TextView giatri)
    {
        AlertDialog.Builder a = new AlertDialog.Builder(context);
        a.setTitle("Xác nhận xóa sản phẩm");
        a.setMessage("Bạn có chắc muốn xóa sản phẩm");
        a.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (MainActivity.dulieuthucdon.size()<=0)
                {
                    thongbao.setVisibility(View.VISIBLE);
                }
                else {
                    MainActivity.dulieuthucdon.remove(i);
                    dathucdon.notifyDataSetChanged();
                    even(giatri);
                    if (MainActivity.dulieuthucdon.size()<=0)
                    {
                        thongbao.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        thongbao.setVisibility(View.INVISIBLE);
                        dathucdon.notifyDataSetChanged();
                        even(giatri);
                    }

                }

            }
        });
        a.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dathucdon.notifyDataSetChanged();
                even(giatri);
            }
        });
        a.show();
    }

    public void themhoadon(String url,Context context,String time)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1")) {
                    MainActivity.dulieuthucdon.clear();
                    Toast.makeText(context,"Đặt thông tin thành công",Toast.LENGTH_LONG).show();
                    context.startActivity(new Intent(context, Listthucpham.class));
                }
                else if (response.equals("0"))
                {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                JSONArray jsonArray = new JSONArray();
                for (int i=0;i<MainActivity.dulieuthucdon.size();i++)
                {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("IDkhach",MainActivity.dulieuthucdon.get(i).getIdkhach());
                        jsonObject.put("Soban",MainActivity.dulieuthucdon.get(i).getSoban());
                        jsonObject.put("Tenmon",MainActivity.dulieuthucdon.get(i).getTensanpham());
                        jsonObject.put("Gia",MainActivity.dulieuthucdon.get(i).getGiasp());
                        jsonObject.put("Soluong",MainActivity.dulieuthucdon.get(i).getSoluongsp());
                        jsonObject.put("Thoigian",time);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                }
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("json",jsonArray.toString());
                return hashMap;
            }
        };
        requestQueue.add(request);
    }
    public void trangchu(Context context)
    {
      context.startActivity(new Intent(context, MainActivity2.class));
    }
}
