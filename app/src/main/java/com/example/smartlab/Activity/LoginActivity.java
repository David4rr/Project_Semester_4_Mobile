package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.example.smartlab.MainActivity;
import com.example.smartlab.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;

    Button tombol;
    Intent pindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditText = findViewById(R.id.edt_passwordLogin);
        textInputLayout = findViewById(R.id.inputlayoutlogin);

        tombol = (Button)findViewById(R.id.btn_lgn);

        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String passwordInput = s.toString();
                if (passwordInput.length() >= 8){
                    Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
                    Matcher matcher = pattern.matcher(passwordInput);
                    boolean passwordMatch = matcher.find();
                    if (passwordMatch){
                        textInputLayout.setHelperText("Password Kuat");
                        textInputLayout.setError("");
                    }else {
                        textInputLayout.setError("Membutuhkan Huruf Besar dan kecil, Angka dan Symbol");
                    }
                } else {
                    textInputLayout.setHelperText("Password harus lebih 8 Karakter");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kode untuk pindah ke actifity lain
                pindah = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(pindah);
                //saat pindah, activity yg sekarang langsung ditutup
                //agar saat menekan tombol kembali tidak bolak-balik
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, MasukDaftarActivity.class);
        startActivity(intent);
        finish();
    }
}