package com.progmob.letstour;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.goka.kenburnsview.LoopViewPager;
import com.progmob.letstour.adapter.CountriesAdapter;
import com.progmob.letstour.data.CountryData;
import com.progmob.letstour.databinding.ActivityMainBinding;
import com.progmob.letstour.model.ModelCountry;
import com.progmob.letstour.utils.DrawerMenu;
import com.progmob.letstour.utils.KenBurnsEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

//    Integer[] IMAGE_RESOUCE;
    String[] IMAGE_RESOUCE;

    RecyclerView countriesRecyclerView;
    CountriesAdapter adapter;

    Boolean session = false;

    private ArrayList<ModelCountry> list = new ArrayList<>();

    //TAG
    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        setComponentView();

//        IMAGE_RESOUCE = new Integer[]{
//                R.drawable.dashboard_header1,
//                R.drawable.dashboard_header2,
//                R.drawable.dashboard_header3,
//        };

        IMAGE_RESOUCE = new String[]{
                "https://experienceluxury.co/wp-content/uploads/2015/08/Rock-Bar-night.jpg",
                "https://balicheapesttours.com/dummy/bali-tour-package9.jpg",
                "https://cdn.rentalmobilbali.net/wp-content/uploads/2013/11/Tari-Kecak-Ubud.jpg",
                "https://www.francetourisme.fr/media/illus/illus_3.jpg",
        };

        initializeKenBurnsView();
        setCountriesRecyclerView();

        if(getIntent().getExtras() != null){
            Bundle extras = getIntent().getExtras();
            if(extras.getString("from") != null){
                if(extras.getString("from").equals("Register")){
                    SweetAlertDialog sDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE);
                    sDialog.setTitle("Success !");
                    sDialog.setContentText("You are now registered and logged in");
                    sDialog.show();
                }
                if(extras.getString("from").equals("Booking")){
                    SweetAlertDialog sDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE);
                    sDialog.setTitle("Success !");
                    sDialog.setContentText("You just booked a Tour. Please wait until the tour provider approve your booking.");
                    sDialog.show();
                }
            }
        }

    }

    private void setComponentView(){

        this.setSupportActionBar(binding.toolbar);
        ActionBar ab = this.getSupportActionBar();
        ab.setTitle("");
//
        DrawerMenu drawer = new DrawerMenu();
        drawer.createDrawer(this, this, binding.toolbar);

    }

    private void setCountriesRecyclerView(){

        list.addAll(CountryData.getListData());

        countriesRecyclerView = findViewById(R.id.main_countries_recyclerview);

        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        CountriesAdapter cardStartupAdapter = new CountriesAdapter(this);
        cardStartupAdapter.setList(list);
        countriesRecyclerView.setAdapter(cardStartupAdapter);

    }

    private void initializeKenBurnsView(){
        // KenBurnsView
        final KenBurnsEffect kenBurnsView = findViewById(R.id.ken_burns_view);
        kenBurnsView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // File path, or a uri or url
        List<String> urls = Arrays.asList(IMAGE_RESOUCE);
//        kenBurnsView.initResourceIDs(urls);
        kenBurnsView.initStrings(urls);

        // ResourceID
        //List<Integer> resourceIDs = Arrays.asList(SampleImages.IMAGES_RESOURCE);
        //kenBurnsView.loadResourceIDs(resourceIDs);

        // MIX (url & id)
        //List<Object> mixingList = Arrays.asList(SampleImages.IMAGES_MIX);
        //kenBurnsView.loadMixing(mixingList);

        // LoopViewListener
        LoopViewPager.LoopViewPagerListener listener = new LoopViewPager.LoopViewPagerListener() {
            @Override
            public View OnInstantiateItem(int page) {
                TextView counterText = new TextView(getApplicationContext());
                counterText.setText("");
                counterText.setVisibility(View.GONE);
                return counterText;
            }

            @Override
            public void onPageScroll(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                kenBurnsView.forceSelected(position);
            }

            @Override
            public void onPageScrollChanged(int page) {
            }
        };

        // LoopView
        LoopViewPager loopViewPager = new LoopViewPager(this, urls.size(), listener);

        //LoopViewPager loopViewPager = new LoopViewPager(this, resourceIDs.size(), listener);

        //LoopViewPager loopViewPager = new LoopViewPager(this, mixingList.size(), listener);


        FrameLayout viewPagerFrame = (FrameLayout) findViewById(R.id.view_pager_frame);
        viewPagerFrame.addView(loopViewPager);

        kenBurnsView.setPager(loopViewPager);
    }

}
