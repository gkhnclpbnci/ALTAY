package com.gkhnclpbnci.altay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class HaberDetay extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haber_detay);

        text = (TextView) findViewById(R.id.txt_detay);
        String haber_detay = getIntent().getStringExtra("haber_detay");
        text.setText(haber_detay);
        int image_detay = getIntent().getIntExtra("image_detay",-1);

        if(image_detay!=-1)
        {

            ImageView newsImageView = (ImageView) findViewById(R.id.haber_image_view);
            newsImageView.setImageResource(image_detay);

        }

//        Picasso.with(this).load(image_detay).into(newsImageView);
    }
}
