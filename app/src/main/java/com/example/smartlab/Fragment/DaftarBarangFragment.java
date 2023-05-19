package com.example.smartlab.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.smartlab.Adapter.BarangAdapter;
import com.example.smartlab.DataBarang;
import com.example.smartlab.R;

import java.util.ArrayList;
import java.util.List;

public class DaftarBarangFragment extends Fragment {

    RecyclerView recyclerView;
    List<DataBarang> dataBarang;
    BarangAdapter adapter;
    DataBarang listBarang;
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

        listBarang = new DataBarang(R.drawable.background_profile, "Arduino Uno", "Arduino Uno 24 pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang.add(listBarang);

        listBarang = new DataBarang(R.drawable.background_profile, "Uno Uno", "Arduino Uno 24 pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang.add(listBarang);

        listBarang = new DataBarang(R.drawable.background_profile, "Dino Uno", "Arduino Uno 24 pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang.add(listBarang);

        listBarang = new DataBarang(R.drawable.background_profile, "Ugio Uno", "Arduino Uno 24 pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang.add(listBarang);

        listBarang = new DataBarang(R.drawable.background_profile, "Mureco Uno", "Arduino Uno 24 pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang.add(listBarang);

        listBarang = new DataBarang(R.drawable.background_profile, "Android Uno", "Arduino Uno 24 pin", "Alat Praktikum", "12", "A123", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam interdum turpis diam, at interdum metus consectetur id. Proin tempus pretium mi,");
        dataBarang.add(listBarang);

        adapter = new BarangAdapter(requireContext(), dataBarang);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void searchList(String text){
        List<DataBarang> dataSearchList = new ArrayList<>();
        for (DataBarang data : dataBarang){
            if (data.getNamaBarang().toLowerCase().contains(text.toLowerCase())){
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