package com.progmob.letstour;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.goka.kenburnsview.LoopViewPager;
import com.progmob.letstour.adapter.CountriesAdapter;
import com.progmob.letstour.data.CountryData;
import com.progmob.letstour.model.ModelCountry;
import com.progmob.letstour.utils.DrawerMenu;
import com.progmob.letstour.utils.KenBurnsEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {


//    Integer[] IMAGE_RESOUCE;
    String[] IMAGE_RESOUCE;

    RecyclerView countriesRecyclerView;
    CountriesAdapter adapter;
    BottomNavigationView mBottomNavigation;

    Boolean session = false;

    private ArrayList<ModelCountry> list = new ArrayList<>();

    //TAG
    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        replaceFragment(new TourFragment());

        initBottomBar();
    }

    private void initBottomBar(){
        mBottomNavigation = (BottomNavigationView) findViewById(R.id.main_bottomnav);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        fragment = new TourFragment();
                        break;

                    case R.id.navigation_tour:
                        fragment = new AboutsFragment();
                        break;

                }

                return replaceFragment(fragment);
            }
        });
    }

    public boolean replaceFragment (Fragment fragment){
        String backStateName =  fragment.getClass().getName();
        String fragmentTag = backStateName;

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);
        FragmentTransaction ft = manager.beginTransaction();
        if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null){ //fragment not in back stack, create it.
            ft.replace(R.id.activity_main_container, fragment, fragmentTag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(fragmentTag);
            ft.commit();
            return true;
        }
        return true;
    }

}
