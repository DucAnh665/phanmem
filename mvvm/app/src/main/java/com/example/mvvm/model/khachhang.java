package com.example.mvvm.model;

public class khachhang {
    private  String id,email,pass,phone,name;

    public khachhang(String id, String email, String pass, String phone, String name) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
