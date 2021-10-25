package com.example.mvvm.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.mvvm.BR;
import com.example.mvvm.model.khachhang;
import com.example.mvvm.view.login;

import java.util.ArrayList;

public class viewmodellogin extends BaseObservable {
    private  String email;
    private  String pasword;
    khachhang list =null;
    callback call;
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
    @Bindable

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
        notifyPropertyChanged(BR.pasword);
    }
    public void onlick()
    {

        String tk = "ducanh01";
        String mk = "1";
        if (list.getEmail().equals(tk)&&list.getPass().equals(mk))
        {
                call.thanhcong("thành công");
        }
        else
        {
            call.thatbai("thất bại");

        }


    }




}
