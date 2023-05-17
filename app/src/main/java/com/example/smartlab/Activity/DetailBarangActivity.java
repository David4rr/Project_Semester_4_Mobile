package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartlab.R;

public class DetailBarangActivity extends AppCompatActivity {

    TextView txt_idBarang, txt_detailKategori, txt_namaBarang, txt_detailBarang, txt_deskripsiBarang, txt_stock;
    ImageView img_detailBarang, btn_backDetailBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        txt_idBarang = findViewById(R.id.txt_idBarang);
        txt_detailKategori = findViewById(R.id.txt_detailKategori);
        txt_namaBarang = findViewById(R.id.txt_namaBarang);
        txt_detailBarang = findViewById(R.id.txt_detailBarang);
        txt_deskripsiBarang = findViewById(R.id.txt_deskripsiBarang);
        txt_stock = findViewById(R.id.txt_stock);
        img_detailBarang = findViewById(R.id.img_detailBarang);
        btn_backDetailBarang = findViewById(R.id.img_backDetailBarang);

        btn_backDetailBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onBackPressed();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            txt_idBarang.setText(bundle.getString("IdBarang"));
            txt_detailKategori.setText(bundle.getString("Kategori"));
            txt_namaBarang.setText(bundle.getString("NamaBarang"));
            txt_detailBarang.setText(bundle.getString("DetailBarang"));
            txt_deskripsiBarang.setText(bundle.getString("DeskripsiBarang"));
            txt_stock.setText(bundle.getString("Stock"));
            img_detailBarang.setImageResource(bundle.getInt("ImageBarang"));
        }
    }
}