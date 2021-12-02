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
import com.example.myapplication.databinding.ActivityHomeBinding;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class home extends AppCompatActivity {



//    ViewFlipper quangcao;
//    ImageButton imgpre,imgnext;
    Animation in,out;
//    TextView tenkhach,sdt;
//    ListView lvloaiban;
//    RecyclerView monan;
//    DrawerLayout drawerLayout;
//    ListView ban;
    private ActivityHomeBinding binding;

    int id = 0 ;
   public static String ten = " ";
    String sdtkhach = " ";



    LoaiBanDTO loaiBanDTO;
    BanDAO banDAO;
    MonanDTO monanDTO;



    Adapterban daban;
    Adaptermon adaptermon;



    ArrayList<Ban> dulieuban = new ArrayList<>();
     ArrayList<Monan> dulieumon = new ArrayList<>();



    String urllb = "https://dsdiw.000webhostapp.com/getLoaiban.php";
    String urlban = "https://dsdiw.000webhostapp.com/getBan.php";
    String urlmon = "https://dsdiw.000webhostapp.com/getthucan.php";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



       chucnang();
        Quangcao();
        loaiBanDTO = new LoaiBanDTO();
        banDAO = new BanDAO();
        monanDTO = new MonanDTO();
        loaiBanDTO.getdata(urllb,home.this,R.layout.ctloaiban,binding.lvloaiban);
        daban = new Adapterban(home.this,dulieuban,R.layout.custom);


        banDAO.getdata(urlban,dulieuban,daban,home.this);
       binding.ban.setAdapter(daban);



        adaptermon = new Adaptermon(dulieumon,home.this);
       binding.monan.setHasFixedSize(true);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this ,LinearLayoutManager.HORIZONTAL,false);
        binding.monan.setLayoutManager(layoutManager1);
        binding.monan.setAdapter(adaptermon);
        monanDTO.getdulieu(urlmon,adaptermon,dulieumon,home.this);
        nhandulieu();


       binding.imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.quangcao.isAutoStart()){
                    binding.quangcao.stopFlipping();
                    binding.quangcao.showPrevious();
                    binding.quangcao.startFlipping();
                    binding.quangcao.setAutoStart(true);
                }
            }
        });
       binding.imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.quangcao.isAutoStart()){
                   binding.quangcao.stopFlipping();
                    binding.quangcao.showNext();
                    binding.quangcao.startFlipping();
                    binding.quangcao.setAutoStart(true);
                }
            }
        });
    }
    private void Quangcao() {
        in = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        out = AnimationUtils.loadAnimation(this,R.anim.fade_out);
       binding.quangcao.setInAnimation(in);
       binding.quangcao.setInAnimation(out);
       binding.quangcao.setFlipInterval(5000);
       binding.quangcao.setAutoStart(true);

    }

    public void nhandulieu()
    {
        Khachhang khachhang = (Khachhang)getIntent().getSerializableExtra("thongtin");
        id = khachhang.getId();
        ten = khachhang.getTenkhach();
        sdtkhach = khachhang.getSdt();
        binding.tenkhach.setText(ten);
        binding.sdt.setText(sdtkhach);

    }

    public  void chucnang()
    {

       binding.ban.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                banDAO.loadmore(dulieuban,position,home.this);
            }
        });

        binding.lvloaiban.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loaiBanDTO.phanloai(home.this,position,binding.drea);
            }
        });

    }

}