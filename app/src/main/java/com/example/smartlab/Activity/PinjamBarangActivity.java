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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.smartlab.Adapter.PinjamAdapter;
import com.example.smartlab.ApiClient;
import com.example.smartlab.Fragment.PeminjamanFragment;
import com.example.smartlab.Interface.UpdatePinjaman;
import com.example.smartlab.MainActivity;
import com.example.smartlab.Models.EditUserRequest;
import com.example.smartlab.Models.EditUserResponse;
import com.example.smartlab.Models.LendingRequest;
import com.example.smartlab.Models.LendingResponse;
import com.example.smartlab.Preferences;
import com.example.smartlab.R;
import com.example.smartlab.SwipeDelete;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PinjamBarangActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PinjamAdapter pinjamAdapter;
    Activity context;
    UpdatePinjaman updatePinjaman;
    private EditText edt_tanggal, edt_tanggal2;
    private ImageButton btn_calender, btn_calender2;
    ImageView btn_backPinjamBarang, btn_sampah;
    private ItemTouchHelper itemTouchHelper;
    Button btn_pinjam;
    Intent pindah;

    private int tahun, bulan, hari;
    private int tahun2, bulan2, hari2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinjam_barang);

        btn_pinjam = findViewById(R.id.btn_pinjam);
        btn_pinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kode untuk pindah ke actifity lain
                pindah = new Intent(PinjamBarangActivity.this, MainActivity.class);
                getData();
                startActivity(pindah);
                finish(); // Menutup aktivitas setelah mengirim hasil
                //saat pindah, activity yg sekarang langsung ditutup
                //agar saat menekan tombol kembali tidak bolak-balik
//                finish();
            }
        });

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

//                        edt_tanggal.setText(hari + "-" + bulan + "-" + tahun);
                        edt_tanggal.setText(tahun + "-" + bulan + "-" + hari);
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

//                        edt_tanggal2.setText(hari2 + "-" + bulan2 + "-" + tahun2);
                        edt_tanggal2.setText(tahun2 + "-" + bulan2 + "-" + hari2);
                    }
                }, tahun2, bulan2, hari2);
                datePickerDialog.show();
            }
        });
    }
    private void getData() {
        LendingRequest lendingRequest = new LendingRequest();
        Preferences preferences = new Preferences(this);
        String id_user = preferences.getString("id", "");
        lendingRequest.setUser(id_user);
        System.out.println("id"+id_user);
        lendingRequest.setLending_date(edt_tanggal.getText().toString());
        lendingRequest.setReturn_date(edt_tanggal2.getText().toString());

        Call<LendingResponse> lending = ApiClient.getUserService(PinjamBarangActivity.this).lending(lendingRequest);
        lending.enqueue(new Callback<LendingResponse>() {
            @Override
            public void onResponse(Call<LendingResponse> call, Response<LendingResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(PinjamBarangActivity.this, "Berhasil Ubah Data", Toast.LENGTH_LONG).show();
                    LendingResponse lendingResponse = response.body();
                } else {
                    Toast.makeText(PinjamBarangActivity.this, "Gagal Ubah Data", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LendingResponse> call, Throwable t) {
                Log.d("Test Isi Jika Gagal" +
                        "", t.getMessage());

            }
        });
    }
}