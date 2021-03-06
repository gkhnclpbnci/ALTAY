package com.gkhnclpbnci.altay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ALTAY on 19.4.2017.
 */

public class SlideMenuAdapter extends BaseAdapter {

    private List<SlideMenuItem> items;
    private TextView txt_title;
    private Context ctx;

    public  SlideMenuAdapter(List<SlideMenuItem> items,Context context){
        this.items=items;
        this.ctx=context;

    }
    //Mevcut item sayısını verir
    @Override
    public  int getCount(){
        return  items.size();
    }

    //Position ı verilen item ı verir
    @Override
    public  Object getItem(int position){
        return  items.get(position);
    }

    //Item position ı verir
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Custom view yükler
    @Override
    public View getView(int position, View view, ViewGroup viewGroup){

        //Her list item için custom tasarım yüklüyor
        if(view==null){
            view= LayoutInflater.from(ctx).inflate(R.layout.slidemenu_item,null);

            //Yeni tasarım içindeki title textine ulaşıp, veriyi set ediyor
            txt_title=(TextView)view.findViewById(R.id.txt_title);
            txt_title.setText(items.get(position).getTitle());
            return  view;
        }
        return null;
    }


}
