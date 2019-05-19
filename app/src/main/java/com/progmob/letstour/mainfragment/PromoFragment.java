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

import com.progmob.letstour.R;
import com.progmob.letstour.TourListActivity;
import com.progmob.letstour.adapter.CountriesAdapter;
import com.progmob.letstour.adapter.PromoAdapter;
import com.progmob.letstour.data.CountryData;
import com.progmob.letstour.data.PromoData;
import com.progmob.letstour.model.ModelCountry;
import com.progmob.letstour.model.ModelPromo;
import com.progmob.letstour.utils.DrawerMenu;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PromoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PromoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PromoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    PromoAdapter adapter;
    BottomNavigationView mBottomNavigation;
    RecyclerView mRecyclerview;


    Toolbar mToolbar;
    ConstraintLayout rootView;
    private ArrayList<ModelPromo> list = new ArrayList<>();


    public PromoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PromoFragment newInstance(String param1, String param2) {
        PromoFragment fragment = new PromoFragment();
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
        rootView = (ConstraintLayout) inflater.inflate(R.layout.fragment_promo, container, false);
        setComponentView();

        setRecyclerView();

        return rootView;
    }

    private void setComponentView(){

        mToolbar = rootView.findViewById(R.id.toolbar);

        ((AppCompatActivity) getContext()).setSupportActionBar(mToolbar);
        ActionBar ab = ((AppCompatActivity) getContext()).getSupportActionBar();
        ab.setTitle("");

        DrawerMenu drawer = new DrawerMenu();
        drawer.createDrawer(getContext(), ((AppCompatActivity) getActivity()), mToolbar);

    }

    private void setRecyclerView(){

        list.addAll(PromoData.getListData());

        mRecyclerview = rootView.findViewById(R.id.bottom_recyclerview);

        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PromoAdapter(getContext());
        adapter.setList(list);
        mRecyclerview.setAdapter(adapter);

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
