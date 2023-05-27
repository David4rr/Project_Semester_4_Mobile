package com.example.smartlab;

import android.app.Application;
import android.content.Context;

import com.example.smartlab.Interface.UpdatePinjaman;

import java.util.ArrayList;

public class PeminjamanMain extends Application implements UpdatePinjaman {

    private static Context context;
    ArrayList<DaftarPinjam> daftarPinjam;

    @Override
    public void onCreate() {
        super.onCreate();
        context  = getApplicationContext();
        daftarPinjam = new ArrayList<>();
    }

    public static Context getMyContext(){
        return context;
    }

    @Override
    public void addItems(String txt_Barang, int img_barang) {
        daftarPinjam.add(new DaftarPinjam(txt_Barang, img_barang));
    }

    @Override
    public ArrayList<DaftarPinjam> getItems() {
        return null;
    }

}
