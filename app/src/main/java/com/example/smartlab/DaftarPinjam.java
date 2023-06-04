package com.example.smartlab;

public class DaftarPinjam {

    private String txt_Barang, txt_jumlah;

    public DaftarPinjam(String txt_Barang, String txt_jumlah) {
        this.txt_Barang = txt_Barang;
        this.txt_jumlah = txt_jumlah;
//        this.img_gambar = img_gambar;
    }

    public String getTxt_jumlah() {
        return txt_jumlah;
    }

    public String getTxt_Barang() {
        return txt_Barang;
    }

//    public int getImg_gambar() {
//        return img_gambar;
//    }
}
