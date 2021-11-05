package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.DAO.BanDAO;
import com.example.myapplication.DAO.LoaiBanDTO;
import com.example.myapplication.DTO.Khachhang;

public class home extends AppCompatActivity {

    TextView tenkhach,sdt;
    ListView lvloaiban,ban;
    int id = 0;
    String ten = " ";
    String sdtkhach = " ";
    LoaiBanDTO loaiBanDTO;
    BanDAO banDAO;
    String urllb = "https://dsdiw.000webhostapp.com/getLoaiban.php";
    String urlban = "https://dsdiw.000webhostapp.com/getBan.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        anhxa();
        nhandulieu();
        loaiBanDTO = new LoaiBanDTO();
        banDAO = new BanDAO();
        loaiBanDTO.getdata(urllb,home.this,R.layout.ctloaiban,lvloaiban);
        banDAO.getData(urlban,home.this,R.layout.custom,ban);

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
        ban = findViewById(R.id.ban);
    }
}