package com.example.smartlab.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
//import android.support.v4.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartlab.Activity.EditProfileActivity;
import com.example.smartlab.Adapter.BarangAdapter;
import com.example.smartlab.Adapter.HistoryAdapter;
import com.example.smartlab.ApiClient;
import com.example.smartlab.DataBarang;
import com.example.smartlab.History;
import com.example.smartlab.Preferences;
import com.example.smartlab.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    Preferences preferences;
    private Button btn_edtProfile, btn_totalBarang;
    private TextView txt_nama;
    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;
    private ArrayList<History> historyArrayList;
    // code diatas berfungsi untuk insialisasi pada Recyclerview

    BarChart barChart;
    // Code di atas untuk chart

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_totalBarang = view.findViewById(R.id.btn_totalbarang);

        preferences = new Preferences(requireContext());
        txt_nama = view.findViewById(R.id.txt_nama);
        txt_nama.setText(preferences.getString("name", ""));

        btn_edtProfile = view.findViewById(R.id.btn_edtprofile);

        btn_edtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent untuk memulai EditProfileActivity
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        addData();

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerviewHistory);

        historyAdapter = new HistoryAdapter(historyArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(historyAdapter);
        //Code diatas bagian untuk Recyclerview


        barChart = (BarChart) view.findViewById(R.id.barCharts);

        ArrayList<BarEntry> visitors = new ArrayList<>();
        visitors.add(new BarEntry(1, 50));
        visitors.add(new BarEntry(2, 60));
        visitors.add(new BarEntry(3, 80));
        visitors.add(new BarEntry(4, 20));
        visitors.add(new BarEntry(5, 40));
        visitors.add(new BarEntry(6, 50));
        visitors.add(new BarEntry(7, 80));
        visitors.add(new BarEntry(8, 70));
        visitors.add(new BarEntry(9, 60));
        visitors.add(new BarEntry(10, 30));
        // Code diatas untuk data Chartnya (masih dumd data)

        BarDataSet barDataSet = new BarDataSet(visitors, "Visitors");
        barDataSet.setColors(Color.rgb(48,68,158));
        barDataSet.setValueTextColor(Color.WHITE);
        barDataSet.setHighLightColor(Color.CYAN);
        barDataSet.setValueTextSize(16f);
        // Code diatas untuk mengatur warna chartnya

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setBackgroundTintBlendMode(BlendMode.CLEAR);
        barChart.setData(barData);
        barChart.getDescription().setText("Grafik Peminjaman");
        barChart.animateY(2000);

        return view;
    }
    // Code diatas berfungsi untuk mengatur animasi (kurang paham), code diatas menunjukan kodingan buat chart

    void addData(){
        historyArrayList = new ArrayList<>();
        historyArrayList.add(new History("Peminjaman 1","26-02-2023", "12", "12"));
        historyArrayList.add(new History("Peminjaman 2","26-02-2023", "12", "12"));
        historyArrayList.add(new History("Peminjaman 3","26-02-2023", "12", "12"));
        historyArrayList.add(new History("Peminjaman 4","26-02-2023", "12", "12"));
        historyArrayList.add(new History("Peminjaman 5","26-02-2023", "12", "12"));
        historyArrayList.add(new History("Peminjaman 5","26-02-2023", "12", "12"));
        historyArrayList.add(new History("Peminjaman 5","26-02-2023", "12", "12"));
        historyArrayList.add(new History("Peminjaman 5","26-02-2023", "12", "12"));
        historyArrayList.add(new History("Peminjaman 5","26-02-2023", "12", "12"));
        historyArrayList.add(new History("Peminjaman 5","26-02-2023", "12", "12"));
    }
    // Code diatas untuk data Recyclerview


}