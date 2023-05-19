package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.smartlab.R;

public class DetailPeminjamanActivity extends AppCompatActivity {

    TextView ttl_pilihBarang, txt_hari, txt_totalItems, edt_outTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_peminjaman);

        ttl_pilihBarang = findViewById(R.id.ttl_pilihBarang);
        txt_hari = findViewById(R.id.txt_hari);
        txt_totalItems = findViewById(R.id.txt_totalItems);
        edt_outTanggal = findViewById(R.id.edt_outTanggal);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            ttl_pilihBarang.setText(bundle.getString("Peminjaman"));
            txt_hari.setText(bundle.getString("Hari"));
            txt_totalItems.setText(bundle.getString("Total"));
            edt_outTanggal.setText(bundle.getString("Tanggal"));
        }
    }
}