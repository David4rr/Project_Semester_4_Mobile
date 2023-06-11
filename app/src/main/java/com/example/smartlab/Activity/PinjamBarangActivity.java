package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
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
import com.example.smartlab.SwipeDelete;

import java.util.Calendar;

public class PinjamBarangActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PinjamAdapter pinjamAdapter;
    Activity context;
    UpdatePinjaman updatePinjaman;
    private EditText edt_tanggal, edt_tanggal2;
    private ImageButton btn_calender, btn_calender2;
    ImageView btn_backPinjamBarang, btn_sampah;
    private ItemTouchHelper itemTouchHelper;

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

        itemTouchHelper = new ItemTouchHelper(new SwipeDelete(pinjamAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);

        btn_sampah = findViewById(R.id.img_sampah);
        btn_sampah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinjamAdapter.clearItems();
            }
        });

        btn_backPinjamBarang = findViewById(R.id.img_backpinjamBarang);

        btn_backPinjamBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(PinjamBarangActivity.this, DaftarBarang2Activity.class);
                onBackPressed();
                startActivity(intent);
                finish();
            }
        });

        edt_tanggal = findViewById(R.id.edt_Tanggalin);
        btn_calender = findViewById(R.id.btn_calenderin);
        edt_tanggal.setEnabled(false);

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

                        edt_tanggal.setText(hari + " - " + bulan + " - " + tahun);
                    }
                }, tahun, bulan, hari);
                datePickerDialog.show();
            }
        });

        edt_tanggal2 = findViewById(R.id.edt_Tanggalout);
        btn_calender2 = findViewById(R.id.btn_calenderout);
        edt_tanggal2.setEnabled(false);

        // Fungsi dari kode di bawah adalah untuk mengatur aksi yang terjadi saat tombol btn_calender (tombol untuk memilih tanggal) diklik oleh pengguna.
        btn_calender2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                tahun2 = calendar.get(Calendar.YEAR);
                bulan2 = calendar.get(Calendar.MONTH);
                hari2 = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(PinjamBarangActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        tahun2 = year;
                        bulan2 = month;
                        hari2 = dayOfMonth;

                        edt_tanggal2.setText(hari2 + " - " + bulan2 + " - " + tahun2);
                    }
                }, tahun2, bulan2, hari2);
                datePickerDialog.show();
            }
        });
    }
}