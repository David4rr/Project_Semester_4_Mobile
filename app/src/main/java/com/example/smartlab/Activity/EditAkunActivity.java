package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.smartlab.ApiClient;
import com.example.smartlab.MainActivity;
import com.example.smartlab.Models.EditUserRequest;
import com.example.smartlab.Models.EditUserResponse;
import com.example.smartlab.Preferences;
import com.example.smartlab.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditAkunActivity extends AppCompatActivity {

    EditText edt_nama, edt_email, edt_nohp, edt_password;
    ImageView btn_editAkun;
    Button btn_perbarui;
    Intent pindah;
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_akun);

        preferences = new Preferences(this);
        edt_nama = findViewById(R.id.edt_nama);
        edt_email = findViewById(R.id.edt_email);
        edt_nohp = findViewById(R.id.edt_nohp);
        userData();

        btn_perbarui = findViewById(R.id.btn_perbarui);

        btn_perbarui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kode untuk pindah ke actifity lain
                pindah = new Intent(EditAkunActivity.this, LoginActivity.class);
                getData();
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(pindah);
                finish(); // Menutup aktivitas setelah mengirim hasil
                //saat pindah, activity yg sekarang langsung ditutup
                //agar saat menekan tombol kembali tidak bolak-balik
//                finish();
            }
        });

        btn_editAkun = findViewById(R.id.img_backEditAkun);

        // menavigasikan pengguna kembali ke aktivitas sebelumnya.
        btn_editAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void getData(){
        EditUserRequest editUserRequest = new EditUserRequest();
        editUserRequest.setName(edt_nama.getText().toString());
        editUserRequest.setEmail(edt_email.getText().toString());
        editUserRequest.setPhone(edt_nohp.getText().toString());

        Call<EditUserResponse> editUserResponseCall = ApiClient.getUserService(EditAkunActivity.this).editUser(editUserRequest);
        editUserResponseCall.enqueue(new Callback<EditUserResponse>() {
            @Override
            public void onResponse( Call<EditUserResponse> call, Response<EditUserResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(EditAkunActivity.this, "Berhasil Ubah Data", Toast.LENGTH_LONG).show();
                    EditUserResponse editUserResponse = response.body();

//                    Preferences preferences = new Preferences();
////                    UserRequest loginRequests = loginResponse.getData();
////                    preferences.saveString("email", edt_email.getText().toString());
////                    preferences.saveString("password", loginRequests.getPassword());
//                    Preferences.setLoggedInUser(getBaseContext(), edt_email.getText().toString());
//                    Preferences.setLoggedInStatus(getBaseContext(), true);
//                    startActivity(new Intent(getBaseContext(), EditProfileActivity.class));

                }else{
                    Toast.makeText(EditAkunActivity.this, "Gagal Ubah Data", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure( Call<EditUserResponse> call, Throwable t) {
                Log.d("Test Isi Jika Gagal" +
                        "", t.getMessage());

            }
        });

    }
    public  void userData(){
        edt_nama.setText(preferences.getString("name", ""));
        edt_email.setText(preferences.getString("email", ""));
        edt_nohp.setText(preferences.getString("phone", ""));
        edt_email.setEnabled(false);
    }
}