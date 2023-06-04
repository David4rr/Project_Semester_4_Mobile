package com.example.smartlab.Interface;

import com.example.smartlab.DaftarPinjam;

import java.util.ArrayList;

public interface UpdatePinjaman {
    void addItems(String txt_Barang, String txt_Jumlah);

        ArrayList<DaftarPinjam> getItems();

}
