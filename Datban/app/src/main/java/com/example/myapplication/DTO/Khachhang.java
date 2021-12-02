package com.example.myapplication.DTO;

import java.io.Serializable;

public class Khachhang implements Serializable {
    int id;
    String tenkhach,taikhoan,matkhau,sdt;

    public Khachhang(int id, String tenkhach, String taikhoan, String matkhau, String sdt) {
        this.id = id;
        this.tenkhach = tenkhach;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkhach() {
        return tenkhach;
    }

    public void setTenkhach(String tenkhach) {
        this.tenkhach = tenkhach;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
