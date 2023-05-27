package com.example.smartlab.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartlab.Activity.MasukDaftarActivity;
import com.example.smartlab.MainActivity;
import com.example.smartlab.Preferences;
import com.example.smartlab.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // untuk menampilkan splash screen selama 5 detik, kemudian mengarahkan pengguna ke aktivitas MasukDaftarActivity.
        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MasukDaftarActivity.class));
                finish();
            }
        }, 5000L); //3000 L = 3 detik
    }
}