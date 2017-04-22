package com.gkhnclpbnci.altay.pages;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gkhnclpbnci.altay.MainActivity;
import com.gkhnclpbnci.altay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HaberlerFragment extends Fragment {

    Activity titleChange;


    public HaberlerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        titleChange.setTitle("Haberler");
        return inflater.inflate(R.layout.fragment_haberler, container, false);
    }

    @Override
    public  void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange=(MainActivity) activity;
    }

}
