package com.example.dk;

import android.text.TextUtils;
import android.util.Patterns;

public class Model {

        private String email;
        private String pass;
        private  String name;
        private String phone;

    public Model(String email, String pass, String name, String phone) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public  boolean checkEmail(){
            return !TextUtils.isEmpty(email)&& Patterns.EMAIL_ADDRESS.matcher(email).matches();

        }
        public boolean checkPass(){
            return !TextUtils.isEmpty(pass)&& pass.length()>=6;
        }
    }


