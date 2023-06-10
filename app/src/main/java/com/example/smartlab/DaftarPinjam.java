package com.example.smartlab;

public class DaftarPinjam {

    private String txt_Barang;
    private String txt_Jumlah;

    public DaftarPinjam(String txt_Barang, String txt_Jumlah) {
        this.txt_Barang = txt_Barang;
        this.txt_Jumlah = txt_Jumlah;
//        this.img_gambar = img_gambar;
    }

    public String getTxt_Jumlah() {
        return txt_Jumlah;
    }

    public String getTxt_Barang() {
        return txt_Barang;
    }

}
