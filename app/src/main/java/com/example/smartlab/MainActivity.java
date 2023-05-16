package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.smartlab.Fragment.DaftarBarangFragment;
import com.example.smartlab.Fragment.HomeFragment;
import com.example.smartlab.Fragment.PeminjamanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    PeminjamanFragment peminjamanFragment = new PeminjamanFragment();
    DaftarBarangFragment daftarBarangFragment = new DaftarBarangFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_navigator);
        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
        // Code Diatas untuk mengatur default bottom navigator nya

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        // Code diatas untuk memanggil fragmennya

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.peminjaman:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,peminjamanFragment).commit();
                        return true;
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.daftarbarang:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,daftarBarangFragment).commit();
                        return true;
                }

                return false;
            }
        });
        // code diatas untuk berfungsi memindahkan fragment 1 dan fragment lainya

    }


}