package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.Adapterban;
import com.example.myapplication.Adapter.Adaptermon;
import com.example.myapplication.DAO.BanDAO;
import com.example.myapplication.DAO.LoaiBanDTO;
import com.example.myapplication.DAO.MonanDTO;
import com.example.myapplication.DTO.Ban;
import com.example.myapplication.DTO.Khachhang;
import com.example.myapplication.DTO.Menu;
import com.example.myapplication.DTO.Monan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    TextView tenkhach,sdt;
    ListView lvloaiban;
    RecyclerView ban,monan;
    int id = 0;
    String ten = " ";
    String sdtkhach = " ";
    LoaiBanDTO loaiBanDTO;
    BanDAO banDAO;
    MonanDTO monanDTO;
    Adapterban daban;
    ArrayList<Ban> dulieuban = new ArrayList<>();
    ArrayList<Monan> dulieumon = new ArrayList<>();
    Adaptermon adaptermon;
    String urllb = "https://dsdiw.000webhostapp.com/getLoaiban.php";
    String urlban = "https://dsdiw.000webhostapp.com/getBan.php";
    String urlmon = "https://dsdiw.000webhostapp.com/getthucan.php";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        anhxa();
        nhandulieu();
        loaiBanDTO = new LoaiBanDTO();
        banDAO = new BanDAO();
        monanDTO = new MonanDTO();
        loaiBanDTO.getdata(urllb,home.this,R.layout.ctloaiban,lvloaiban);
        daban = new Adapterban(dulieuban,home.this);
        adaptermon = new Adaptermon(dulieumon,home.this);
        ban.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        ban.setLayoutManager(layoutManager);
        banDAO.getdata(urlban,dulieuban,daban,home.this);
        ban.setAdapter(daban);

        monan.setHasFixedSize(true);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this ,LinearLayoutManager.HORIZONTAL,false);
        monan.setLayoutManager(layoutManager1);
        monanDTO.getdulieu(urlmon,adaptermon,dulieumon,home.this);
        monan.setAdapter(adaptermon);

    }
    public void nhandulieu()
    {
        Khachhang khachhang = (Khachhang)getIntent().getSerializableExtra("thongtin");
        id = khachhang.getId();
        ten = khachhang.getTenkhach();
        sdtkhach = khachhang.getSdt();
        tenkhach.setText(ten);
        sdt.setText(sdtkhach);

    }

    public  void anhxa()
    {
        tenkhach = findViewById(R.id.tenkhach);
        sdt = findViewById(R.id.sdt);
        lvloaiban = findViewById(R.id.lvloaiban);
        ban = (RecyclerView)findViewById(R.id.ban);
        monan = (RecyclerView) findViewById(R.id.monan);
    }
}