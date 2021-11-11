package com.example.myapplication.DAO;

import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.Adaptermon;
import com.example.myapplication.Adapter.Adapterthucpham;
import com.example.myapplication.DTO.Monan;
import com.example.myapplication.DTO.THUCDON;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Thucdon;
import com.example.myapplication.activity_chitietmonan;
import com.example.myapplication.home;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MonanDTO {
    public  void getdulieu(String url, Adaptermon adaptermon, ArrayList<Monan> dulieumonan, Context context)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                dulieumonan.clear();
                for (int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        dulieumonan.add(new Monan(
                            object.getInt("ID"),
                                object.getString("Hinhanh"),
                                object.getString("Tenmon"),
                                object.getString("Mota"),
                                object.getInt("Gia")

                        ));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adaptermon.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    public  void getdulieuthucpham(String url, Adapterthucpham adaptermon, ArrayList<Monan> dulieumonan, Context context)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                dulieumonan.clear();
                for (int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        dulieumonan.add(new Monan(
                                object.getInt("ID"),
                                object.getString("Hinhanh"),
                                object.getString("Tenmon"),
                                object.getString("Mota"),
                                object.getInt("Gia")

                        ));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adaptermon.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    public  void chuyenman(Context context, ArrayList<Monan> monan,int i)
    {
        Intent intent1 = new Intent(context, activity_chitietmonan.class);
        intent1.putExtra("thongtinmon" ,monan.get(i));
        context.startActivity(intent1);

    }
    public void ex(Context context, Spinner soluong)
    {
        Integer [] soluongsanpham = new Integer[] {1,2,3,4,5,6,7,8,10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item,soluongsanpham);
        soluong.setAdapter(arrayAdapter);
    }


}
