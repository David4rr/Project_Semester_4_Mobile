package com.example.smartlab;

public class DaftarPinjam {

    private String txt_Barang;
    private int img_gambar;

    public DaftarPinjam(String txt_Barang, int img_gambar) {
        this.txt_Barang = txt_Barang;
        this.img_gambar = img_gambar;
    }

    public String getTxt_Barang() {
        return txt_Barang;
    }

    public int getImg_gambar() {
        return img_gambar;
    }
}
