package com.gkhnclpbnci.altay.pages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gkhnclpbnci.altay.R;

/**
 * Created by ALTAY on 13.5.2017.
 */

public class ListViewAdapter extends BaseAdapter {

    Context mcontext;
    String[] haber_baslik;
    String[] haber_detay;
    int[] haber_icon_int;
    LayoutInflater inflater;


    public ListViewAdapter(Context context, String[] haber_baslik, String[] haber_detay, int[] haber_icon_int) {
        mcontext =context;
        this.haber_baslik = haber_baslik;

        this.haber_detay= haber_detay;

        this.haber_icon_int =haber_icon_int;
    }

    @Override
    public int getCount() {
        return haber_baslik.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {



        TextView haber_baslik_textview;

        // TextView haber_detay_textview;

        ImageView haber_icon_imageView;

        inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_item_row,null);


        haber_baslik_textview = (TextView) itemView.findViewById(R.id.haber_baslik);

        // haber_detay_textview = (TextView) itemView.findViewById(R.id.haber_detay);

        haber_icon_imageView = (ImageView) itemView.findViewById(R.id.haber_icon);

        haber_baslik_textview.setText(haber_baslik[position]);

        //  haber_detay_textview.setText(haber_detay[position]);

        haber_icon_imageView.setImageResource(haber_icon_int[position]);


        return itemView;
    }
}
