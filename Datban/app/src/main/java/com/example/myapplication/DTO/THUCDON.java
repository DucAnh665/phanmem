package com.example.myapplication.DTO;

public class THUCDON {
    int id;
    String tensanpham,hinhanh;
    long giasp;
    int  soluongsp;
    int Soban;
    String idkhach;

    public THUCDON(int id, String tensanpham, String hinhanh, long giasp, int soluongsp, int soban, String idkhach) {
        this.id = id;
        this.tensanpham = tensanpham;
        this.hinhanh = hinhanh;
        this.giasp = giasp;
        this.soluongsp = soluongsp;
        Soban = soban;
        this.idkhach = idkhach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public long getGiasp() {
        return giasp;
    }

    public void setGiasp(long giasp) {
        this.giasp = giasp;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }

    public int getSoban() {
        return Soban;
    }

    public void setSoban(int soban) {
        Soban = soban;
    }

    public String getIdkhach() {
        return idkhach;
    }

    public void setIdkhach(String idkhach) {
        this.idkhach = idkhach;
    }
}
