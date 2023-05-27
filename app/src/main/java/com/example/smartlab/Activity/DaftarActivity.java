package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartlab.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaftarActivity extends AppCompatActivity {

    // Mendeklarasikan objek textInputLayout dan textInputEditText
    EditText edt_emaildaftar;
    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;
    Button btn_daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        // Menginisialisasi objek textInputLayout dan textInputEditText dengan menggunakan ID yang sesuai dari tata letak XML
        edt_emaildaftar = findViewById(R.id.edt_email);
        textInputLayout = findViewById(R.id.inputlayoutDaftar);
        textInputEditText = findViewById(R.id.edt_passwordDaftar);
        btn_daftar = findViewById(R.id.btn_daftar);
        btn_daftar.setOnClickListener((v) -> {
                SharedPreferences sp = getSharedPreferences("daftar", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("email", edt_emaildaftar.getText().toString());
                editor.putString("pass", textInputEditText.getText().toString());
                editor.commit();
                editor.apply();
                Intent intent = new Intent(DaftarActivity.this, LoginActivity.class);
                startActivity(intent);
        });
    }

    // Ketika tombol "Back" ditekan dalam DaftarActivity, pengguna akan diarahkan ke MasukDaftarActivity dan DaftarActivity akan dihancurkan.
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DaftarActivity.this, MasukDaftarActivity.class);
        startActivity(intent);
        finish();
    }
}