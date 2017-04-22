package com.gkhnclpbnci.altay.pages;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gkhnclpbnci.altay.MainActivity;
import com.gkhnclpbnci.altay.R;


public class FixtureFragment extends Fragment {

    Activity titleChange;


    public FixtureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        titleChange.setTitle("Fikstür");
        View rootView =inflater.inflate(R.layout.fragment_fixture, container, false);

        return rootView;
    }

    @Override
    public  void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange=(MainActivity) activity;
    }

}