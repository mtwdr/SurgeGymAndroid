package com.example.surgegym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.surgegym.databinding.ActivityMainBinding;

public class Main extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.homeNav:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.classesNav:
                    replaceFragment(new ClassesFragment());
                    break;

                case R.id.locationsNav:
                    replaceFragment(new LocationsFragment());
                    break;

                case R.id.trainersNav:
                    replaceFragment(new TrainersFragment());
                    break;

                case R.id.partnersNav:
                    replaceFragment((new PartnersFragment()));
                    break;
            }

            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.paymentNav:
                replaceFragment(new PaymentFragment());
                break;

            case R.id.passwordNav:
                replaceFragment(new PasswordFragment());
                break;

            case R.id.logoutNav:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}