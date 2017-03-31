package com.example.utsav.login_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SigninFragment signinFragment = SigninFragment.newInstance("", "");
        addFragment(R.id.fragment_container, signinFragment);

    }

    public void addFragment(int id, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(id, fragment);
        transaction.addToBackStack("");

        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager manager = getSupportFragmentManager();

        if (manager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
