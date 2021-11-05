package com.example.myapplication.DAO;

import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.Adapterban;
import com.example.myapplication.DTO.Ban;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BanDAO {
    ArrayList<Ban> mangban = new ArrayList<>();
    public void getData(String url, Context context, int layout, ListView lv){
        Adapterban adapterban = new Adapterban(context,layout,mangban);
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                mangban.clear();
                for (int i=0;i<response.length();i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        mangban.add(new Ban(
                          jsonObject.getInt("ID"),
                                jsonObject.getString("Hinhanh"),
                                jsonObject.getInt("Soban"),
                                jsonObject.getInt("IDsanpham"),
                                jsonObject.getString("Mota")));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapterban.notifyDataSetChanged();
                lv.setAdapter(adapterban);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"erro",Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(jsonArrayRequest);

        }
    }

