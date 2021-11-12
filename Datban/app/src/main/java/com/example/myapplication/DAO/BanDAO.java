package com.example.myapplication.DAO;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.Adapterban;
import com.example.myapplication.Chitietban;
import com.example.myapplication.DTO.Ban;
import com.example.myapplication.home;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BanDAO {

    public void getdata(String url,ArrayList<Ban> dulieuban,Adapterban daban,Context context)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                dulieuban.clear();
                for (int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        dulieuban.add(new Ban(
                                object.getInt("ID"),
                                object.getString("Hinhanh"),
                                object.getInt("Soban"),
                                object.getInt("IDloaiban"),
                                object.getString("Mota")
                        ));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                daban.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"lỗi",Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    public void loadmore(ArrayList<Ban> dulieuban,int i,Context context)
    {
        Intent intent = new Intent(context, Chitietban.class);
        intent.putExtra("thongtin",dulieuban.get(i));
        context.startActivity(intent);
    }
    }



