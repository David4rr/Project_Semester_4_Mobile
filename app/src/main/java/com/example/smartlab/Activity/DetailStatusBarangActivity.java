package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.smartlab.R;

public class DetailStatusBarangActivity extends AppCompatActivity {

    TextView ttl_pilihBarang, txt_status, txt_totalItems, edt_outTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_status_barang);

        ttl_pilihBarang = findViewById(R.id.ttl_pilihBarang);
        txt_status = findViewById(R.id.txt_status);
        txt_totalItems = findViewById(R.id.txt_totalItems);
        edt_outTanggal = findViewById(R.id.edt_outTanggal);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            ttl_pilihBarang.setText(bundle.getString("Peminjaman"));
            txt_status.setText(bundle.getString("Status"));
            txt_totalItems.setText(bundle.getString("Total"));
            edt_outTanggal.setText(bundle.getString("Tanggal"));
        }
    }
}