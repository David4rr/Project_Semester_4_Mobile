package com.example.smartlab;

public class DataBarang2 {

    private int dataimg;
    private String namaBarang;
    private String detailBarang;
    private String kategori;
    private String totalBarang;
    private String idBarang;
    private String deskripsiBarang;

    public int getDataimg() { return dataimg; }

    public String getNamaBarang() { return namaBarang; }

    public String getDetailBarang() { return detailBarang; }

    public String getKategori() { return kategori; }

    public String getTotalBarang() { return totalBarang; }

    public String getIdBarang() { return idBarang; }

    public String getDeskripsiBarang() { return deskripsiBarang; }

    public DataBarang2(int dataimg, String namaBarang, String detailBarang, String kategori, String totalBarang, String idBarang, String deskripsiBarang){
        this.dataimg = dataimg;
        this.namaBarang = namaBarang;
        this.detailBarang = detailBarang;
        this.kategori = kategori;
        this.totalBarang = totalBarang;
        this.idBarang = idBarang;
        this.detailBarang = detailBarang;
    }
}
