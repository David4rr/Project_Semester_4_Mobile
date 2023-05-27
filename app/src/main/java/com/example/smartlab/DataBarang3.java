package com.example.smartlab;

public class DataBarang3 {

    private String peminjaman;
    private String tanggal;
    private String total;
    private String status;
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

    public String getStatus() {
        return status;
    }

    public int getImg() {
        return img;
    }

    public DataBarang3(String peminjaman, String tanggal, String total, String status, int img) {
        this.peminjaman = peminjaman;
        this.tanggal = tanggal;
        this.total = total;
        this.status = status;
        this.img = img;
    }
}
