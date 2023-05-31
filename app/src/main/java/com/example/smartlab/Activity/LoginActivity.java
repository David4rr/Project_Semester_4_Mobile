package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartlab.Adapter.BarangAdapter;
import com.example.smartlab.ApiClient;
import com.example.smartlab.DataBarang;
import com.example.smartlab.Models.LoginResponse;
import com.example.smartlab.Models.UserRequest;
import com.example.smartlab.Preferences;
import com.example.smartlab.MainActivity;
import com.example.smartlab.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edt_email;

    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;

    Button tombol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_email = findViewById(R.id.edt_email);
        textInputEditText = findViewById(R.id.edt_passwordLogin);
        textInputLayout = findViewById(R.id.inputlayoutlogin);

        tombol = findViewById(R.id.btn_lgn);

        textInputEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (TextUtils.isEmpty(edt_email.getText().toString()) || TextUtils.isEmpty(textInputEditText.getText().toString())){
                edt_email.setError("Email Required");
                textInputEditText.setError("Password Required");
                edt_email.requestFocus();
                textInputEditText.requestFocus();
                return true;
            }else{
                return false;
            }
        });

        tombol.setOnClickListener((v) -> {
            if (TextUtils.isEmpty(edt_email.getText().toString()) || TextUtils.isEmpty(textInputEditText.getText().toString())){
                edt_email.setError("Email Required");
                textInputEditText.setError("Password Required");
                edt_email.requestFocus();
                textInputEditText.requestFocus();
                return;
            }else{
                getData();
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(),MainActivity.class));
            finish();
        }
    }

//    private void razia() {
//        edt_email.setError(null);
//        textInputEditText.setError(null);
//        View fokus = null;
//        boolean cancel = false;
//
//        String email = edt_email.getText().toString();
//        String password = textInputEditText.getText().toString();
//
//        if (TextUtils.isEmpty(email)){
//            edt_email.setError("Field tidak boleh kosong");
//            fokus = edt_email;
//            cancel = true;
//        } else if (!cekEmail(email)){
//            edt_email.setError("Email ini tidak tersedia");
//            fokus = edt_email;
//            cancel = true;
//        }
//        if (TextUtils.isEmpty(password)){
//            textInputEditText.setError("Field tidak boleh kosong");
//            fokus = textInputEditText;
//            cancel = true;
//        } else if (!cekPassword(password)) {
//            textInputEditText.setError("Password Salah");
//            fokus = textInputEditText;
//            cancel = true;
//        }
//
//        if (cancel) fokus.requestFocus();
//        else getData();
//
//    }


    private void masuk() {
        Preferences.setLoggedInUser(getBaseContext(), edt_email.getText().toString());
        Preferences.setLoggedInStatus(getBaseContext(), true);
        startActivity(new Intent(getBaseContext(), MainActivity.class));
    }

    private void getData(){
        UserRequest loginRequest = new UserRequest();
        loginRequest.setEmail(edt_email.getText().toString());
        loginRequest.setPassword(textInputEditText.getText().toString());

        Call<LoginResponse> loginResponsecall = ApiClient.getUserService(LoginActivity.this).loginUser(loginRequest);
        loginResponsecall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse( Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();

                    Preferences preferences = new Preferences();
//                    UserRequest loginRequests = loginResponse.getData();
//                    preferences.saveString("email", edt_email.getText().toString());
//                    preferences.saveString("password", loginRequests.getPassword());
                    Preferences.setLoggedInUser(getBaseContext(), edt_email.getText().toString());
                    Preferences.setLoggedInStatus(getBaseContext(), true);
                    startActivity(new Intent(getBaseContext(), MainActivity.class));

                }else{
                    Toast.makeText(LoginActivity.this, "Gagal Login", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure( Call<LoginResponse> call, Throwable t) {
                Log.d("Test Isi Jika Gagal" +
                        "", t.getMessage());

            }
        });
    }

//    private boolean cekPassword(String password) {
//        SharedPreferences sp = getSharedPreferences("daftar", Context.MODE_PRIVATE);
//        if(sp.getString("pass", "").equals(password)){
//            return true;
//        }
//        return false;
//    }
//
//
//    private boolean cekEmail(String email) {
//        SharedPreferences sp = getSharedPreferences("daftar", Context.MODE_PRIVATE);
//        if(sp.getString("email","").equals(email)){
//            return true;
//        }
//        return false;
//    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, MasukDaftarActivity.class);
        startActivity(intent);
        finish();
    }
}

