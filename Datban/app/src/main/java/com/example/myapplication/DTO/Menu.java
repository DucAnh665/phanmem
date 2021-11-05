package com.example.myapplication.DTO;

public class Menu {


    int idban;
    String tenloaiban;
    String hinhanh;

    public Menu(int idban, String tenloaiban, String hinhanh) {
        this.idban = idban;
        this.tenloaiban = tenloaiban;
        this.hinhanh = hinhanh;
    }

    public int getIdban() {
        return idban;
    }

    public void setIdban(int idban) {
        this.idban = idban;
    }

    public String getTenloaiban() {
        return tenloaiban;
    }

    public void setTenloaiban(String tenloaiban) {
        this.tenloaiban = tenloaiban;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
