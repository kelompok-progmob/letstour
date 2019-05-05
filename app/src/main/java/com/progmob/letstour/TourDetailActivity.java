package com.progmob.letstour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.progmob.letstour.databinding.ActivityTourDetailBinding;
import com.squareup.picasso.Picasso;

public class TourDetailActivity extends AppCompatActivity {

    ActivityTourDetailBinding binding;


    final static String TAG = "TourDetail";

    NestedScrollView mScroller;
    Toolbar mToolbar;
    AppBarLayout mAppBar;
    float opacity = 0;
    String id, name, image, location, subtitle, description, price, overview, preparation;

    SharedPreferences sharedpreferences;
    Boolean session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tour_detail);

        Bundle extras = getIntent().getExtras();
        name = extras.getString("name");
        image = extras.getString("image");
        location = extras.getString("location");
        subtitle = extras.getString("subtitle");
        description = extras.getString("description");
        price = extras.getString("price");
        overview = extras.getString("overview");
        preparation = extras.getString("preparation");

        Picasso.with(TourDetailActivity.this)
                .load(image)
                .placeholder(R.drawable.placeholder_vertical)
                .into(binding.image);

        binding.name.setText(name);
        binding.location.setText(location);
        binding.description.setText(description);
        binding.price.setText(price);
        binding.overview.setText(overview);
        binding.preparation.setText(preparation);

        setHeader();

    }

    private void setHeader(){
        mScroller = (NestedScrollView) findViewById(R.id.nestedScrollView);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mAppBar = (AppBarLayout) findViewById(R.id.appBarLayout);

        mToolbar.setTitle("Detail Tour");
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

//    private void settingBtnBottom(){
//        if (status.equals("fragment")) {
//            binding.tourDetailBtnListTraveler.setVisibility(View.VISIBLE);
//            binding.tourDetailBtnBook.setVisibility(View.GONE);
//        }
//
//        binding.tourDetailBtnListTraveler.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TourDetailActivity.this, ListTravelerActivity.class);
//                intent.putExtra("id", id);
//                startActivity(intent);
//            }
//        });
//    }

}
