package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartlab.MainActivity;
import com.example.smartlab.Preferences;
import com.example.smartlab.R;

public class MasukDaftarActivity extends AppCompatActivity {
    Button tombol, tombol2;
    Intent pindah, pindah2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk_daftar);

        tombol = (Button)findViewById(R.id.btn_1);
        tombol2 = (Button)findViewById(R.id.btn_2);

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kode untuk pindah ke actifity lain
                pindah = new Intent(MasukDaftarActivity.this, LoginActivity.class);
                startActivity(pindah);
                //saat pindah, activity yg sekarang langsung ditutup
                //agar saat menekan tombol kembali tidak bolak-balik
                finish();
            }
        });

        tombol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kode untuk pindah ke actifity lain
                pindah2 = new Intent(MasukDaftarActivity.this, DaftarActivity.class);
                startActivity(pindah2);
                //saat pindah, activity yg sekarang langsung ditutup
                //agar saat menekan tombol kembali tidak bolak-balik
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(), MainActivity.class));
            finish();
        }

    }
}