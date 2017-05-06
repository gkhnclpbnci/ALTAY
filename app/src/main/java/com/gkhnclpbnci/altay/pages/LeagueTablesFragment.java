package com.gkhnclpbnci.altay.pages;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.gkhnclpbnci.altay.MainActivity;
import com.gkhnclpbnci.altay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeagueTablesFragment extends Fragment {

    WebView puan;

    Activity titleChange;
    public LeagueTablesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        titleChange.setTitle("Puan Durumu");

        View rootView = inflater.inflate(R.layout.fragment_leaguetables, container, false);
        puan=(WebView)rootView.findViewById(R.id.puan_durumu);
        String html = "<iframe src=\"http://www.skyturks.com/2_3_lig_ekle/3_lig_1_grup_puan_durumu_ekle.asp\" scrolling=\"no\" frameborder=\"0\" marginwidth=\"0\" marginheight=\"0\" align=\"top\" width=\"385\" height=\"485\" name=\"I6\"></iframe>";
        puan.loadData(html, "text/html", null);

        return rootView;
    }

    @Override
    public  void onAttach(Activity activity){
        super.onAttach(activity);

        titleChange=(MainActivity) activity;
    }

}
