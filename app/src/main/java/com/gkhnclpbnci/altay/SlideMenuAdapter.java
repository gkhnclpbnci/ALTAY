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
    @Override
    public  int getCount(){
        return  items.size();
    }

    @Override
    public  Object getItem(int position){
        return  items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup){

        if(view==null){
            view= LayoutInflater.from(ctx).inflate(R.layout.slidemenu_item,null);

            txt_title=(TextView)view.findViewById(R.id.txt_title);
            txt_title.setText(items.get(position).getTitle());
            return  view;
        }
        return null;
    }


}
