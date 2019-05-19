package com.progmob.letstour;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.progmob.letstour.adapter.ActTourAdapter;
import com.progmob.letstour.adapter.CountriesAdapter;
import com.progmob.letstour.adapter.PopTourAdapter;
import com.progmob.letstour.data.TourData;
import com.progmob.letstour.model.ModelTour;

import java.util.ArrayList;

public class TourListActivity extends AppCompatActivity {


    RecyclerView topRv, bottomRv;
    CountriesAdapter adapter;

    String id, name, image, tipe;
    TextView mName;
    ImageView mImage;
    Toolbar mToolbar;
    NestedScrollView mScroller;
    AppBarLayout mAppBar;
    float opacity = 0;

    private ArrayList<ModelTour> list = new ArrayList<>();
    private ArrayList<ModelTour> bottomList = new ArrayList<>();

    //TAG
    final String TAG = "TourListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_list);

        Bundle extras = getIntent().getExtras();
        tipe = extras.getString("tipe");
        id = extras.getString("id");
        name = extras.getString("name");
        image = extras.getString("image");

        mName = findViewById(R.id.title);
        mImage = findViewById(R.id.list_imageHeader);

        mName.setText(name);

        Glide.with(this)
                .load(image)
                .thumbnail(Glide.with(this).load(R.drawable.placeholder))
                .into(mImage);

//        initializeToolbar();

        setPopTourRecyclerview();
        setActTourRecyclerview();

    }

    public void setPopTourRecyclerview(){

        list.addAll(TourData.getListData(1, Integer.valueOf(id)));

        topRv = findViewById(R.id.top_recyclerview);

        topRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        PopTourAdapter adapter = new PopTourAdapter(this);
        adapter.setList(list);
        topRv.setAdapter(adapter);

    }

    public void setActTourRecyclerview(){

        bottomList.addAll(TourData.getListData(0, Integer.valueOf(id)));

        bottomRv = findViewById(R.id.bottom_recyclerview);

        bottomRv.setLayoutManager(new LinearLayoutManager(this));
        ActTourAdapter adapter = new ActTourAdapter(this);
        adapter.setList(bottomList);
        bottomRv.setAdapter(adapter);
        bottomRv.setNestedScrollingEnabled(false);


    }

    private void initializeToolbar(){
        mScroller = (NestedScrollView) findViewById(R.id.activity_tour_nestedScrollView);
        mAppBar = (AppBarLayout) findViewById(R.id.activity_tour_appBarLayout);
        mToolbar = (Toolbar) findViewById(R.id.activity_tour_toolbar);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
            upArrow.setColorFilter(Color.argb(255,255,255,255), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }

        if (mScroller != null) {
            mScroller.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//              scroll down
                    if (scrollY > oldScrollY) {
                        if (scrollY > 100 && scrollY <= 400){
                            settingToolbar(scrollY);
                        }
                    }
//              scroll up
                    if (scrollY < oldScrollY) {
                        if (scrollY > 100 && scrollY <= 400){
                            settingToolbar(scrollY);
                        }
                    }
//               on the line
                    if (scrollY >= 400){
                        mAppBar.setElevation(6);
                        int color = 135;

                        if (getSupportActionBar() != null){
                            Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
                            upArrow.setColorFilter(Color.argb(255,color,color,color), PorterDuff.Mode.SRC_ATOP);
                            getSupportActionBar().setHomeAsUpIndicator(upArrow);
                        }

                        mToolbar.setTitleTextColor(Color.argb(255,color,color,color));
                        mToolbar.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    }

//                check for top
                    if (scrollY == 0) {
                        mAppBar.setElevation(0);
                        mToolbar.setTitleTextColor(Color.argb(255,255,255,255));
                        mToolbar.setBackgroundColor(Color.argb(0, 255, 255, 255));
                        mAppBar.bringToFront();
                    }

//                check for bottom
//                if (scrollY == ( v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight() )) {
//                    Log.i(TAG, "BOTTOM SCROLL");
//                }
                }
            });
        }
    }

    private void settingToolbar(int scrollY){

        opacity = ((float)scrollY - 100) / 400;
        mAppBar.setElevation(opacity * 6);
        int color = 255 - (int)(120 * (float)opacity);

        if (getSupportActionBar() != null){
            Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
            upArrow.setColorFilter(Color.argb(255,255,255,255), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }

        mToolbar.setTitleTextColor(Color.argb(255,255,255,255));
        mToolbar.setBackgroundColor(Color.argb((int)(opacity * 255), 255, 255, 255));
    }

}
