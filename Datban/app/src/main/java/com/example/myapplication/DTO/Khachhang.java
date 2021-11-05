package com.example.myapplication.DTO;

import java.io.Serializable;

public class Khachhang implements Serializable {
    int id;
    String Tenkhach, sdt;

    public Khachhang(int id, String tenkhach, String sdt) {
        this.id = id;
        Tenkhach = tenkhach;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkhach() {
        return Tenkhach;
    }

    public void setTenkhach(String tenkhach) {
        Tenkhach = tenkhach;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
