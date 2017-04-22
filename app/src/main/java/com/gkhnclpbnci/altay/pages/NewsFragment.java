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
public class NewsFragment extends Fragment {

    Activity titleChange;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        titleChange.setTitle("Haberler");
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        return rootView;
    }

    @Override
    public  void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange=(MainActivity) activity;
    }

}
