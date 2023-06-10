package com.example.smartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartlab.Adapter.BarangAdapter;
import com.example.smartlab.ApiClient;
import com.example.smartlab.DataBarang;
import com.example.smartlab.MainActivity;
import com.example.smartlab.Models.EditUserRequest;
import com.example.smartlab.Models.EditUserResponse;
import com.example.smartlab.Models.LoginResponse;
import com.example.smartlab.Preferences;
import com.example.smartlab.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {

    TextView txt_namaPengguna, txt_Email, txt_noHp, txt_password;
    ImageView btn_backAkun;
    Button btn_ubah;
    Intent pindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        txt_namaPengguna = findViewById(R.id.txt_namaPengguna);
        txt_Email = findViewById(R.id.txt_Email);
        txt_noHp = findViewById(R.id.txt_noHp);
        txt_password = findViewById(R.id.txt_password);

        btn_ubah = findViewById(R.id.btn_ubah);

        btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kode untuk pindah ke actifity lain
                pindah = new Intent(EditProfileActivity.this, EditAkunActivity.class);
                startActivity(pindah);
                //saat pindah, activity yg sekarang langsung ditutup
                //agar saat menekan tombol kembali tidak bolak-balik
                finish();
            }
        });

        btn_backAkun = findViewById(R.id.img_backAkun);

        //  menavigasikan pengguna kembali ke aktivitas sebelumnya.
        btn_backAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


}