package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.smartlab.Adapter.PinjamAdapter;
import com.example.smartlab.Interface.UpdatePinjaman;
import com.example.smartlab.R;

import java.util.Calendar;

public class PinjamBarangActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PinjamAdapter pinjamAdapter;
    Activity context;
    UpdatePinjaman updatePinjaman;
    private EditText edt_tangal;
    private ImageButton btn_calender;

//    Button button;
//    Intent pindah;

    ImageView btn_backPinjamBarang;

    private int tahun, bulan, hari;
    private int tahun2, bulan2, hari2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinjam_barang);

        recyclerView = findViewById(R.id.rcylPinjam);
        pinjamAdapter = new PinjamAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(pinjamAdapter);

//        button = (Button)findViewById(R.id.btn_daftarBarang2);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                //kode untuk pindah ke actifity lain
//                Intent pindah = new Intent(PinjamBarangActivity.this, DaftarBarang2Activity.class);
//                startActivity(pindah);
                //saat pindah, activity yg sekarang langsung ditutup
                //agar saat menekan tombol kembali tidak bolak-balik
//            }
//        });

        btn_backPinjamBarang = findViewById(R.id.img_backpinjamBarang);

        btn_backPinjamBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
//                onBackPressed();
                Intent intent = new Intent(PinjamBarangActivity.this, DaftarBarang2Activity.class);
                startActivity(intent);
                finish();
            }
        });

        edt_tangal = findViewById(R.id.edt_outTanggal);
        btn_calender = findViewById(R.id.btn_calender);
        edt_tangal.setEnabled(false);

        // Fungsi dari kode di bawah adalah untuk mengatur aksi yang terjadi saat tombol btn_calender (tombol untuk memilih tanggal) diklik oleh pengguna.
        btn_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                tahun = calendar.get(Calendar.YEAR);
                bulan = calendar.get(Calendar.MONTH);
                hari = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(PinjamBarangActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        tahun = year;
                        bulan = month;
                        hari = dayOfMonth;

                        edt_tangal.setText(hari + " - " + bulan + " - " + tahun);
                    }
                }, tahun, bulan, hari);
                datePickerDialog.show();
            }
        });

    }
}