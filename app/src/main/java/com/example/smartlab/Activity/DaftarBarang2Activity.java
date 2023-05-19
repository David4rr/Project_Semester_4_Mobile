package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.smartlab.Adapter.Barang2Adapter;
import com.example.smartlab.DataBarang2;
import com.example.smartlab.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaftarBarang2Activity extends AppCompatActivity {

    // Variabel ini adalah objek RecyclerView yang digunakan untuk menampilkan daftar item.
    RecyclerView recyclerView;

    // Variabel ini adalah List yang berisi objek DataBarang2.
    List<DataBarang2> dataBarang2List;

    // Variabel ini adalah objek dari kelas Barang2Adapter.
    Barang2Adapter adapter;

    // Variabel ini adalah objek DataBarang2 yang digunakan untuk menyimpan data barang individu.
    DataBarang2 dataBarang2;

    // Variabel ini adalah objek SearchView yang digunakan untuk menyediakan fungsi pencarian dalam RecyclerView.
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_barang2);

        // Baris ini menginisialisasi objek
        recyclerView = findViewById(R.id.recyclerviewHistory3);
        searchView = findViewById(R.id.search2);

        // Kode di dibawah adalah implementasi penggunaan objek searchView
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList2(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(DaftarBarang2Activity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataBarang2List = new ArrayList<>();

        dataBarang2 = new DataBarang2(R.drawable.background_profile, "Arduino Uno", "24 Pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang2List.add(dataBarang2);

        dataBarang2 = new DataBarang2(R.drawable.background_profile, "Lil Uno", "24 Pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang2List.add(dataBarang2);

        dataBarang2 = new DataBarang2(R.drawable.background_profile, "Uno Uno", "24 Pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang2List.add(dataBarang2);

        dataBarang2 = new DataBarang2(R.drawable.background_profile, "Arduino2 Uno", "24 Pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang2List.add(dataBarang2);

        dataBarang2 = new DataBarang2(R.drawable.background_profile, "Camero Uno", "24 Pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang2List.add(dataBarang2);

        dataBarang2 = new DataBarang2(R.drawable.background_profile, "Sure Uno", "24 Pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang2List.add(dataBarang2);

        adapter = new Barang2Adapter(DaftarBarang2Activity.this, dataBarang2List);
        recyclerView.setAdapter(adapter);

    }

    private void searchList2(String text){
        List<DataBarang2> dataSearchList = new ArrayList<>();
        for (DataBarang2 data : dataBarang2List){
            if (data.getNamaBarang().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(this, "Data Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList2(dataSearchList);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DaftarBarang2Activity.this, PinjamBarangActivity.class);
        startActivity(intent);
        finish();
    }
}