package com.example.smartlab.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.smartlab.Adapter.BarangAdapter;
import com.example.smartlab.ApiClient;
import com.example.smartlab.DataBarang;
import com.example.smartlab.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarBarangFragment extends Fragment {

    RecyclerView recyclerView;
    List<DataBarang> dataBarang;
    BarangAdapter adapter;
//    DataBarang listBarang;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daftar_barang, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewHistory2);
        searchView = (SearchView) view.findViewById(R.id.search);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataBarang = new ArrayList<>();

        adapter = new BarangAdapter(requireContext(), dataBarang);
        recyclerView.setAdapter(adapter);

        getData();

        return view;
    }
    private void getData(){

        Call<List<DataBarang>> barang = ApiClient.getUserService(getContext()).getBarang();
        barang.enqueue(new Callback<List<DataBarang>>() {
            @Override
            public void onResponse( Call<List<DataBarang>> call, Response<List<DataBarang>> response) {
                List<DataBarang> barang = response.body();
                adapter = new BarangAdapter(requireContext(), barang);
                dataBarang.addAll(barang);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Log.d("TEST ISI", barang.toString());
            }

            @Override
            public void onFailure( Call<List<DataBarang>> call, Throwable t) {
                Log.d("Test Isi Jika Gagal" +
                        "", t.getMessage());

            }
        });

    }

    private void searchList(String text){
        List<DataBarang> dataSearchList = new ArrayList<>();
        for (DataBarang data : dataBarang){
            if (data.getTitle().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText( requireContext(), "Data Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
}