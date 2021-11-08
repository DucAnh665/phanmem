package com.example.myapplication.DAO;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.Adaptermon;
import com.example.myapplication.DTO.Monan;

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
}
