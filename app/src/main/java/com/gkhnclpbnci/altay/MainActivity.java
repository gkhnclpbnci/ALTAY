package com.gkhnclpbnci.altay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.gkhnclpbnci.altay.pages.FiksturFragment;
import com.gkhnclpbnci.altay.pages.HaberlerFragment;
import com.gkhnclpbnci.altay.pages.HakkindaFragment;
import com.gkhnclpbnci.altay.pages.MagazaFragment;
import com.gkhnclpbnci.altay.pages.PuanDurumuFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    ImageView imageView;
    Button button;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    ListView lw_SlideMenu;
    SlideMenuAdapter adapter;

    List<SlideMenuItem> items;
    String[] titles;
    CharSequence actionBarTitle, appTitle;
    String fragment_name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lw_SlideMenu = (ListView) findViewById(R.id.lw_Menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        imageView = (ImageView)findViewById(R.id.imageView1);
        button = (Button)findViewById(R.id.button1);

       // imageView.setVisibility(View.INVISIBLE);



        // Menü başlıklarını kaynak dosyasından çekiyor
        titles = getResources().getStringArray(R.array.slidemenu_item);
        items = new ArrayList<SlideMenuItem>();

        items.add(new SlideMenuItem(titles[0]));
        items.add(new SlideMenuItem(titles[1]));
        items.add(new SlideMenuItem(titles[2]));
        items.add(new SlideMenuItem(titles[3]));
        items.add(new SlideMenuItem(titles[4]));

        appTitle=getSupportActionBar().getTitle();
        actionBarTitle=items.get(0).getTitle();

        // Menüdeki her list item a click veriyor
        lw_SlideMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                displayPage(i);
                // Her item a tıklanıldığında actionBar daki görünen başlığı değiştiriyor
                actionBarTitle = items.get(i).getTitle();

                // menü tıklamadan sonra kapanıyor
                drawerLayout.closeDrawer(lw_SlideMenu);
            }
        });

        // Oluşturduğumuz adapter nesnesini listview e set ediyoruz.
        adapter = new SlideMenuAdapter(items, getApplicationContext());
        lw_SlideMenu.setAdapter(adapter);

        // Toggle butonuna click veriyoruz, home butonu gibi davranmasını sağlıyor.
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // toggle nesnesi oluşturuyoruz.
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.opened, R.string.closed) {

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(appTitle);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(actionBarTitle);

            }
        };

        // toggle açılıp kapanmasına göre, toggle iconu değiştiriyor.
        toggle.syncState();
        // menü açılıp kapanmasını dinliyoruz.
        drawerLayout.setDrawerListener(toggle);
        displayPage(0);

    }

    private  void displayPage(int position){
        Fragment fragment=null;
        switch (position)
        {
            case 0:
                fragment=new HaberlerFragment();
                fragment_name="HaberlerFragment";
                break;
            case  1:
                fragment=new PuanDurumuFragment();
                fragment_name="PuanDurumuFragmet";
                break;
            case 2:
                fragment=new FiksturFragment();
                fragment_name="FiksturFragment";
                break;
            case 3:
                fragment=new MagazaFragment();
                fragment_name="MagazaFragment";
                break;
            case 4:
                fragment=new HakkindaFragment();
                fragment_name="HakkindaFragmemt";
                default:
                    break;
        }
        if (fragment!=null){

            FragmentManager fragmentManager =getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container,fragment).addToBackStack(fragment_name).commit();

            int count =getSupportFragmentManager().getBackStackEntryCount();
            if(count!=0){
                FragmentManager.BackStackEntry backStackEntry=getSupportFragmentManager().getBackStackEntryAt(count-1);

                if(backStackEntry.getName().contains(fragment_name)){
                    getSupportFragmentManager().popBackStack();
                }
            }

        }
    }
    @Override
    public void onBackPressed(){
        if(getSupportFragmentManager().getBackStackEntryCount()!=1)
            super.onBackPressed();
        else {
            finish();
            System.exit(0);
        }
    }

    @Override
    public void setTitle(CharSequence title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // toggle icona tıklanıldığında menünün açılmasını sağlıyor
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void gönder(View view) {
        Toast.makeText(getApplicationContext(),"Arkaplan Rengi Değişti.", Toast.LENGTH_LONG).show();
    }
}