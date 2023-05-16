package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.smartlab.R;

import java.util.Calendar;

public class PinjamBarangActivity extends AppCompatActivity {

    private EditText edt_tangal;
    private ImageButton btn_calender;

    private int tahun, bulan, hari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinjam_barang);

        edt_tangal = findViewById(R.id.edt_outTanggal);
        btn_calender = findViewById(R.id.btn_calender);

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
                        edt_tangal.setFocusable(false);
                        edt_tangal.setClickable(true);
                    }
                }, tahun, bulan, hari);
            }
        });
    }
}