package com.example.smartlab;

public class DataBarang {

    private int dataImg;
    private String namaBarang;
    private String detailBarang;
    private String kategori;
    private String totalBarang;
    private String idBarang2;
    private String deskripsiBarang2;

    public int getDataImg() { return dataImg; }

    public String getNamaBarang() { return namaBarang; }

    public  String getDetailBarang() {return  detailBarang; }

    public String getKategori() { return kategori; }

    public String getTotalBarang() { return totalBarang; }

    public String getIdBarang2() { return idBarang2; }

    public String getDeskripsiBarang2() { return deskripsiBarang2; }

    public DataBarang(int dataImg, String namaBarang, String detailBarang, String kategori, String totalBarang, String idBarang2, String deskripsiBarang2){
        this.dataImg = dataImg;
        this.namaBarang = namaBarang;
        this.detailBarang = detailBarang;
        this.kategori = kategori;
        this.totalBarang = totalBarang;
        this.idBarang2 = idBarang2;
        this.deskripsiBarang2 = deskripsiBarang2;
    }

}
