package com.example.smartlab.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smartlab.Activity.EditProfileActivity;
import com.example.smartlab.Activity.PinjamBarangActivity;
import com.example.smartlab.R;

import java.util.ArrayList;

public class PeminjamanFragment2 extends Fragment {

    private Button btn_pinjamBarang;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_peminjaman2, container, false);

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