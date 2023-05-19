package com.example.smartlab;

public class History2 {

    private String peminjaman;
    private String tanggal;
    private String total;
    private String hari;
    private int img;

    public String getPeminjaman() {
        return peminjaman;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getTotal() {
        return total;
    }

    public String getHari() {
        return hari;
    }

    public int getImg() {
        return img;
    }

    public History2(String peminjaman, String tanggal, String total, String hari, int img) {
        this.peminjaman = peminjaman;
        this.tanggal = tanggal;
        this.total = total;
        this.hari = hari;
        this.img = img;
    }

}
