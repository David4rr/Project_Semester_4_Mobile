package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartlab.Adapter.Barang2Adapter;
import com.example.smartlab.Adapter.BarangAdapter;
import com.example.smartlab.ApiClient;
import com.example.smartlab.DataBarang;
import com.example.smartlab.DataBarang2;
import com.example.smartlab.Interface.UpdatePinjaman;
import com.example.smartlab.R;
import com.example.smartlab.Interface.UpdateRecyclerviewBarang;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarBarang2Activity extends AppCompatActivity implements UpdateRecyclerviewBarang{

    // Variabel ini adalah objek RecyclerView yang digunakan untuk menampilkan daftar item.
     private RecyclerView recyclerView;
     private Barang2Adapter barang2Adapter;

     Button btn_back;

    // Variabel ini adalah List yang berisi objek DataBarang2.
    ArrayList<DataBarang2> dataBarang2List = new ArrayList();

    // Variabel ini adalah objek SearchView yang digunakan untuk menyediakan fungsi pencarian dalam RecyclerView.
    SearchView searchView;

    UpdatePinjaman updatePinjaman;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_barang2);

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

        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(DaftarBarang2Activity.this, PinjamBarangActivity.class);
        startActivity(intent);
        finish();
            }
        });

        ArrayList<DataBarang2> dataBarang2List = new ArrayList<>();
        getData();

        // Baris ini menginisialisasi objek
        recyclerView = findViewById(R.id.recyclerviewHistory3);
        barang2Adapter = new Barang2Adapter(context, dataBarang2List, updatePinjaman);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(barang2Adapter);

    }

    private void getData(){

        Call<ArrayList<DataBarang2>> barang = ApiClient.getUserService(DaftarBarang2Activity.this).getBarang2();
        barang.enqueue(new Callback<ArrayList<DataBarang2>>() {
            @Override
            public void onResponse( Call<ArrayList<DataBarang2>> call, Response<ArrayList<DataBarang2>> response) {
                ArrayList<DataBarang2> barang = response.body();
                barang2Adapter = new Barang2Adapter(DaftarBarang2Activity.this, barang, updatePinjaman);
                dataBarang2List.addAll(barang);
                recyclerView.setAdapter(barang2Adapter);
                barang2Adapter.notifyDataSetChanged();
                Log.d("TEST ISI", barang.toString());
            }

            @Override
            public void onFailure( Call<ArrayList<DataBarang2>> call, Throwable t) {
                Log.d("Test Isi Jika Gagal" +
                        "", t.getMessage());

            }
        });

    }

    @Override
    public void callback(int position, ArrayList<DataBarang2> dataBarang2List){
        barang2Adapter = new Barang2Adapter(context, dataBarang2List, updatePinjaman);
        barang2Adapter.notifyDataSetChanged();
        recyclerView.setAdapter(barang2Adapter);
    }

    // Untuk melakukan pencarian berdasarkan nama barang dalam dataBarang2List, dan hasil pencarian akan ditampilkan dalam RecyclerView melalui pembaruan data dalam adapter.
    private void searchList2(String text){
        ArrayList<DataBarang2> dataSearchList = new ArrayList<>();
        for (DataBarang2 data : dataBarang2List){
            if (data.getTitle().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(this, "Data Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        } else {
            barang2Adapter.setSearchList2(dataSearchList);
        }
    }

}

