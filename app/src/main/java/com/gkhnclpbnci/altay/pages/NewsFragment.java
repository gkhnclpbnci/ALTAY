package com.gkhnclpbnci.altay.pages;


import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gkhnclpbnci.altay.MainActivity;
import com.gkhnclpbnci.altay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    ListView list;
    ListViewAdapter adapter;
    private String[] haber_baslik;
    private String[] haber_detay;
    private TypedArray haber_icon;
    private int[] haber_icon_int;
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

        haber_baslik  =getResources().getStringArray(R.array.haber_baslik);
        haber_detay  =getResources().getStringArray(R.array.haber_detay_array);
        haber_icon  = getResources().obtainTypedArray(R.array.icon_array);
        haber_icon_int = new int[haber_icon.length()];

        for(int i = 0;i<haber_icon.length();i++){
            haber_icon_int[i] = haber_icon.getResourceId(i, -1);
        }



        haber_icon.recycle();


        list = (ListView) rootView.findViewById(R.id.haberlist);

        adapter = new ListViewAdapter(getContext(), haber_baslik, haber_detay, haber_icon_int);

        list.setAdapter(adapter);

      /*  list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Intent i = new Intent(MainActivity.this, HaberDetay.class);

                i.putExtra("haber_detay", haber_detay[position]);

                startActivity(i);
            }

        });*/

        return  rootView;

    }

    @Override
    public  void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange=(MainActivity) activity;
    }

}
