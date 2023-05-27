package com.example.smartlab.Interface;

import com.example.smartlab.DaftarPinjam;

import java.util.ArrayList;

public interface UpdatePinjaman {
    void addItems(String txt_Barang, int img_barang);

        ArrayList<DaftarPinjam> getItems();

}
