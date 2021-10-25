package com.example.dk;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class Dk extends  BaseObservable{

        private  String email;
        private  String pass;
        private  String name;
        private  String phone;
        public ObservableField<String> mess=new ObservableField<>();
        @Bindable
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
            notifyPropertyChanged(BR.email);
        }

        @Bindable
        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
            notifyPropertyChanged(BR.pass);
        }

        @Bindable
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
            notifyPropertyChanged(BR.name);
        }

        @Bindable
        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
            notifyPropertyChanged(BR.phone);
        }

        public void  onClickRegister(){
            Model model=new Model(getEmail(),getPass(),getName(),getPhone());
            if (model.checkEmail() && model.checkPass()){
                mess.set("Đăng ký thành công");
            }else {
                mess.set("Mời nhập lại thông tin");
            }
        }
    }

