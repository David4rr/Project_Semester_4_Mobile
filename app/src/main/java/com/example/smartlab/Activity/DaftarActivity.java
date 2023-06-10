package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartlab.ApiClient;
import com.example.smartlab.MainActivity;
import com.example.smartlab.Models.LoginResponse;
import com.example.smartlab.Models.RegisterRequest;
import com.example.smartlab.Models.RegisterResponse;
import com.example.smartlab.Models.UserRequest;
import com.example.smartlab.Preferences;
import com.example.smartlab.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarActivity extends AppCompatActivity {

    // Mendeklarasikan objek textInputLayout dan textInputEditText
    EditText edt_emaildaftar, edt_nama, edt_nohp;
    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;
    Button btn_daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        // Menginisialisasi objek textInputLayout dan textInputEditText dengan menggunakan ID yang sesuai dari tata letak XML
        edt_nama = findViewById(R.id.edt_nama);
        edt_nohp = findViewById(R.id.edt_nohp);
        edt_emaildaftar = findViewById(R.id.edt_email);
        textInputLayout = findViewById(R.id.inputlayoutDaftar);
        textInputEditText = findViewById(R.id.edt_passwordDaftar);
        btn_daftar = findViewById(R.id.btn_daftar);
        btn_daftar.setOnClickListener((v) -> {
            if (TextUtils.isEmpty(edt_nama.getText().toString()) || TextUtils.isEmpty(edt_nohp.getText().toString()) || TextUtils.isEmpty(edt_emaildaftar.getText().toString()) || TextUtils.isEmpty(textInputEditText.getText().toString())){
                edt_nama.setError("Nama Required");
                edt_nohp.setError("Phone Required");
                edt_emaildaftar.setError("Email Required");
                textInputEditText.setError("Password Required");
                edt_emaildaftar.requestFocus();
                textInputEditText.requestFocus();
                return;
            }else{
                getData();
            }
        });
    }

    private void getData(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName(edt_nama.getText().toString());
        registerRequest.setEmail(edt_emaildaftar.getText().toString());
        registerRequest.setPhone(edt_nohp.getText().toString());
        registerRequest.setPassword(textInputEditText.getText().toString());

        Call<RegisterResponse> registerResponseCall = ApiClient.getUserService(DaftarActivity.this).registerUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse( Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(DaftarActivity.this, "Berhasil Daftar", Toast.LENGTH_LONG).show();
                    RegisterResponse registerResponse = response.body();

                    Preferences preferences = new Preferences();
                    Preferences.setRegisteredUser(getBaseContext(), edt_nama.getText().toString());
                    Preferences.setRegisteredEmail(getBaseContext(), edt_emaildaftar.getText().toString());
                    Preferences.setRegisteredNohp(getBaseContext(), edt_nohp.getText().toString());
                    Preferences.setRegisteredPass(getBaseContext(), textInputEditText.getText().toString());
                    startActivity(new Intent(getBaseContext(), LoginActivity.class));

                }else{
                    Toast.makeText(DaftarActivity.this, "Gagal Daftar", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure( Call<RegisterResponse> call, Throwable t) {
                Log.d("Test Isi Jika Gagal" +
                        "", t.getMessage());

            }
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