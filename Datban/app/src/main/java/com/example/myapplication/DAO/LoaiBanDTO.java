package com.example.myapplication.DAO;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import android.widget.Toast;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.AdapterLB;
import com.example.myapplication.DTO.Menu;
import com.example.myapplication.ban2;
import com.example.myapplication.ban4;
import com.example.myapplication.ban6;
import com.example.myapplication.gioithieu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoaiBanDTO {
    ArrayList<Menu> dulieumenu = new ArrayList<>();
    public void getdata(String url, Context context, int layout, ListView lv)
    {
        AdapterLB dalb = new AdapterLB(context,layout,dulieumenu);
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                dulieumenu.clear();
                for (int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        dulieumenu.add(new Menu(
                                object.getInt("ID"),
                                object.getString("Loaiban"),
                                object.getString("Hinhanh")
                        ));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                dulieumenu.add(0,new Menu(0,"Giới Thiệu","https://cdn-icons.flaticon.com/png/512/1865/premiu…=1636721189~hmac=743050aabbfa44397664fe8277031532"));
                dalb.notifyDataSetChanged();
                lv.setAdapter(dalb);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"lỗi",Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    public void phanloai(Context context, int i, DrawerLayout drawerLayout)
    {
        switch (i)
        {
            case 0:
                context.startActivity(new Intent(context, gioithieu.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case 1:
                context.startActivity(new Intent(context, ban4.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case 2:
                context.startActivity(new Intent(context, ban2.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case 3:
                context.startActivity(new Intent(context, ban6.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

        }
    }


}
