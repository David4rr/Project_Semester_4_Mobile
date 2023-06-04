package com.example.smartlab;

import android.app.Application;
import android.content.Context;

import com.example.smartlab.Interface.UpdatePinjaman;

import java.util.ArrayList;

public class PeminjamanMain extends Application implements UpdatePinjaman {

    private static Context context;
    ArrayList<DaftarPinjam> daftarPinjams;

    @Override
    public void onCreate() {
        super.onCreate();
        context  = getApplicationContext();
        daftarPinjams = new ArrayList<>();
    }

    public static Context getMyContext(){
        return context;
    }

    @Override
    public void addItems(String txt_Barang, String txt_Jumlah) {
        daftarPinjams.add(new DaftarPinjam(txt_Barang, txt_Jumlah));
    }

    @Override
    public ArrayList<DaftarPinjam> getItems() {
        return daftarPinjams;
    }

}
