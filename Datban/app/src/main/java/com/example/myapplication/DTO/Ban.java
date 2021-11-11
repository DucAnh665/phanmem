package com.example.myapplication.DTO;

import java.io.Serializable;

public class Ban implements Serializable {
    int id;
    String hinhanh;
    int soban;
    int idloaiban;
    String mota;

    public Ban(int id, String hinhanh, int soban, int idloaiban, String mota) {
        this.id = id;
        this.hinhanh = hinhanh;
        this.soban = soban;
        this.idloaiban = idloaiban;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoban() {
        return soban;
    }

    public void setSoban(int soban) {
        this.soban = soban;
    }

    public int getIdloaiban() {
        return idloaiban;
    }

    public void setIdloaiban(int idloaiban) {
        this.idloaiban = idloaiban;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
