package com.progmob.letstour.mainfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.goka.kenburnsview.LoopViewPager;
import com.progmob.letstour.R;
import com.progmob.letstour.TourListActivity;
import com.progmob.letstour.adapter.CountriesAdapter;
import com.progmob.letstour.data.CountryData;
import com.progmob.letstour.model.ModelCountry;
import com.progmob.letstour.utils.DrawerMenu;
import com.progmob.letstour.utils.KenBurnsEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TourFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TourFragment extends Fragment {

    //    Integer[] IMAGE_RESOUCE;
    String[] IMAGE_RESOUCE;

    RecyclerView countriesRecyclerView;
    CountriesAdapter adapter;
    BottomNavigationView mBottomNavigation;

    Toolbar mToolbar;

    //Categories
    LinearLayout mRecreational, mCultural, mNature, mPleasure, mReligious, mAdventour;

    ConstraintLayout rootView;

    Boolean session = false;

    private ArrayList<ModelCountry> list = new ArrayList<>();

    //TAG
    final String TAG = "MainActivity";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TourFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TourFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TourFragment newInstance(String param1, String param2) {
        TourFragment fragment = new TourFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (ConstraintLayout) inflater.inflate(R.layout.fragment_tour, container, false);

        if(getActivity().getIntent().getExtras() != null){
            Bundle extras = getActivity().getIntent().getExtras();
            if(extras.getString("from") != null){
                if(extras.getString("from").equals("Register")){
                    SweetAlertDialog sDialog = new SweetAlertDialog(getContext(), SweetAlertDialog.SUCCESS_TYPE);
                    sDialog.setTitle("Success !");
                    sDialog.setContentText("You are now registered and logged in");
                    sDialog.show();
                }
                if(extras.getString("from").equals("Booking")){
                    SweetAlertDialog sDialog = new SweetAlertDialog(getContext(), SweetAlertDialog.SUCCESS_TYPE);
                    sDialog.setTitle("Success !");
                    sDialog.setContentText("You just booked a Tour. Please wait until the tour provider approve your booking.");
                    sDialog.show();
                }
            }
        }

        IMAGE_RESOUCE = new String[]{
                "https://experienceluxury.co/wp-content/uploads/2015/08/Rock-Bar-night.jpg",
                "https://balicheapesttours.com/dummy/bali-tour-package9.jpg",
                "https://cdn.rentalmobilbali.net/wp-content/uploads/2013/11/Tari-Kecak-Ubud.jpg",
                "https://www.francetourisme.fr/media/illus/illus_3.jpg",
        };

        setComponentView();
        initializeKenBurnsView();
        setCountriesRecyclerView();

        return rootView;
    }


    private void setComponentView(){

        mToolbar = rootView.findViewById(R.id.toolbar);

        ((AppCompatActivity) getContext()).setSupportActionBar(mToolbar);
        ActionBar ab = ((AppCompatActivity) getContext()).getSupportActionBar();
        ab.setTitle("");
//
        DrawerMenu drawer = new DrawerMenu();
        drawer.createDrawer(getContext(), ((AppCompatActivity) getActivity()), mToolbar);

        mBottomNavigation = rootView.findViewById(R.id.main_bottomnav);

        mRecreational = rootView.findViewById(R.id.recreational);
        mRecreational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TourListActivity.class); // gets the previously created intent
                intent.putExtra("tipe", "1");
                intent.putExtra("id", "1");
                intent.putExtra("name","recreational");
                intent.putExtra("image", "https://www.mountainphotography.com/images/xl/20140226-Bridge-of-Heaven-Night.jpg");
                startActivity(intent);
            }
        });

        mCultural = rootView.findViewById(R.id.cultural);
        mCultural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TourListActivity.class); // gets the previously created intent
                intent.putExtra("tipe", "1");
                intent.putExtra("id", "2");
                intent.putExtra("name","Cultural");
                intent.putExtra("image", "https://www.mountainphotography.com/images/xl/20140226-Bridge-of-Heaven-Night.jpg");
                startActivity(intent);
            }
        });

        mNature = rootView.findViewById(R.id.nature);
        mNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TourListActivity.class); // gets the previously created intent
                intent.putExtra("tipe", "1");
                intent.putExtra("id", "3");
                intent.putExtra("name","Nature");
                intent.putExtra("image", "https://www.mountainphotography.com/images/xl/20140226-Bridge-of-Heaven-Night.jpg");
                startActivity(intent);
            }
        });

        mPleasure = rootView.findViewById(R.id.pleasure);
        mPleasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TourListActivity.class); // gets the previously created intent
                intent.putExtra("tipe", "1");
                intent.putExtra("id", "4");
                intent.putExtra("name","Pleasure");
                intent.putExtra("image", "https://www.mountainphotography.com/images/xl/20140226-Bridge-of-Heaven-Night.jpg");
                startActivity(intent);
            }
        });

        mReligious = rootView.findViewById(R.id.religious);
        mReligious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TourListActivity.class); // gets the previously created intent
                intent.putExtra("tipe", "1");
                intent.putExtra("id", "4");
                intent.putExtra("name","Religious");
                intent.putExtra("image", "https://www.mountainphotography.com/images/xl/20140226-Bridge-of-Heaven-Night.jpg");
                startActivity(intent);
            }
        });

        mAdventour = rootView.findViewById(R.id.adventour);
        mAdventour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TourListActivity.class); // gets the previously created intent
                intent.putExtra("tipe", "1");
                intent.putExtra("id", "4");
                intent.putExtra("name","Adventour");
                intent.putExtra("image", "https://www.mountainphotography.com/images/xl/20140226-Bridge-of-Heaven-Night.jpg");
                startActivity(intent);
            }
        });

    }

    private void setCountriesRecyclerView(){

        list.addAll(CountryData.getListData());

        countriesRecyclerView = rootView.findViewById(R.id.main_countries_recyclerview);

        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        CountriesAdapter cardStartupAdapter = new CountriesAdapter(getContext());
        cardStartupAdapter.setList(list);
        countriesRecyclerView.setAdapter(cardStartupAdapter);

    }

    private void initializeKenBurnsView(){
        // KenBurnsView
        final KenBurnsEffect kenBurnsView = rootView.findViewById(R.id.ken_burns_view);
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
                TextView counterText = new TextView(getContext());
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
        LoopViewPager loopViewPager = new LoopViewPager(getContext(), urls.size(), listener);
        FrameLayout viewPagerFrame = (FrameLayout) rootView.findViewById(R.id.view_pager_frame);
        viewPagerFrame.addView(loopViewPager);

        kenBurnsView.setPager(loopViewPager);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
