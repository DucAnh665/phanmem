package com.example.myapplication.DTO;

import java.io.Serializable;

public class Monan implements Serializable {
    int ID;
    String hinhanh;
    String tenmon;
    String mota;
    int gia;


    public Monan(int ID, String hinhanh, String tenmon, String mota, int gia) {
        this.ID = ID;
        this.hinhanh = hinhanh;
        this.tenmon = tenmon;
        this.mota = mota;
        this.gia = gia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
