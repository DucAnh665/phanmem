package com.example.myapplication.DAO;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.DTO.Khachhang;
import com.example.myapplication.MainActivity;
import com.example.myapplication.home;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KhachhangDAO {


    ArrayList<Khachhang> dulieukhach = new ArrayList<>();

    public int dangnhap(String taikhoan, String matkhau, String url, Context context)
    {

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id=0;
                String tenkhach = "";
                String sdt = " ";
              if (response !=null)
              {
                  try
                  {
                      dulieukhach.clear();
                      JSONArray jsonArray = new JSONArray(response);
                      for (int i=0;i<jsonArray.length();i++)
                      {
                         JSONObject object = jsonArray.getJSONObject(i);
                          id = object.getInt("ID");
                          tenkhach = object.getString("Tenkhach");
                          sdt = object.getString("Sdt");
                          dulieukhach.add(new Khachhang(id,tenkhach,taikhoan,matkhau,sdt));
                          Intent intent = new Intent(context, home.class);
                          intent.putExtra("thongtin",  dulieukhach.get(i));
                          context.startActivity(intent);
                      }

                  } catch (JSONException e) {
                      e.printStackTrace();
                  }
              }
              if (response.equals("thatbai"))
              {
                  Toast.makeText(context,"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
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
                param.put("User",taikhoan);
                param.put("Pass",matkhau);
                return param;
            }
        };
        requestQueue.add(stringRequest);

        return 0;
    }


    public int dangky(int id,String name,String tk,String mk,String sdt,String url, Context context)
    {

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("thanhcong"))
                {
                    dulieukhach.add(new Khachhang(id,name,tk,mk,sdt));
                    Toast.makeText(context,"Đăng kí thành công",Toast.LENGTH_LONG).show();
                    context.startActivity(new Intent(context, MainActivity.class));


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
                param.put("Tenkhach",name);
                param.put("User",tk);
                param.put("Pass",mk);
                param.put("Sdt",sdt);
                return param;
            }
        };
        requestQueue.add(stringRequest);

        return 0;
    }


}
