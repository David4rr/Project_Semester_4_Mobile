package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.smartlab.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaftarActivity extends AppCompatActivity {

    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        textInputLayout = findViewById(R.id.inputlayoutDaftar);
        textInputEditText = findViewById(R.id.edt_passwordDaftar);

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
    }
}