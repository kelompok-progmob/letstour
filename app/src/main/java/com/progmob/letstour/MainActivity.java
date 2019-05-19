package com.progmob.letstour;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.progmob.letstour.adapter.CountriesAdapter;
import com.progmob.letstour.mainfragment.AboutsFragment;
import com.progmob.letstour.mainfragment.TourFragment;
import com.progmob.letstour.model.ModelCountry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView mBottomNavigation;

    //TAG
    final String TAG = "MainActivity";

    //Gragments
    TourFragment tourFragment = new TourFragment();
    AboutsFragment aboutsFragment = new AboutsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initFragment();

        initBottomBar();
    }

    private void initFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.activity_main_container, tourFragment, "Tour");

        transaction.add(R.id.activity_main_container, aboutsFragment, "About");
        transaction.hide(aboutsFragment);

        transaction.commitAllowingStateLoss();

    }

    private void initBottomBar(){
        mBottomNavigation = (BottomNavigationView) findViewById(R.id.main_bottomnav);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch(item.getItemId()){
                    case R.id.navigation_tour :
                        Log.d(TAG,"tour clicked");
                        transaction.show(tourFragment);

                        transaction.hide(aboutsFragment);

                        transaction.commitAllowingStateLoss();
                        break;
                    case R.id.navigation_promo :
                        Log.d(TAG,"promo clicked");
                        transaction.show(aboutsFragment);

                        transaction.hide(tourFragment);

                        transaction.commitAllowingStateLoss();
                        break;
                }

                return true;

            }
        });
    }

}
