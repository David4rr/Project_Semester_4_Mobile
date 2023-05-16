package com.example.smartlab;

public class History {

    private String peminjaman;
    private String tanggal;
    private String total;
    private String hari;

    public History(String peminjaman, String tanggal, String total, String hari){
        this.peminjaman = peminjaman;
        this.tanggal = tanggal;
        this.total = total;
        this.hari = hari;

    }

    public String getPeminjaman() {return peminjaman; }
    public void  setPeminjaman(String peminjaman) {this.peminjaman = peminjaman;}

    public String getTanggal() {return tanggal; }
    public void  setTanggal(String tanggal) {this.tanggal = tanggal;}

    public String getTotal() {return total; }
    public void  setTotal(String total) {  this.total = total;}

    public String getHari() {return hari; }
    public void  setHari(String hari) {this.hari = hari;}

}
