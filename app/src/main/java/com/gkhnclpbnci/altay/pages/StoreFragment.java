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
public class StoreFragment extends Fragment {
    Activity titleChange;
    public StoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        titleChange.setTitle("Mağaza");
        View rootView =  inflater.inflate(R.layout.fragment_store, container, false);

        return rootView;
    }

    /**
     * //TODO
     * 1- Türkçe karakter yok
     * 2- Fonksiyonlar kısa ve öz isimde olmalı
     * 3- Yeniden kullanılabilinir en fazla 50 satırlık uzunlukta fonksiyonlar olmalı
     * 4- Her yaptığın modülden sonra commit - push
     * 5- Loglamayı hep uygulayalım
     * Buton tıklamalarnın kontrol edildiği genel fonksiyondur. Şuralarda ve şuralarda çağrılıyor.
     */


    @Override
    public  void onAttach(Activity activity){
        super.onAttach(activity);
        titleChange=(MainActivity) activity;
    }

}
