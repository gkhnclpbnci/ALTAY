package com.gkhnclpbnci.altay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HaberDetay extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haber_detay);

        text = (TextView) findViewById(R.id.txt_detay);
        String haber_detay = getIntent().getStringExtra("haber_detay");
        text.setText(haber_detay);
    }
}
