package com.example.smartlab.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartlab.Adapter.Barang3Adapter;
import com.example.smartlab.DataBarang3;
import com.example.smartlab.R;

import java.util.ArrayList;
import java.util.List;

public class MenungguDisetujuiFragment extends Fragment {

    RecyclerView recyclerView;
    List<DataBarang3> dataBarang3List;
    Barang3Adapter adapter;
    DataBarang3 dataBarang3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menunggu_disetujui, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewBarang);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        dataBarang3List = new ArrayList<>();

        dataBarang3 = new DataBarang3("Peminjaman 1", "26-02-2023", "12", "Disetujui", R.drawable.panah);
        dataBarang3List.add(dataBarang3);
        dataBarang3 = new DataBarang3("Peminjaman 2", "26-02-2023", "12", "DiTolak", R.drawable.panah);
        dataBarang3List.add(dataBarang3);
        dataBarang3 = new DataBarang3("Peminjaman 3", "26-02-2023", "12", "Disetujui", R.drawable.panah);
        dataBarang3List.add(dataBarang3);
        dataBarang3 = new DataBarang3("Peminjaman 4", "26-02-2023", "12", "DiTolak", R.drawable.panah);
        dataBarang3List.add(dataBarang3);
        dataBarang3 = new DataBarang3("Peminjaman 5", "26-02-2023", "12", "Disetujui", R.drawable.panah);
        dataBarang3List.add(dataBarang3);
        dataBarang3 = new DataBarang3("Peminjaman 6", "26-02-2023", "12", "DiTolak", R.drawable.panah);
        dataBarang3List.add(dataBarang3);
        dataBarang3 = new DataBarang3("Peminjaman 7", "26-02-2023", "12", "Disetujui", R.drawable.panah);
        dataBarang3List.add(dataBarang3);
        dataBarang3 = new DataBarang3("Peminjaman 8", "26-02-2023", "12", "DiTolak", R.drawable.panah);
        dataBarang3List.add(dataBarang3);
        dataBarang3 = new DataBarang3("Peminjaman 9", "26-02-2023", "12", "Disetujui", R.drawable.panah);
        dataBarang3List.add(dataBarang3);
        dataBarang3 = new DataBarang3("Peminjaman 10", "26-02-2023", "12", "DiTolak", R.drawable.panah);
        dataBarang3List.add(dataBarang3);

        adapter = new Barang3Adapter(requireContext(), dataBarang3List);
        recyclerView.setAdapter(adapter);

        return view;
    }
}