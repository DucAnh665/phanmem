package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.example.myapplication.DTO.THUCDON;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class home extends AppCompatActivity {



    ViewFlipper quangcao;
    ImageButton imgpre,imgnext;
    Animation in,out;
    TextView tenkhach,sdt;
    ListView lvloaiban;
    RecyclerView monan;
    DrawerLayout drawerLayout;
    ListView ban;
    int id = 0 ;
   public static String ten = " ";
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
        Quangcao();
        loaiBanDTO = new LoaiBanDTO();
        banDAO = new BanDAO();
        monanDTO = new MonanDTO();
        loaiBanDTO.getdata(urllb,home.this,R.layout.ctloaiban,lvloaiban);
        daban = new Adapterban(home.this,dulieuban,R.layout.custom);
        banDAO.getdata(urlban,dulieuban,daban,home.this);
        ban.setAdapter(daban);
        adaptermon = new Adaptermon(dulieumon,home.this);
        monan.setHasFixedSize(true);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this ,LinearLayoutManager.HORIZONTAL,false);
        monan.setLayoutManager(layoutManager1);
        monan.setAdapter(adaptermon);
        monanDTO.getdulieu(urlmon,adaptermon,dulieumon,home.this);
        nhandulieu();


        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quangcao.isAutoStart()){
                    quangcao.stopFlipping();
                    quangcao.showPrevious();
                    quangcao.startFlipping();
                    quangcao.setAutoStart(true);
                }
            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quangcao.isAutoStart()){
                    quangcao.stopFlipping();
                    quangcao.showNext();
                    quangcao.startFlipping();
                    quangcao.setAutoStart(true);
                }
            }
        });
    }
    private void Quangcao() {
        in = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        out = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        quangcao.setInAnimation(in);
        quangcao.setInAnimation(out);
        quangcao.setFlipInterval(5000);
        quangcao.setAutoStart(true);

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
        quangcao = findViewById(R.id.quangcao);
        imgnext = findViewById(R.id.imgnext);
        imgpre = findViewById(R.id.imgpre);
        tenkhach = findViewById(R.id.tenkhach);
        sdt = findViewById(R.id.sdt);
        lvloaiban = findViewById(R.id.lvloaiban);
        ban = (ListView) findViewById(R.id.ban);
        monan = (RecyclerView) findViewById(R.id.monan);
        ban.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                banDAO.loadmore(dulieuban,position,home.this);
            }
        });
        drawerLayout = findViewById(R.id.drea);
        lvloaiban.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loaiBanDTO.phanloai(home.this,position,drawerLayout);
            }
        });

    }

}