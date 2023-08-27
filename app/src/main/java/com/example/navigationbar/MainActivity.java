package com.example.navigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.navigationbar.databinding.ActivityMainBinding;
import com.example.navigationbar.fragment.eatingFragment;
import com.example.navigationbar.fragment.homeFragment;
import com.example.navigationbar.fragment.profileFragment;
import com.example.navigationbar.fragment.settingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //-------------------> this code using to hide status bar <-----------------------------//
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);



        replaceFragment(new homeFragment());


        binding.navBar.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_home) {

                replaceFragment(new homeFragment());


            } else if (item.getItemId() == R.id.profile) {
                replaceFragment(new profileFragment());

            } else if (item.getItemId() == R.id.setting) {
                replaceFragment(new settingFragment());

            } else if (item.getItemId() == R.id.eating) {
                replaceFragment(new eatingFragment());
            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.body_container, fragment);
        transaction.commit();
    }
}