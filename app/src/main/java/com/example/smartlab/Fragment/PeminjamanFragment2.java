package com.example.smartlab.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smartlab.Activity.EditProfileActivity;
import com.example.smartlab.Activity.PinjamBarangActivity;
import com.example.smartlab.Adapter.History2Adapter;
import com.example.smartlab.History2;
import com.example.smartlab.R;

import java.util.ArrayList;
import java.util.List;

public class PeminjamanFragment2 extends Fragment {

    private Button btn_pinjamBarang;

    RecyclerView recyclerView;
    List<History2> history2List;
    History2Adapter adapter;
    History2 history2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_peminjaman2, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewHistory4);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        history2List = new ArrayList<>();

        history2 = new History2("Peminjaman 1","26-02-2023", "12", "12", R.drawable.panah);
        history2List.add(history2);
        history2 = new History2("Peminjaman 2","26-02-2023", "12", "12", R.drawable.panah);
        history2List.add(history2);
        history2 = new History2("Peminjaman 3","26-02-2023", "12", "12", R.drawable.panah);
        history2List.add(history2);
        history2 = new History2("Peminjaman 4","26-02-2023", "12", "12", R.drawable.panah);
        history2List.add(history2);
        history2 = new History2("Peminjaman 5","26-02-2023", "12", "12", R.drawable.panah);
        history2List.add(history2);
        history2 = new History2("Peminjaman 6","26-02-2023", "12", "12", R.drawable.panah);
        history2List.add(history2);
        history2 = new History2("Peminjaman 7","26-02-2023", "12", "12", R.drawable.panah);
        history2List.add(history2);
        history2 = new History2("Peminjaman 8","26-02-2023", "12", "12", R.drawable.panah);
        history2List.add(history2);
        history2 = new History2("Peminjaman 9","26-02-2023", "12", "12", R.drawable.panah);
        history2List.add(history2);

        adapter = new History2Adapter(requireContext(), history2List);
        recyclerView.setAdapter(adapter);

        btn_pinjamBarang = view.findViewById(R.id.btn_pinjamBarang);

        btn_pinjamBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent untuk memulai EditProfileActivity
                Intent intent = new Intent(getActivity(), PinjamBarangActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}