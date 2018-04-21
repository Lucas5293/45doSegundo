package com.mthumb.a45dosegundo;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener/*, AdapterView.OnItemSelectedListener*/ {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        /*Spinner times = (Spinner) findViewById(R.id.spinner_times);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.times_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        times.setAdapter(adapter);*/



    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();
        if (id == R.id.nav_home) {
            fragmentManager.beginTransaction()
                    .replace(R.id.troca, new ContentFragment())
                    .commit();
        } else if (id == R.id.nav_escalacao) {
            fragmentManager.beginTransaction()
                    .replace(R.id.troca, new EscalaFragment())
                    .commit();
        } else if (id == R.id.nav_config) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //ImageView time = (ImageView)findViewById(R.id.logotime);
        switch(0){
            case 0:
                //time.setImageResource(R.mipmap.ic_palmeiras_logo);
                break;
            case 1:
                //time.setImageResource(R.mipmap.ic_santos_logo);
                break;

            case 2:
                //time.setImageResource(R.mipmap.ic_corinthians_logo);
                break;

            case 3:
                //time.setImageResource(R.mipmap.ic_saopaulo_logo);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
}
