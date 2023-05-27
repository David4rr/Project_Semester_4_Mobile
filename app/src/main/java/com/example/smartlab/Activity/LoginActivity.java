package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartlab.Preferences;
import com.example.smartlab.MainActivity;
import com.example.smartlab.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private EditText edt_email;

    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;

    Button tombol;
//    Intent pindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_email = findViewById(R.id.edt_email);
        textInputEditText = findViewById(R.id.edt_passwordLogin);
        textInputLayout = findViewById(R.id.inputlayoutlogin);

        tombol = (Button)findViewById(R.id.btn_lgn);

        textInputEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL){
                razia();
                return true;
            }
            return false;
        });

        findViewById(R.id.btn_lgn).setOnClickListener((v) -> {
            razia();
        });

//        textInputEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            // Digunakan untuk melakukan validasi pada input password. Ketika teks pada textInputEditText berubah, kode tersebut akan memeriksa panjang password dan pola karakter yang memenuhi persyaratan tertentu.
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String passwordInput = s.toString();
//                if (passwordInput.length() >= 8){
//                    Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
//                    Matcher matcher = pattern.matcher(passwordInput);
//                    boolean passwordMatch = matcher.find();
//                    if (passwordMatch){
//                        textInputLayout.setHelperText("Password Kuat");
//                        textInputLayout.setError("");
//                    }else {
//                        textInputLayout.setError("Membutuhkan Huruf Besar dan kecil, Angka dan Symbol");
//                    }
//                } else {
//                    textInputLayout.setHelperText("Password harus lebih 8 Karakter");
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

//        tombol.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //kode untuk pindah ke actifity lain
//                pindah = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(pindah);
//                //saat pindah, activity yg sekarang langsung ditutup
//                //agar saat menekan tombol kembali tidak bolak-balik
//                finish();
//            }
//        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(),MainActivity.class));
            finish();
        }
    }

    private void razia() {
        edt_email.setError(null);
        textInputEditText.setError(null);
        View fokus = null;
        boolean cancel = false;

        String email = edt_email.getText().toString();
        String password = textInputEditText.getText().toString();

        if (TextUtils.isEmpty(email)){
            edt_email.setError("Field tidak boleh kosong");
            fokus = edt_email;
            cancel = true;
        } else if (!cekEmail(email)){
            edt_email.setError("Email ini tidak tersedia");
            fokus = edt_email;
            cancel = true;
        }
        if (TextUtils.isEmpty(password)){
            textInputEditText.setError("Field tidak boleh kosong");
            fokus = textInputEditText;
            cancel = true;
        } else if (!cekPassword(password)) {
            textInputEditText.setError("Password Salah");
            fokus = textInputEditText;
            cancel = true;
        }

        if (cancel) fokus.requestFocus();
        else masuk();

    }

    private void masuk() {
        Preferences.setLoggedInUser(getBaseContext(), edt_email.getText().toString());
        Preferences.setLoggedInStatus(getBaseContext(), true);
        startActivity(new Intent(getBaseContext(), MainActivity.class));
    }

    private boolean cekPassword(String password) {
        SharedPreferences sp = getSharedPreferences("daftar", Context.MODE_PRIVATE);
        if(sp.getString("pass", "").equals(password)){
            return true;
        }
        return false;
    }


    private boolean cekEmail(String email) {
        SharedPreferences sp = getSharedPreferences("daftar", Context.MODE_PRIVATE);
        if(sp.getString("email","").equals(email)){
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, MasukDaftarActivity.class);
        startActivity(intent);
        finish();
    }
}

